package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.RCApplication.infrastructure.DataException;

public class SearchUsersAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		HttpSession session = request.getSession(true);
		Integer idUser = (Integer)( session.getAttribute("currentId"));
		return "WEB-INF/jsp/searchPage.jsp";
	}

}
