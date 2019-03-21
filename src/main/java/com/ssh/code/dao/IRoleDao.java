package com.ssh.code.dao;

import java.util.List;
import java.util.Set;

import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;

public interface IRoleDao {

	List<Role> getRoleList();

	List<Privilege> getPrivilegesByRId(Integer rId);

	void removePrivilegeByRId(Integer rId);

	Integer findParentPId(Integer pId);

	void addRolePrivilege(Integer rId, List<Integer> privilegesList);

}
