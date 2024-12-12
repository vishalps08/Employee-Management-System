package com.besant.packages.services.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.DeleteEmployeeService;
import com.besant.packages.utils.JdbcConnection;

public class DeleteEmployeeServiceImpl implements DeleteEmployeeService{

	@Override
	public void deleteEmployee(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			JdbcConnection.jdbcConnect();
			String deleteQuery ="delete from employeeManagement.employeeData where id=?;";
			
			PreparedStatement statement = JdbcConnection.con.prepareStatement(deleteQuery);
			
			statement.setInt(1, Integer.parseInt(req.getParameter("id")));
			
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) 
			{
				res.sendRedirect("/EmployeeManagement/ViewEmployee?");
				
			} 
			
			else {
				System.out.println("Something went wrong");
			}

			
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
