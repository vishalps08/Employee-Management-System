package com.besant.packages.services.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.model.Employee;
import com.besant.packages.service.ViewEmployeeService;
import com.besant.packages.utils.JdbcConnection;

public class ViewEmployeeServiceImpl implements ViewEmployeeService{

	public void viewEmployeeData(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		
		try {
			
		
		JdbcConnection.jdbcConnect();

		String viewAllEmp = "SELECT * FROM employeemanagement.employeedata;";

		PreparedStatement statement = JdbcConnection.con.prepareStatement(viewAllEmp);

		ResultSet resultS = statement.executeQuery();
		List<Employee> employeeList = new ArrayList<>();
		
		
		
				while(resultS.next())
				{
					Employee employee = new Employee();
					employee.setId(resultS.getInt("id"));
					employee.setEmpID(resultS.getInt("empID"));
					employee.setEmpName(resultS.getString("empName"));
					employee.setEmpEmail(resultS.getString("empEmail"));
					employee.setEmpSalary(resultS.getInt("EmpSalary"));
					employee.setEmpAddress(resultS.getString("empAddress"));
					employee.setEmpDesignation(resultS.getString("empDesignation"));
					employee.setEmpDepartment(resultS.getString("empDepartment"));
					employee.setEmpPhoneNumber(getInt("empPhoneNumber"));
					employee.setCreatorID(getInt("creatorID"));
					employee.setCreatedAt(resultS.getString("created_at"));
					employeeList.add(employee);
					
				}
				
				JdbcConnection.con.close();
				req.setAttribute("Employees", employeeList);
				req.getRequestDispatcher("allEmployee.jsp").forward(req, res);
				
				
			
		}
		
	 catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	private int getInt(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
}

		

		

