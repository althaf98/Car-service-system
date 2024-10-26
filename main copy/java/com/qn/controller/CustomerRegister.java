package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.Customer;


public class CustomerRegister extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmpassword");
		String email=request.getParameter("email");
		
		if(password.equals(confirmPassword)) {
			Customer c =new Customer( name, username,password,email);
			int rows=c.customerRegister();
			
			if(rows==1) {
				response.sendRedirect("/Car-service-system/customerRegisterSuccess.jsp");
			}
			else {
				response.sendRedirect("/Car-service-system/customerRegisterFailure.jsp");
			}
		}
		else {
			response.sendRedirect("/Car-service-system/PasswordMismatch.html");
		}
	}
}
