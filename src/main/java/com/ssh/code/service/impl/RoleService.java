package com.ssh.code.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.code.dao.IRoleDao;
import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;
import com.ssh.code.service.IRoleService;

@Service
@Transactional
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;

	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return roleDao.getRoleList();
	}

	public List<Privilege> loadPrivilegesByRId(Integer rId) {
		// TODO Auto-generated method stub
		return roleDao.getPrivilegesByRId(rId);
	}

	public boolean updatePrivilegesByRId(Integer rId, Integer[] checkedPrivilegesArray) {
		// TODO Auto-generated method stub
		roleDao.removePrivilegeByRId(rId);
		
		List<Integer> privilegesList = new ArrayList<Integer>();
		
		for(int i=0;i<checkedPrivilegesArray.length;i++) {
			
			privilegesList.add(checkedPrivilegesArray[i]);
		}
		
		for(Integer pId: checkedPrivilegesArray) {
			
			Integer parentId = roleDao.findParentPId(pId);
			
			if(parentId!=null && !privilegesList.contains(parentId)) {
				
				privilegesList.add(parentId);
			}
		}
		
		roleDao.addRolePrivilege(rId, privilegesList);
		
		return true;
	}

}
