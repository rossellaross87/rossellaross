package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class EditPasswordAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		ChatRepository cr = new ChatRepository();
		HttpSession session = request.getSession(true);
		
		Utente u = (Utente)session.getAttribute("user");
		Integer idUser = u.getId();
		u = cr.getUsersById(idUser);
		String password = (String) request.getParameter("password");
		String password2 = (String) request.getParameter("password2");
		if (password != null && password.equals(password2)){
		cr.updatePwd(u,password2);	
		request.setAttribute("message", "MODIFICA DELLA PASSWORD AVVENUTA CON SUCCESSO");
		return "WEB-INF/jsp/changePwd.jsp";	
		}
		request.setAttribute("message", "VALORE NON VALIDO, INSERISCI UNA NUOVA PASSWORD");
		return "WEB-INF/jsp/error.jsp";
	}

}
