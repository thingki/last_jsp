package com.last.jsp.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.last.jsp.dao.UserDAO;
import com.last.jsp.dao.impl.UserDAOImpl;
import com.last.jsp.service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO udao = new UserDAOImpl();
	
	@Override
	public void printClassName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserList(HttpServletRequest req) {
		req.setAttribute("userList", udao.selectUserList());
	}

}
