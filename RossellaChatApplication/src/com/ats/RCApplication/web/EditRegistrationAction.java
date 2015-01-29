package com.ats.RCApplication.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.RCApplication.domain.Informazioni;
import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class EditRegistrationAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {
		HttpSession session = request.getSession(true);
		Integer idUser = (Integer)( session.getAttribute("currentId"));

		
		String name = (String) request.getParameter("name");
		String lastName = (String) request.getParameter("lastName");
		String city = (String) request.getParameter("city");
		String sex = (String) request.getParameter("sex");
		String country = (String) request.getParameter("country");
		String height = (String) request.getParameter("height");
		String look = (String) request.getParameter("look");
		String relationship = (String) request.getParameter("relationship");
		String education = (String) request.getParameter("education");
		String job = (String) request.getParameter("job");
		String hobbies = (String) request.getParameter("hobbies");
		String age = (String) request.getParameter("age");

		ChatRepository cr = new ChatRepository();
		try {
			Double altezza = new Double(0);
			Integer eta = new Integer(0);
			if (height != null && !height.isEmpty())
				altezza = Double.parseDouble(height);
			if (age != null && !age.isEmpty())
				eta = Integer.parseInt(age);
			Informazioni info = new Informazioni(name,lastName, city, sex, country,altezza,
					look,relationship, education, job, hobbies , eta);
			cr.update(info, idUser);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
			return "WEB-INF/jsp/error.jsp";
		}
		
	
		System.out.println("sono in editRegistration e il seguente valore è : " + idUser);
		request.setAttribute("message", "MODIFICA AVVENUTA CON SUCCESSO");
		return "WEB-INF/jsp/mainMenu.jsp";
	}

}
