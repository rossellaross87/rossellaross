package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class GoToDeleteUserForAdminAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		Integer idBanned= null;
		try{
		idBanned= Integer.parseInt((String) request.getParameter("userId"));
		
	}
	catch(NumberFormatException e){e.printStackTrace();
	System.out.println(e.getMessage());
	return "WEB-INF/jsp/error.jsp";}
	// try catch
	ChatRepository cr = new ChatRepository();
	System.out.println(idBanned);
cr.deleteUser(idBanned);
request.setAttribute("messaggi", "HAI BANNATO CORRETTAMENTE L' UTENTE");

	return "WEB-INF/jsp/allUsersForAdmin.jsp";
	}

}
