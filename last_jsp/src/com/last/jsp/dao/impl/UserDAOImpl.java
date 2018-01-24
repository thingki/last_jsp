package com.last.jsp.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.last.jsp.common.MybatisSqlSessionFactory;
import com.last.jsp.dao.UserDAO;

public class UserDAOImpl implements UserDAO{
	private static Logger log = Logger.getLogger(MenuDAOImpl.class);
	
	@Override
	public List<Map<String, String>> selectUserList() {
		try(SqlSession ss = MybatisSqlSessionFactory.getSS()){
			return ss.selectList("user.selectUser");
		}catch(Exception e) {
			log.error("err => {}", e);
		}
		return null;
	}
	

}
