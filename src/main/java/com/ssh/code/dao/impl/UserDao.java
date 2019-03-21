package com.ssh.code.dao.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.code.dao.IUserDao;
import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;
import com.ssh.code.entity.User;

@Repository
public class UserDao implements IUserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public User findUserByNameAndPwd(User user) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("UName", user.getUName())).add(Restrictions.eq("UPwd", user.getUPwd()));
		
		User loginUser = (User) criteria.uniqueResult();//要么获取不到，要么查询出一条数据
		
		return loginUser;
	}

	public Set<Privilege> getPrivilegesByRId(Integer rId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		Criteria criteria =  session.createCriteria(Role.class).add(Restrictions.idEq(rId));
		
		Role role = (Role) criteria.uniqueResult();
		
		Set<Privilege> privileges = role.getPrivileges();
		
		Set<Privilege> parentIsNotNull = new HashSet<Privilege>();
		
		Iterator<Privilege> it = privileges.iterator();
		
		for(;it.hasNext();) {
			
			Privilege privilege = it.next();
			
			if(privilege.getParent()!=null) {
				
				parentIsNotNull.add(privilege);
			}
		}
		
		privileges.removeAll(parentIsNotNull);
		
		return privileges;
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		List<User> userList = session.createQuery("select new User(u.UId, u.UName, u.status, u.role.RId, u.role.RName) from User u, Role r where u.role.RId=r.RId and u.superMan=0").list();
		
		return userList;
	}

	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		List<Role> roleList = session.createQuery("from Role").list();
		
		return roleList;
	}

	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		user.setUPwd("123456");
		
		user.setSuperMan(0);
		
		Serializable obj = session.save(user);
		
		if(obj!=null) {
			
			return true;
		}else {
			
			return false;
		}
		
	}

	public User findUserByName(String uName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		return (User) session.createQuery("from User u where u.UName = ?").setParameter(0, uName).uniqueResult();
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		user.setSuperMan(0);
		
		SQLQuery sqlQuery = session.createSQLQuery("update user set u_name = ? ,r_id = ? where u_id = ?");
		
		sqlQuery.setParameter(0, user.getUName()).setParameter(1, user.getRole().getRId()).setParameter(2, user.getUId());
		
		int num = sqlQuery.executeUpdate();
		
		if(num>0) {
			
			return true;
		}else {
			
			return false;
		}
		
		
	}

	public void updateUsersStatus(Integer[] uIds, int status) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		StringBuffer sqlBuffer = new StringBuffer("update user set status = ? where u_id in (");
		
		for(int i=0;i<uIds.length;i++) {
			
			sqlBuffer.append("?");
			
			if(i<uIds.length-1) {
				
				sqlBuffer.append(",");
			}
		}
		
		sqlBuffer.append(")");
		
		SQLQuery sqlQuery = session.createSQLQuery(sqlBuffer.toString());
		
		sqlQuery.setParameter(0, status);
		
		for(int i=0;i<uIds.length;i++) {
			
			sqlQuery.setParameter(i+1, uIds[i]);
		}
		
		int num = sqlQuery.executeUpdate();
		
	}

	public Set<Privilege> loadAllPrivileges() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		List<Privilege> privileges = session.createCriteria(Privilege.class).list();
		
		Set<Privilege> privilegesSet = new HashSet<Privilege>();
		
		privilegesSet.addAll(privileges);
		
		Set<Privilege> parentIsNotNull = new HashSet<Privilege>();
		
		Iterator<Privilege> it = privileges.iterator();
		
		for(;it.hasNext();) {
			
			Privilege privilege = it.next();
			
			if(privilege.getParent()!=null) {
				
				parentIsNotNull.add(privilege);
			}
		}
		
		privilegesSet.removeAll(parentIsNotNull);
		
		return privilegesSet;
	}

}
