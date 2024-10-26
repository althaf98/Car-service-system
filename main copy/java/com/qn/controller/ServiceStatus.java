package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;

public class ServiceStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carRegistrationNumber=request.getParameter("carRegistrationNumber");
		Car c =new Car();
		c.setCarRegistrationNumber(carRegistrationNumber);
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("susername");
		c.setUsername(username);
		String status=c.getServiceStatus();
		session.setAttribute("sStatus", status);
		
		if(status==null) {
			response.sendRedirect("/Car-service-system/serviceStatusFailure.jsp");
		}
		else {
			response.sendRedirect("/Car-service-system/serviceStatusSuccess.jsp");

		}
	}

}
