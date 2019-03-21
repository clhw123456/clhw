package com.ssh.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ssh.code.entity.CodePwd;
import com.ssh.code.service.ICodePwdService;

@Controller
@RequestMapping("/codePwd")
public class CodePwdController {
	
	
	@Autowired
	public ICodePwdService codePwdService;
	
	@RequestMapping("/toCodePwdListUI")
	public ModelAndView toCodePwdListUI() {
		
		return new ModelAndView ("codePwd/list");
	}
	
	@RequestMapping("/getCodePwdList")
    public @ResponseBody JSONArray getCodePwdList() {
		
		List<CodePwd> codePwdList = codePwdService.getCodePwdList();
		
		return JSONArray.parseArray(JSON.toJSONString(codePwdList));
	}
	
}
