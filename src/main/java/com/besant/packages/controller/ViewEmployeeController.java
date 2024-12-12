package com.besant.packages.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.ViewEmployeeService;
import com.besant.packages.services.impl.ViewEmployeeServiceImpl;


@WebServlet("/ViewEmployee")
public class ViewEmployeeController extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		
		try {
			
			ViewEmployeeService service = new ViewEmployeeServiceImpl();
			
			service.viewEmployeeData(req, res);
			
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
	}

}


