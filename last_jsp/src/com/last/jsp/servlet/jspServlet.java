package com.last.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.last.jsp.service.ClassService;
import com.last.jsp.service.CustomerService;
import com.last.jsp.service.MenuService;
import com.last.jsp.service.UserService;
import com.last.jsp.service.impl.ClassServiceImpl;
import com.last.jsp.service.impl.CustomerServiceImpl;
import com.last.jsp.service.impl.MenuServiceImpl;
import com.last.jsp.service.impl.UserServiceImpl;


@WebServlet("/view/*")
public class jspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String commendURI(String uri) {
		if(uri.indexOf("list")!=-1){
			return "list";
		}else if(uri.indexOf("insert")!=-1){
			return "insert";
		}else if(uri.indexOf("upanddel")!=-1){
			return "upanddel";
		}else if(uri.indexOf("selectone")!=-1){
			return "selectone";
		}
		return null;
	}
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
		String uri=req.getRequestURI();
		String root=req.getContextPath();
		uri=uri.replace(root, "");
		if(uri.indexOf("user")!=-1){
			UserService ms = new UserServiceImpl();
			System.out.println(commendURI(uri));
		
		}else if(uri.indexOf("class")!=-1){
			ClassService ms = new ClassServiceImpl();
			System.out.println(commendURI(uri));
			
		}else if(uri.indexOf("menu")!=-1){
			MenuService ms = new MenuServiceImpl();
			System.out.println(commendURI(uri));
			
		}else if(uri.indexOf("customer")!=-1){
			CustomerService ms = new CustomerServiceImpl();
			System.out.println(commendURI(uri));
		}
		
		MenuService ms = new MenuServiceImpl();
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
		
		ms.getMenuList(req);
		rd.forward(req, res);
	}

}
