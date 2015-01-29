package com.ats.RCApplication.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.infrastructure.DataException;

public class RegistrationAction implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws DataException {
		
		return "WEB-INF/jsp/registrationPage.jsp";
	}

}
