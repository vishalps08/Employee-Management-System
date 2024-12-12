package com.besant.packages.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.services.impl.LoginServiceImpl;
import com.besant.packages.services.impl.SignupServiceImpl;

public interface LoginService {
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws SQLException;

}
