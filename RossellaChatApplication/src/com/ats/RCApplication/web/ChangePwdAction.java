package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class ChangePwdAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		System.out.println("Sono dentro cambia password");
		ChatRepository cr = new ChatRepository();
		HttpSession session = request.getSession(true);
		//Integer idUser = (Integer)( session.getAttribute("currentId"));
		Utente u = (Utente)session.getAttribute("user");
		//Integer idUser2 =u.getId();
		
		return "WEB-INF/jsp/changePwd.jsp";
	}

}
