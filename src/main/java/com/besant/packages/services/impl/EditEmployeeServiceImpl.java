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
import javax.servlet.http.HttpSession;

import com.besant.packages.model.Employee;
import com.besant.packages.service.EditEmployeeService;
import com.besant.packages.utils.JdbcConnection;

public class EditEmployeeServiceImpl implements EditEmployeeService {

	@Override
	public void editEmployeeData(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			JdbcConnection.jdbcConnect();

			String selectQuery = "SELECT * FROM employeemanagement.employeedata where id = ? ";
			PreparedStatement statement = JdbcConnection.con.prepareStatement(selectQuery);

			statement.setInt(1, Integer.parseInt(req.getParameter("id")));

			ResultSet resultS = statement.executeQuery();

			List<Employee> employeeList = new ArrayList<>();
			while (resultS.next()) {

				Employee employee = new Employee();
				employee.setId(resultS.getInt("id"));
				employee.setEmpID(resultS.getInt("empId"));
				employee.setEmpName(resultS.getString("empName"));
				employee.setEmpEmail(resultS.getString("empEmail"));
				employee.setEmpSalary(resultS.getInt("empSalary"));
				employee.setEmpAddress(resultS.getString("empAddress"));
				employee.setEmpDesignation(resultS.getString("empDesignation"));
				employee.setEmpDepartment(resultS.getString("empDepartment"));
				employee.setEmpPhoneNumber(resultS.getInt("empPhoneNumber"));
				employee.setCreatorID(resultS.getInt("creatorId"));
				employee.setCreatedAt(resultS.getString("created_at"));
				employeeList.add(employee);
			}
			JdbcConnection.con.close();

			req.setAttribute("employees", employeeList);
			req.getRequestDispatcher("editEmployee.jsp").forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void updateEmployeeData(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			JdbcConnection.jdbcConnect();
			String addEmployeeDataQuery = "UPDATE employeeManagement.employeedata SET empName = ?,empEmail = ?, empSalary=?,  empAddress= ? ,empDesignation=?, empDepartment=?,empPhoneNumber=? WHERE id = ?;";
			PreparedStatement statement = JdbcConnection.con.prepareStatement(addEmployeeDataQuery);
			statement.setString(1, req.getParameter("empName"));
			statement.setString(2, req.getParameter("empEmail"));
			statement.setString(3, req.getParameter("empSalary"));
			statement.setString(4, req.getParameter("empAddress"));
			statement.setString(5, req.getParameter("empDesignation"));
			statement.setString(6, req.getParameter("empDepartment"));
			statement.setString(7, req.getParameter("empPhoneNumber"));
			System.out.println(Integer.parseInt(req.getParameter("id")));
			statement.setInt(8, Integer.parseInt(req.getParameter("id")));
			
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("/EmployeeManagement/ViewEmployee");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
	}

}
