package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.infrastructure.DataException;





public interface Command {
	String execute(HttpServletRequest request,HttpServletResponse response) throws DataException, SQLException;
}
