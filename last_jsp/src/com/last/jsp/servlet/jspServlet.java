package com.last.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.servlet.JspServlet;
import org.apache.log4j.Logger;

import com.last.jsp.factory.ServiceFactory;
import com.last.jsp.service.MenuService;
import com.last.jsp.service.UserService;
import com.last.jsp.util.URIParser;

@WebServlet("/view/*")
public class jspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceFactory sf = ServiceFactory.getInstance();
	public static Logger log = Logger.getLogger(JspServlet.class);
	
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
		log.debug(uri);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF"+uri+".jsp");
		
		if(req.getServletContext().getAttribute("menuList")==null) {
			
			MenuService ms = (MenuService)sf.getService("menu");
			ms.getMenuList(req);
		}
		
		
		String command = URIParser.getCommand(uri, 1);
		log.debug(command);
		if(command.equals("list")) {
			uri = uri.replace("/"+command, "");
			command = URIParser.getCommand(uri, 1);
			if(command.equals("user")) {
			UserService us = (UserService)sf.getService(command);
			us.getUserList(req);
			}
		}
		rd.forward(req, res);
	}
}






//String command = URIParser.getCommand(new URIPattern(){
//public String getCommand() {
//	return "test";
//}
//});	
//System.out.println(command);
