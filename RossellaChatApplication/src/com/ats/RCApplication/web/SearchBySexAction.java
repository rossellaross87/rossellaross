package com.ats.RCApplication.web;

import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class SearchBySexAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		ChatRepository cr = new ChatRepository();
		String sex = (String) request.getParameter("sex");
		Collection<Utente> result = cr.getUsersBySex(sex);
		if(result.isEmpty()){request.setAttribute("message", "L'UTENTE CHE HAI CERCATO NON ESISTE, CERCA UN ALTRO UTENTE");
		return "WEB-INF/jsp/allUsers.jsp";	}
		request.setAttribute("allUsers", result);
		return "WEB-INF/jsp/allUsers.jsp";
	}

}
