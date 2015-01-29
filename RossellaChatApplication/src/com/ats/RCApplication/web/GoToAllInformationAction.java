package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.infrastructure.DataException;


public class GoToAllInformationAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
	
		request.setAttribute("isEditable", "true");
		
		return "WEB-INF/jsp/allInformation.jsp";
}
}