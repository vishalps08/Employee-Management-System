package com.besant.packages.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AddEmployeeData {
	
	public void addEmployeeData(HttpServletRequest req, HttpServletResponse res) throws SQLException;

}
