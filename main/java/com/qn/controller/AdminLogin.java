package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Admin;


public class AdminLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String AdminUsername=request.getParameter("adminUsername");
		String AdminPassword=request.getParameter("adminPassword");
		System.out.println(AdminUsername);
		System.out.println(AdminPassword);
		Admin a = new Admin();
		a.setAdminusername(AdminUsername);
		a.setAdminpassword(AdminPassword);
		int status =a.AdminLogin();
		if(status==1) {
			response.sendRedirect("/Car-service-system/adminLoginSuccess.jsp");
		}
		else if(status==-1) {
			response.sendRedirect("/Car-service-system/invalidadminUsername.jsp");	
		}
		else {
			response.sendRedirect("/Car-service-system/invalidadminPassword.jsp");
		}
	}
}
