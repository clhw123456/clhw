package com.ssh.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.code.dao.ICodeDao;
import com.ssh.code.entity.Code;
import com.ssh.code.entity.Dict;
import com.ssh.code.entity.User;
import com.ssh.code.service.ICodeService;
import com.ssh.code.view.R;

@Service
@Transactional
public class CodeService implements ICodeService {
	
	@Autowired
	private ICodeDao codeDao;

	public List<Code> getCodeList() {
		// TODO Auto-generated method stub
		return codeDao.getCodeList();
	}

	public List<Dict> getDictListByType(String type) {
		// TODO Auto-generated method stub
		return codeDao.getDictListByType(type);
	}

	public R saveCode(Code code) {
		// TODO Auto-generated method stub
        R r = null;
		
		Code findcode = codeDao.findCodeByName(code.getCName());
		
		if(findcode==null) {
			
			boolean flag = codeDao.saveCode(code);
			System.out.println(code);
			
			if(flag) {
				
				r = R.ok("新增成功！");
			}
			
		}else {
			
			r = R.error("该编码名称已存在！");
		}
		
		return r;
	}

	public R updateCode(Code code) {
		// TODO Auto-generated method stub
         R r = null;
		
		Code findCode = codeDao.findCodeByName(code.getCName());
		
		if(findCode==null || (findCode!=null&&findCode.getCId().intValue()==code.getCId().intValue())) {
			
			boolean flag = codeDao.updateCode(code);
			
		      if(flag) {
				
				codeDao.updateCode(code);
				
				r = R.ok("修改成功！");
			}
			
		}else {
			
			r = R.error("该用户名已重复，请重新修改！");
		}
		
		return r;
	}

	public R deleteCode(Integer[] cIds) {
		// TODO Auto-generated method stub
		
		 R r = null;
		
		boolean flag = codeDao.deleteCode(cIds);
		
		
		if(flag) {
			
			r = R.ok("删除成功！");
		 }else {
			 r = R.error("删除失败！");
		 }	    
	
	   return r;
	}

}
