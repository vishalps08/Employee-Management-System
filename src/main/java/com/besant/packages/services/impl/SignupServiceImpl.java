package com.besant.packages.services.impl;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.SignupService;
import com.besant.packages.utils.JdbcConnection;

public class SignupServiceImpl implements SignupService
{

	@Override
	public void signup(HttpServletRequest req, HttpServletResponse res) {
	
		
		try {
			
			JdbcConnection.jdbcConnect();

			String signUpQuery = "INSERT INTO authentication(email,password) value (?,?)";
			
			PreparedStatement statement = JdbcConnection.con.prepareStatement(signUpQuery);
			
			statement.setString(1, req.getParameter("email"));
			statement.setString(2, req.getParameter("password"));
			
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) 
			{
				res.sendRedirect("login.html");
				
			} 
			
			else {
				System.out.println("Something went wrong");
			}

			JdbcConnection.con.close();


			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
