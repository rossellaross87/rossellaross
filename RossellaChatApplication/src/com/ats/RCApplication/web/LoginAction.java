package com.ats.RCApplication.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.domain.Informazioni;
import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class LoginAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException {
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");

		ChatRepository cr = new ChatRepository();
		Utente user = cr.getUsersByUserNameAndPassword(userName, password);
		if (user == null) {
			request.setAttribute("message", "LO USERNAME E LA PASSWORD CHE HAI INSERITO  " + "NON CORRISPONDONO A NESSUN UTENTE REGISTRATO, INSERISCI DI NUOVO USERNAME E PASSWORD OPPURE REGISTRATI");
			return "index.jsp";
		}
		else if (!user.isAdmin() && !user.isBanned()) {
			Informazioni info = cr.getInformationByUserID(user.getId());
			
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("info", info);
			return "WEB-INF/jsp/mainMenu.jsp";
		} else if (!user.isAdmin() && user.isBanned()) {
			request.setAttribute("message", "SEI STATO SEGNALATO DA UN ALTRO UTENTE, ATTENDI L' INTERVENTO DELL' AMMINISTRATORE " + "CHE DECIDERA' SE RIATTIVARE IL TUO ACCOUNT OPPURE ELIMINARLO");
			return "index.jsp";
		} else if (user.isAdmin() && !user.isBanned()) {
			
			request.getSession().setAttribute("user", user);
			return "WEB-INF/jsp/adminPage.jsp";
		}

		// il caso che un amministratore venga segnalato è impossibile ,
		// perchè l' utente con la select non lo vede proprio l' amministratore
		// in quanto ho settato nelle query where isadmin=0
		// quindi in quel caso return la pagina di errore
		else
			return "WEB-INF/jsp/error.jsp";
	}
}
