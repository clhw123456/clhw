package com.ssh.code.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.code.dao.ICodePwdDao;
import com.ssh.code.entity.CodePwd;


@Repository
public class CodePwdDao implements ICodePwdDao {
	
	@Autowired
	private  SessionFactory sessionFactory;

	public  List<CodePwd> getCodePwdList() {
		// TODO Auto-generated method stub
		List list = sessionFactory.openSession().createCriteria(CodePwd.class).list();
		return list;
	}

}
