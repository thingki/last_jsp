package com.last.jsp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class incodingfilter
 */
@WebFilter("/*")
public class incodingfilter implements Filter {

    public incodingfilter() {
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html);charset=utf-8");
		fc.doFilter(req, res);
	}

	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
	}

}
