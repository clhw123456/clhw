package com.ssh.code.dao;

import java.util.List;
import java.util.Set;

import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;
import com.ssh.code.entity.User;

public interface IUserDao {

	User findUserByNameAndPwd(User user);

	Set<Privilege> getPrivilegesByRId(Integer rId);

	List<User> getUserList();

	List<Role> getRoleList();

	boolean saveUser(User user);

	User findUserByName(String uName);

	boolean updateUser(User user);

	void updateUsersStatus(Integer[] uIds, int status);

	Set<Privilege> loadAllPrivileges();

}
