package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class DeleteAccount implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		ChatRepository cr = new ChatRepository();
		HttpSession session = request.getSession(true);
		Integer idUser = (Integer)( session.getAttribute("currentId"));
		cr.deleteUser(idUser);
		request.setAttribute("message", "HAI DISATTIVATO IL TUO ACCOUNT CORRETTAMENTE");
		return "index.jsp";
	}

}
