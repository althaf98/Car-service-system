package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	private String AdminUsername;
	private String AdminPassword;
	Connection con= null;
	public Admin(String adminusername, String adminpassword) {
		super();
		AdminUsername = adminusername;
		AdminPassword = adminpassword;
	}
	public Admin() {
		super();
	}
	public String getAdminusername() {
		return AdminUsername;
	}
	public void setAdminusername(String adminusername) {
		AdminUsername = adminusername;
	}
	public String getAdminpassword() {
		return AdminPassword;
	}
	public void setAdminpassword(String adminpassword) {
		AdminPassword = adminpassword;
	}
	@Override
	public String toString() {
		return "Admin [AdminUsername=" + AdminUsername + ", AdminPassword=" + AdminPassword + "]";
	}
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system_june","root","Mehataj@0");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int AdminLogin() {
		{
			
			try {
				String s="select * from admin where admin_username=?";
				PreparedStatement psmt=con.prepareStatement(s);
				psmt.setString(1, AdminUsername);
				ResultSet res =psmt.executeQuery();
				
				if(res.next()) {
					if(AdminPassword.equals(res.getString(2))) {
						return 1;
					}
					else {
						return 0;
					}
				}
				else {
					return -1;
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
	
}
		return 0;
	}
	
	}
	
