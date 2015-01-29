package com.ats.RCApplication.web;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.RCApplication.domain.Informazioni;
import com.ats.RCApplication.domain.Messaggi;
import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class GoToChatPageAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
	Integer idReceiver= null;
		try{
		idReceiver= Integer.parseInt((String) request.getParameter("userId"));
		
	}
	catch(NumberFormatException e){e.printStackTrace();
	System.out.println(e.getMessage());
	return "WEB-INF/jsp/error.jsp";}
	// try catch
	ChatRepository cr = new ChatRepository();
	System.out.println(idReceiver);
	Utente receiver = cr.getUsersById(idReceiver);
	HttpSession session = request.getSession(true);
	
	Utente u = (Utente)session.getAttribute("user");
	Integer idSender =u.getId();
	Collection<Messaggi> messaggi = cr.getConversation(idSender, idReceiver);
	request.setAttribute("messaggi", messaggi);
	request.setAttribute("receiver", receiver);
		return "WEB-INF/jsp/chat.jsp";
	}

}
