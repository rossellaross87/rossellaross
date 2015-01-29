package com.ats.RCApplication.web;

import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.RCApplication.domain.Messaggi;
import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class SendMessageAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		String textMess = (String) request.getParameter("msgText");
		ChatRepository cr = new ChatRepository();
		HttpSession session = request.getSession(true);
		
		Utente u = (Utente)session.getAttribute("user");
		Integer idSender =u.getId();
		Integer idReceiver = Integer.parseInt((String)request.getParameter("receiverId"));
		if(textMess!= null){
		int result = cr.sendMessage(idSender, idReceiver, textMess);
	   System.out.println(result);
	   Collection<Messaggi> messaggi = cr.getConversation(idSender, idReceiver);
		request.setAttribute("messaggi", messaggi);
		Utente receiver = cr.getUsersById(idReceiver);
		request.setAttribute("receiver", receiver);
	   request.setAttribute("message", "hai inviato "+result+" nuovo messaggio");
		return "WEB-INF/jsp/chat.jsp";}
		else request.setAttribute("message", "NON HAI INSERITO NESSUN MESSAGGIO");
		return "WEB-INF/jsp/chat.jsp";
	}

}
