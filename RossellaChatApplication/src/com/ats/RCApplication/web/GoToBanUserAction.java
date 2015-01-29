package com.ats.RCApplication.web;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class GoToBanUserAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		ChatRepository cr = new ChatRepository();
		HttpSession session = request.getSession(true);
		Integer idBanner = (Integer)( session.getAttribute("currentId"));
		String idBanned = (String)(request.getParameter("userId"));
		 Date date = new Date();
         SimpleDateFormat format  = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
         String dateString = format.format(date);
         try {
 			
 			int bId = Integer.parseInt(idBanned);
 			System.out.println("sono il GoToBanUserAction " +   " "
 					+ bId);
 			
 			
 			
 			cr.banUser(idBanner, bId, dateString);
 		
 			
 			
 			
 		} catch (NumberFormatException e ) {
 			
 			
 			 if (idBanned == null)
 			{request.setAttribute("message", "non hai selezionato l'utente da bannare");}
 			
 			
 			return "WEB-INF/jsp/allUsers.jsp";
 		
 	}
         request.setAttribute("message", "hai bannato l'utente correttamente");
		return "WEB-INF/jsp/allUsers.jsp";
	}

}
