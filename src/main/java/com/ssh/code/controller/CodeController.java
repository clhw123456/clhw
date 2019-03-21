package com.ssh.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ssh.code.entity.Code;
import com.ssh.code.entity.Dict;
import com.ssh.code.entity.User;
import com.ssh.code.service.ICodeService;
import com.ssh.code.view.R;

@Controller
@RequestMapping("/code")
public class CodeController {
	
	@Autowired
	private ICodeService codeService;
	
	@RequestMapping("/toCodeListUI")
	public ModelAndView toCodeListUI() {
		
		return new ModelAndView("code/list");
	}
	
	@RequestMapping("/getCodeList")
	public @ResponseBody JSONArray getCodeList() {
		
		List<Code> codeList = codeService.getCodeList();
		
		return JSONArray.parseArray(JSON.toJSONString(codeList));
	}
	
	@RequestMapping("/getLevelDictList")
	public @ResponseBody JSONArray getLevelDictList() {
		
		List<Dict> dictList = codeService.getDictListByType("源码等级");
		
		return JSONArray.parseArray(JSON.toJSONString(dictList));
	}
	
	@RequestMapping("/getTradeDictList")
	public @ResponseBody JSONArray getTradeDictList() {
		
		List<Dict> dictList = codeService.getDictListByType("源码行业");
		
		return JSONArray.parseArray(JSON.toJSONString(dictList));
	}
	
	@RequestMapping("/getTypeDictList")
	public @ResponseBody JSONArray getTypeDictList() {
		
		List<Dict> dictList = codeService.getDictListByType("源码类型");
		
		return JSONArray.parseArray(JSON.toJSONString(dictList));
	}
	
	@RequestMapping("/saveCode")
    public @ResponseBody R saveCode(Code code) {
		
		System.out.println("..............."+code);
			
			R r = codeService.saveCode(code);
			
			return r;
			
		}
	
	@RequestMapping("/updateCode")
	public  @ResponseBody  R updateCode(Code code) {
		System.out.println("............."+code);
		
		R r = codeService.updateCode(code);
		
		return r;
	}
	
	
	@RequestMapping("/deleteCode")
	public @ResponseBody R deleteCode(@RequestParam("cIds[]") Integer[] cIds) {
		
         R r = codeService.deleteCode(cIds);
		
		return r;
      }
}


