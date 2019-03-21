package com.ssh.code.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.code.dao.IRoleDao;
import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;

@Repository
public class RoleDao implements IRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		List<Role> roleList = session.createCriteria(Role.class).list();
		
		return roleList;
	}

	public List<Privilege> getPrivilegesByRId(Integer rId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		List<Privilege> privileges = session.createCriteria(Privilege.class).list();
		
		Set<Privilege> parentIsNotNull = new HashSet<Privilege>();
		
		Iterator<Privilege> it = privileges.iterator();
		
		for(;it.hasNext();) {
			
			Privilege privilege = it.next();
			
			if(privilege.getParent()!=null) {
				
				parentIsNotNull.add(privilege);
			}
		}
		
		privileges.removeAll(parentIsNotNull);
		
		List<Object[]> selectedPriileges = session.createSQLQuery("select r_id,p_id from role_privilege where r_id=?").setParameter(0, rId).list();
		
		for(Privilege privilege: privileges) {
			
			Set<Privilege> children = privilege.getChildren();
			
			for(Privilege child : children) {
				
				for(Object[] parentIsNotNullPrivilege: selectedPriileges) {
					
					if(child.getId().intValue()==Integer.parseInt(parentIsNotNullPrivilege[1].toString())) {
						
						child.setChecked(true);
					}
				}
			}
			
		}
		
		return privileges;
	}

	public void removePrivilegeByRId(Integer rId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		int num = session.createSQLQuery("delete from role_privilege where r_id=?").setParameter(0, rId).executeUpdate();
	}

	public Integer findParentPId(Integer pId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		Integer parentId = (Integer) session.createSQLQuery("select parent_id from privilege where p_id=?").setParameter(0, pId).uniqueResult();
		
		return parentId;
	}

	public void addRolePrivilege(Integer rId, List<Integer> privilegesList) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		for(int i=0;i<privilegesList.size();i++) {
			
			session.createSQLQuery("insert into role_privilege(r_id,p_id) values (?,?)").setParameter(0, rId).setParameter(1, privilegesList.get(i)).executeUpdate();
		}
		
		
	}

}
