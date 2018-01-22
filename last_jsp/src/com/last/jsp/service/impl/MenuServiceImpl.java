package com.last.jsp.service.impl;

import javax.servlet.http.HttpServletRequest;
import com.last.jsp.dao.MenuDAO;
import com.last.jsp.dao.impl.MenuDAOImpl;
import com.last.jsp.service.MenuService;

public class MenuServiceImpl implements MenuService{
	private MenuDAO mdao = new MenuDAOImpl();
	
	@Override
	public void getMenuList(HttpServletRequest req) {
		req.setAttribute("menuList", mdao.selectMenu());
	}

}
