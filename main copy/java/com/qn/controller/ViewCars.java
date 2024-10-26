package com.qn.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;

public class ViewCars extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response){
		Car c=new Car();
		ArrayList<Car> carDetails=c.viewCustomer();
		HttpSession session=request.getSession();
		session.setAttribute("scarDetails",carDetails);
		
			try {
				if(carDetails==null) {
				response.sendRedirect("/Car-service-system/viewCarsFailure.jsp");
				}
				else {
					response.sendRedirect("/Car-service-system/viewCarsSuccess.jsp");
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
