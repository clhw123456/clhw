package com.ssh.code.service;

import java.util.List;
import java.util.Set;

import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;
import com.ssh.code.entity.User;
import com.ssh.code.view.R;

public interface IUserService {

	User login(User user);

	Set<Privilege> loadPrivilegesByRId(Integer rId);

	List<User> getUserList();

	List<Role> getRoleList();

	R saveUser(User user);

	R updateUser(User user);

	void updateUsersStatus(Integer[] uIds, int status);

	Set<Privilege> loadAllPrivileges();

}
