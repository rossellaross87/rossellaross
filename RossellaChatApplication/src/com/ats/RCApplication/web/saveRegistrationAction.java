package com.ats.RCApplication.web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.domain.Informazioni;
import com.ats.RCApplication.domain.Utente;
import com.ats.RCApplication.infrastructure.ChatRepository;
import com.ats.RCApplication.infrastructure.DataException;

public class SaveRegistrationAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, SQLException {

		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
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
		List<Utente> users = (List<Utente>) cr.getUsersByUserName(userName);
		if (!users.isEmpty()) {
			request.setAttribute("message", "LO USERNAME CHE HAI INSERITO APPARTIENE GIA' A UN ALTRO UTENTE, INSERISCI UN NUOVO USERNAME PER REGISTRARTI");
			return "WEB-INF/jsp/registrationPage.jsp";
		} else {
			try {
				Double altezza = new Double(0);
				Integer eta = new Integer(0);
				if (height != null && !height.isEmpty())
					altezza = Double.parseDouble(height);
				if (age != null && !age.isEmpty())
					eta = Integer.parseInt(age);
				
				cr.saveUserAllInformation(new Utente(userName, password), new Informazioni(name, lastName, city, sex, country, altezza, look, relationship, education, job, hobbies, eta));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return "WEB-INF/jsp/error.jsp";
			}
			// try{
			// Double altezza = new Double(0);
			// Integer eta = new Integer(0);
			// if (height != null && !height.isEmpty())
			// altezza = Double.parseDouble(height);
			// if (age != null && !age.isEmpty())
			// eta = Integer.parseInt(age);
			//
			// int lastIdInserted = cr.searchLastIdUserInserted();
			//
			// cr.saveInformation(new Informazioni(name, lastName, city, sex,
			// country , altezza, look, relationship, education, job,
			// hobbies,lastIdInserted, eta ));
			//
			// } catch (Exception e) {
			// // Va cancellato l'ultiumo utente inserito con username==[ultimo
			// utente digitato]
			// // delete from Utente where username=userName
			// cr.deleteLastUserInserted(userName);
			// System.out.println("ERRORE INFORMAZIONI: " + e.getStackTrace());
			// return "WEB-INF/jsp/error.jsp";
			// }
			request.setAttribute("message", "REGISTRAZIONE AVVENUTA CON SUCCESSO");
			return "index.jsp";
		}
	}
}
