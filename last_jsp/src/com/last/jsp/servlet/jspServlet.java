package com.last.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.last.jsp.service.MenuService;
import com.last.jsp.service.impl.MenuServiceImpl;


@WebServlet("/view/*")
public class jspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public jspServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
		MenuService ms = new MenuServiceImpl();
		ms.getMenuList(req);
		rd.forward(req, res);
	}

}
