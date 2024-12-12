package com.besant.packages.controller;

import com.besant.packages.service.DeleteEmployeeService;
import com.besant.packages.services.impl.DeleteEmployeeServiceImpl;
import com.besant.packages.services.impl.SignupServiceImpl;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		DeleteEmployeeService service = new DeleteEmployeeServiceImpl();
		service.deleteEmployee(req, res);

	}

}
