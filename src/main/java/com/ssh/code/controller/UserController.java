package com.ssh.code.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ssh.code.entity.Privilege;
import com.ssh.code.entity.Role;
import com.ssh.code.entity.User;
import com.ssh.code.service.IUserService;
import com.ssh.code.view.R;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/toLoginUI")
	public ModelAndView toLoginUI() {
		
		ModelAndView modelAndView = new ModelAndView("user/login");
		
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public @ResponseBody R login(User user, HttpSession session) {
		
		//去数据库查询用户是否存在
		User loginUser = userService.login(user);
		
		if(loginUser==null) {
			
			return R.error("用户名或者密码错误！");
		}else {
			
			session.setAttribute("loginUser", loginUser);
			
			return R.ok("登录成功！");
		}
		
	}
	
	@RequestMapping("/toIndexUI")
	public ModelAndView toIndexUI(User user) {
		
		ModelAndView modelAndView = new ModelAndView("index/index");
		
		return modelAndView;
	}
	
	@RequestMapping("/loadPrivilegesByUId")
	public @ResponseBody R loadPrivilegesByUId(HttpSession httpSession) {
		
		User loginUser = (User) httpSession.getAttribute("loginUser");
		
		Set<Privilege> privileges = null;
		
		if(loginUser.getSuperMan().intValue()==1) {
			
			//超级管理员显示所有菜单
			privileges = userService.loadAllPrivileges();
		}else {
			
			privileges = userService.loadPrivilegesByRId(loginUser.getRole().getRId());
		}
		
		httpSession.setAttribute("privileges", privileges);
		
		return R.ok("加载成功！");
	}
	
	@RequestMapping("/getPrivilegeInSession")
	public @ResponseBody JSONArray getPrivilegeInSession(HttpSession session) {
		
		Set<Privilege> privileges = (Set<Privilege>) session.getAttribute("privileges");
		
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(privileges));
		
		return array;
	}
	
	@RequestMapping("/toUserListUI")
	public ModelAndView toUserListUI() {
		
		ModelAndView modelAndView = new ModelAndView("user/list");
		
		return modelAndView;
	}
	
	@RequestMapping("/getUserList")
	public @ResponseBody JSONArray getUserList(){
		
		List<User> userList = userService.getUserList();
		
		/*
		 * for(int i=0;i<userList.size();i++) {
		 * 
		 * userList.get(i).getRole(); }
		 */
		
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(userList));
		
		return array;
		
	}
	
	@RequestMapping("/getRoleList")
	public @ResponseBody JSONArray getRoleList() {
		
		List<Role> roleList = userService.getRoleList();
		
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(roleList));
		
		return array;
	}
	
	@RequestMapping("/saveUser")
	public @ResponseBody R saveUser(User user) {
		
		R r = userService.saveUser(user);
		
		return r;
		
	}
	
	@RequestMapping("/updateUser")
	public @ResponseBody R updateUser(User user) {
		
		R r = userService.updateUser(user);
		
		return r;
		
	}
	
	@RequestMapping("/updateUsersStatus")
	public @ResponseBody R updateUsersStatus(@RequestParam("uIds[]") Integer[] uIds, Integer status) {
		
		userService.updateUsersStatus(uIds, status);
		
		if(status==0) {
			
			return R.ok("禁用成功！");
		}else {
			
			return R.ok("启用成功！");
		}
		
		
	}

}
