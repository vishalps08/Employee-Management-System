package com.besant.packages.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.AddEmployeeData;
import com.besant.packages.service.SignupService;
import com.besant.packages.services.impl.AddEmployeeServiceImpl;
import com.besant.packages.services.impl.SignupServiceImpl;

@WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		AddEmployeeData service= new AddEmployeeServiceImpl();
		try {
			service.addEmployeeData(req,res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}

}
