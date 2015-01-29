package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.domain.Informazioni;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class GoToInformationPageAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		String userId = (String) request.getParameter("userId");
		String isEditable = (String) request.getParameter("isEditable");
		
		ChatRepository cr = new ChatRepository();
		Informazioni info = new Informazioni();
		try {

			int uId = Integer.parseInt(userId);
			System.out.println("sono il goToInformationAction " + " " + uId);

			info = cr.getInformationByUserID(uId);

		} catch (NumberFormatException e) {

			if (userId == null || userId == "") {
				request.setAttribute("message", "non hai selezionato l'utente");
			}

			return "WEB-INF/jsp/allUsers.jsp";

		}
		request.setAttribute("info", info);
		request.setAttribute("message", "hai selezionato l' utente");
		request.setAttribute("isEditable", isEditable);
		
		return "WEB-INF/jsp/allInformation.jsp";

	}
}