package com.ssh.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.code.dao.ICodePwdDao;
import com.ssh.code.dao.impl.CodePwdDao;
import com.ssh.code.entity.CodePwd;
import com.ssh.code.service.ICodePwdService;

@Service
@Transactional
public class CodePwdService implements ICodePwdService {

	@Autowired
	public ICodePwdDao codePwdDao;
	public List<CodePwd> getCodePwdList() {
		// TODO Auto-generated method stub
	
		return codePwdDao.getCodePwdList();
	}

}
