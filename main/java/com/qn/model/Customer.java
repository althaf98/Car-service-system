package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer {
	private String name;
	private String username;
	private String password;
	private String email;
	Connection con=null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer() {
		super();
	}
	public Customer(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system_june","root","Mehataj@0");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int customerRegister() {
		
	try {
		String s="insert into customer values(?, ?, ?, ?)";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1, name);
		pstmt.setString(2, username);
		pstmt.setString(3, password);
		pstmt.setString(4, email);
		int rows=pstmt.executeUpdate();
		return rows;
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return 0;
	}
	public int CustomerLogin() {
		{
			
			try {
				String s="select *from customer where username=?";
				PreparedStatement psmt=con.prepareStatement(s);
				psmt.setString(1, username);
				ResultSet res =psmt.executeQuery();
				
				if(res.next()) {
					if(password.equals(res.getString(3))) {
						name=res.getString(1);
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