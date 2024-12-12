package com.besant.packages.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DeleteEmployeeService {
	
	public void deleteEmployee(HttpServletRequest req, HttpServletResponse res);

}
