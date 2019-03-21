package com.ssh.code.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.code.dao.ICodeDao;
import com.ssh.code.entity.Code;
import com.ssh.code.entity.Dict;
import com.ssh.code.entity.User;

@Repository
public class CodeDao implements ICodeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Code> getCodeList() {
		// TODO Auto-generated method stub
		List list = sessionFactory.openSession().createCriteria(Code.class).list();
			
		return list;
	}

	public List<Dict> getDictListByType(String type) {
		// TODO Auto-generated method stub
		return sessionFactory.openSession().createCriteria(Dict.class).add(Restrictions.eq("type", type)).list();
	}

	public boolean saveCode(Code code) {
		// TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
		
		Serializable obj = session.save(code);
		
		if(obj!=null) {
			
			return true;
		}else {
			
			return false;
		}
		
	}

	public Code findCodeByName(String cName) {
		// TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
		
		return (Code) session.createQuery("from Code c where c.CName = ?").setParameter(0, cName).uniqueResult();
		
	}

	public boolean updateCode(Code code) {
		// TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
		
        
        System.out.println(code);
		SQLQuery sqlQuery = session.createSQLQuery("update code set c_name = ? ,c_num = ? ,type_id = ? ,trade_id = ?,level_id = ?,c_price=?, down_load=? where c_id = ?");
		
		sqlQuery.setParameter(0, code.getCName()).setParameter(1, code.getCNum()).setParameter(2, code.getTypeDict().getDId()).setParameter(3, code.getTradeDict().getDId()).setParameter(4, code.getLevelDict().getDId()).setParameter(5, code.getCPrice()).setParameter(6, code.getDownLoad()).setParameter(7, code.getCId());
		
		int num = sqlQuery.executeUpdate();
		
		if(num>0) {
			
			return true;
		}else {
			
			return false;
		}
		
	}
		
	

	public boolean deleteCode(Integer[] cIds) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		StringBuffer sqlBuffer = new StringBuffer("delete from code where c_id in (");
		
		for(int i= 0;i<cIds.length;i++) {
			
             sqlBuffer.append("?");
			
			if(i<cIds.length-1) {
				
				sqlBuffer.append(",");
		}}
			sqlBuffer.append(")");
					
			SQLQuery sqlQuery =session.createSQLQuery(sqlBuffer.toString());
			
			for(int i=0;i<cIds.length;i++) {
				
				sqlQuery.setParameter(i, cIds[i]);
			}
			
			
		    int num = sqlQuery.executeUpdate();	

			if(num>0) {
				
				return true;
			}else {
				
				return false;
			}
		    
	      }
	   }



