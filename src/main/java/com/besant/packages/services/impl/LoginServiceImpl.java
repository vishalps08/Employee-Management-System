package com.besant.packages.services.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.packages.service.LoginService;
import com.besant.packages.utils.JdbcConnection;

public class LoginServiceImpl implements LoginService {
	@Override
	public void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbcConnect();
			String signUpQuery = "SELECT * FROM employeemanagement.authentication where email = ? and password= ?";
			PreparedStatement statement = JdbcConnection.con.prepareStatement(signUpQuery);

			statement.setString(1, req.getParameter("email"));
			statement.setString(2, req.getParameter("password"));
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
			
				HttpSession session = req.getSession();
				res.sendRedirect("dashboard.html");
				session.setAttribute("uid", resultSet.getInt("id"));
				
			} 
			
			else {
				System.out.println("Login failed");
			}
			JdbcConnection.con.close();
			} 

			catch (SQLException e) {
						
				e.printStackTrace();
			} 
			
			catch (ClassNotFoundException e) {
          		e.printStackTrace();
			} 
		
			catch (IOException e) {
				e.printStackTrace();
			}
	}
}
