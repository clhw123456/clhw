package com.ssh.code.service;

import java.util.List;

import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;

public interface IRoleService {

	List<Role> getRoleList();

	List<Privilege> loadPrivilegesByRId(Integer rId);

	boolean updatePrivilegesByRId(Integer rId, Integer[] checkedPrivilegesArray);

}
