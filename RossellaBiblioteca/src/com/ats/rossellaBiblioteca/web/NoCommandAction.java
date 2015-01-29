package com.ats.rossellaBiblioteca.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.rossellaBiblioteca.infrastructure.DataException;

public class NoCommandAction implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws DataException {
		
		return "WEB-INF/jsp/error.jsp";
	}

}
