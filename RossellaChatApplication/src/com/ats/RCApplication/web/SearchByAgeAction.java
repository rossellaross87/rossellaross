package com.ats.RCApplication.web;

import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.domain.Informazioni;
import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class SearchByAgeAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		ChatRepository cr = new ChatRepository();
		String age1 = (String) request.getParameter("age1");
		String age2 = (String) request.getParameter("age2");
		Collection<Utente> result = null;
		try {
			
			Integer eta1 = new Integer(0);
			Integer eta2 = new Integer(0);
			if (age1 != null && !age1.isEmpty() && age2!=null && !age2.isEmpty() && (age1.compareTo(age2)<= 0))
				{eta1 = Integer.parseInt(age1);
				eta2 = Integer.parseInt(age2);}
			if(eta1 <=eta2)
				 result= cr.getUsersByAge(eta1, eta2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "WEB-INF/jsp/error.jsp";
		}
		
		if(result.isEmpty()){request.setAttribute("message", "L'UTENTE CHE HAI CERCATO NON ESISTE, CERCA UN ALTRO UTENTE");
		return "WEB-INF/jsp/allUsers.jsp";	}
		request.setAttribute("allUsers", result);
		return "WEB-INF/jsp/allUsers.jsp";
	}

}
