package com.ssh.code.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.code.dao.IUserDao;
import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;
import com.ssh.code.entity.User;
import com.ssh.code.service.IUserService;
import com.ssh.code.view.R;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	public User login(User user) {
		//调用Dao层查询数据库
		
		return userDao.findUserByNameAndPwd(user);
		
	}

	public Set<Privilege> loadPrivilegesByRId(Integer rId) {
		// TODO Auto-generated method stub
		return userDao.getPrivilegesByRId(rId);
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return userDao.getRoleList();
	}

	public R saveUser(User user) {
		// TODO Auto-generated method stub
		R r = null;
		
		User findUser = userDao.findUserByName(user.getUName());
		
		if(findUser==null) {
			
			boolean flag = userDao.saveUser(user);
			
			if(flag) {
				
				r = R.ok("新增成功！");
			}
			
		}else {
			
			r = R.error("该用户名已存在！");
		}
		
		return r;
	}

	public R updateUser(User user) {
		// TODO Auto-generated method stub
		
		R r = null;
		
		User findUser = userDao.findUserByName(user.getUName());
		
		if(findUser==null || (findUser!=null&&findUser.getUId().intValue()==user.getUId().intValue())) {
			
			boolean flag = userDao.updateUser(user);
			
			if(flag) {
				
				userDao.updateUser(user);
				
				r = R.ok("修改成功！");
			}
			
		}else {
			
			r = R.error("该用户名已重复，请重新修改！");
		}
		
		return r;
	}


	public void updateUsersStatus(Integer[] uIds, int status) {
		// TODO Auto-generated method stub
		userDao.updateUsersStatus(uIds, status);
	}

	public Set<Privilege> loadAllPrivileges() {
		// TODO Auto-generated method stub
		return userDao.loadAllPrivileges();
	}

}
