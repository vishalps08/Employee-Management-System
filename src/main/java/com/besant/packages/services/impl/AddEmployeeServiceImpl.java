package com.besant.packages.services.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.packages.service.AddEmployeeData;
import com.besant.packages.utils.JdbcConnection;

public class AddEmployeeServiceImpl implements AddEmployeeData {

	@Override
	public void addEmployeeData(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		
		
try {
			
			JdbcConnection.jdbcConnect();

			String addEmployeeData = "INSERT INTO employeeManagement.employeeData (empId, empName, empEmail, empSalary, empAddress, empDesignation, empDepartment, empPhoneNumber, creatorId) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?);";
			
			PreparedStatement statement = JdbcConnection.con.prepareStatement(addEmployeeData);
		
			statement.setInt(1,Integer.parseInt(req.getParameter("empNumber")));
			statement.setString(2,req.getParameter("empName"));
			statement.setString(3,req.getParameter("empEmail"));
			statement.setInt(4,Integer.parseInt(req.getParameter("empSalary")));
			statement.setString(5,req.getParameter("empAddress"));
			statement.setString(6,req.getParameter("empDesignation"));
			statement.setString(7,req.getParameter("empDepartment"));
			statement.setLong(8, Long.parseLong(req.getParameter("empPhoneNumber")));
			
			HttpSession session = req.getSession();
			
//			int creatorID = Integer.parseInt(session.getAttribute("uid").toString());
			statement.setInt(9,(int)session.getAttribute("uid"));
						
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) 
			{
				res.sendRedirect("dashboard.html");
				
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
