package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServiceRequest1 extends HttpServlet {
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.qn.model.Car;

	public class ServiceRequest1 extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String serviceRequest=req.getParameter("serviceRequest");
			String carRegistrationNumber=req.getParameter("carRegistrationNumber");
			Car c=new Car();
			HttpSession session =req.getSession();
			String username =(String)session.getAttribute("susername");
			//String carRegistrationNumber=(String)session.getAttribute("scarRegistrationNumber");
			c.setServiceRequest(serviceRequest);
			c.setUsername(username);
			c.setCarRegistrationNumber(carRegistrationNumber);
			int status=c.serviceRequest();
			if(status==0) {
				resp.sendRedirect("/Car-service-system/serviceRequestFailure.jsp");
			}
			else {
				resp.sendRedirect("/Car-service-system/serviceRequestSuccess.jsp");
			}
		}
		
	}
}
