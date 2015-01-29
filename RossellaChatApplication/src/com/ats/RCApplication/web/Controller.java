package com.ats.RCApplication.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.RCApplication.infrastructure.DataException;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int beginIndex = uri.lastIndexOf("/");
		int endIndex = uri.lastIndexOf(".do");
		String command = uri.substring(beginIndex + 1, endIndex);
		System.out.println(command);
		Command action = new NoCommandAction();
		// Questo switch sceglie il comando da eseguire in base alla stringa
		// contenuta nell'uri prima di .do
		switch (command) {
		case "login":
			action = new LoginAction();
			break;
		case "registration":
			action = new GoToRegistrationAction();
			break;
		case "saveRegistration":
			action = new SaveRegistrationAction();
			break;
		case "goToMainMenu" :
			action = new GoToMainMenu();
			break;
		case "goToAllInformation" :
			action = new GoToAllInformationAction();
			break;
		case "editRegistration":
			action = new EditRegistrationAction();
			break;
		case "logout" :
			action = new LogoutAction();
			break;
		case "searchUsers" :
			action = new SearchUsersAction();
			break;
		case "allUsers" :
			action = new AllUsersAction();
			break;
		case "changePwd" :
			action = new ChangePwdAction();
			break;
		case "editPassword" :
			action = new EditPasswordAction();
			break;
		case "deleteAccount" :
			action = new DeleteAccount();
			break;
		case "goToInformationPage" :
			action = new GoToInformationPageAction();
			break;
		case "goTochatPage" :
			action = new GoToChatPageAction();
			break;
		case "searchByUserName" :
			action = new SearchByUserNameAction();
			break;
		case "searchByCity"	:
			action = new SearchByCityAction();
			break;
		case "searchBySex" :
			action = new SearchBySexAction();
			break;
		case "searchByRelationship" :
			action = new SearchByRelationshipAction();
			break;
		case "searchByAge" :
			action = new SearchByAgeAction();
			break;
		case "goToBanUser" :
			action = new GoToBanUserAction();
			break;
		case "sendMessage" :
			action = new SendMessageAction();
			break;
		case "allUsersForAdmin" :
			action = new AllUsersForAdminAction();
			break;
		case "goToDeleteUserForAdmin" :
			action = new GoToDeleteUserForAdminAction();
			break;
		case "allBansForAdmin" :
			action = new AllBansForAdminAction();
			break;
			
		case "redirect" :
			action = new RedirectAction();
			break;
			
		}
		// Una volta scelta la classe da istanziare, esegue il comando e ritorna
		// una stringa che contiene
		// il percorso della pagina dove voglio andare
		String destination = null;
		try {
											destination = action.execute(request, response);
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// il dispatcher acquisisce la destinazione
		RequestDispatcher rd = request.getRequestDispatcher(destination);
		// manda il controllo alla pagina di destinazione
		rd.forward(request, response);
	}

}
