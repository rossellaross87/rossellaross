package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.infrastructure.DataException;

public class LogoutAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {

		request.getSession().setAttribute("user", null);
		request.getSession().setAttribute("info", null);
		request.getSession().invalidate();
		return "index.jsp";
	}

}
