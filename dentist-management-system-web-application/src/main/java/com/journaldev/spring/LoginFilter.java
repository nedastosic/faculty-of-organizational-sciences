/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.spring;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author milos
 */
public class LoginFilter implements Filter {
    
	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}
        
        @Override
            public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
           HttpServletResponse hsr = (HttpServletResponse) res;
           hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
           hsr.setHeader("Pragma", "no-cache"); // HTTP 1.0.
           hsr.setDateHeader("Expires", 0); // Proxies.
           chain.doFilter(req, res);
        }

//	@Override
//	public void doFilter(ServletRequest request, 
//               ServletResponse response, FilterChain chain)
//		throws IOException, ServletException {
//                    HttpServletRequest req = (HttpServletRequest) request;
//                    HttpServletResponse resp = (HttpServletResponse) response;
//                    HttpSession session = req.getSession();
//		if(session.getAttribute("dentist")!=null){
//			chain.doFilter(request, response);
//		} else{
//			//request.getRequestDispatcher("/login")
//                        //       .forward(request, response);
//                         System.out.println(resp.encodeRedirectURL(req.getContextPath()+"/login"));
//                         resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()+"/login"));
//                        //resp.sendRedirect("https://www.google.com/");
//		}
//
//	}

}
