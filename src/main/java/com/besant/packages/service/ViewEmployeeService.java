package com.besant.packages.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ViewEmployeeService {
	
	public void viewEmployeeData(HttpServletRequest req, HttpServletResponse res) throws SQLException;

}


}



