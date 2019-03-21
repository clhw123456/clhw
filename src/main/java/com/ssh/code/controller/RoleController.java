package com.ssh.code.controller;

import java.util.List;
import java.util.Set;

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
import com.ssh.code.service.IRoleService;
import com.ssh.code.service.IUserService;
import com.ssh.code.view.R;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/toRoleListUI")
	
	public ModelAndView toRoleListUI() {
		
		ModelAndView modelAndView = new ModelAndView("role/list");
		
		return modelAndView;
	}
	
	@RequestMapping("/getRoleList")
	public @ResponseBody JSONArray getRoleList() {
		
		List<Role> roleList = roleService.getRoleList();
		
		JSONArray array = JSONArray.parseArray(JSON.toJSONString(roleList));
		
		return array;
	}
	
	@RequestMapping("/getPrivilegesByRId")
	public @ResponseBody JSONArray getPrivilegesByRId(Integer rId) {
		
		List<Privilege> privileges = roleService.loadPrivilegesByRId(rId);
		
		JSONArray array = JSONArray.parseArray(JSON.toJSONString(privileges));
		
		return array;
		
	}
	
	@RequestMapping("/updatePrivilegesByRId")
	public @ResponseBody R updatePrivilegesByRId(Integer rId, @RequestParam("checkedPrivilegesArray[]") Integer[] checkedPrivilegesArray) {
		
		boolean flag = roleService.updatePrivilegesByRId(rId, checkedPrivilegesArray);
		
		if(flag) {
			return R.ok("修改权限成功！");
		}else {
			
			return R.error("修改权限失败！");
		}
		
		
	}

}
