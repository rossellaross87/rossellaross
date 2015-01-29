package com.ats.RCApplication.web;

import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.domain.Segnalazione;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class AllBansForAdminAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		ChatRepository cr = new ChatRepository();
		Collection<Segnalazione> result = cr.allBans();
		request.setAttribute("allBans", result);
		return "WEB-INF/jsp/allBansForAdmin.jsp";
	}

}
