package com.ats.rossellaBiblioteca.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.rossellaBiblioteca.infrastructure.DataException;




/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		int beginIndex=uri.lastIndexOf("/");
		int endIndex=uri.lastIndexOf(".do");
		String command=uri.substring(beginIndex+1, endIndex);
		System.out.println(command);
     	Command action= new NoCommandAction();
     	//Questo switch sceglie il comando da eseguire in base alla stringa contenuta nell'uri prima di .do
     			switch (command){
     			case "saveBook":
     				action = new SaveBookAction();
     				break;
     			case "allAuthors": 
     				action = new AllAuthorsAction();
     				//destination = allCourses(request,response);
     				break;
     			case "searchBooks": 
     				action = new SearchBooksAction();
     				break;
     			case "BooksOfAuthor": 
     				action = new BooksOfAuthorAction();
     				break;
     			case "DeleteBook": 
     				action = new DeleteBookAction();
     				break;
     			case "AllBooks" :
     				action= new AllBooksAction();
     				break;
     			case "ShoppingBook" :
     				action= new ShoppingBookAction();
     				break;
     			}
     			//Una volta scelta la classe da istanziare, esegue il comando e ritorna una stringa che contiene
     			//il percorso della pagina dove voglio andare
     			String destination = null;
     			try {
     				destination = action.execute(request, response);
     			} catch (DataException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
     			//il dispatcher acquisisce la destinazione
     			RequestDispatcher rd= request.getRequestDispatcher(destination);
     			//manda il controllo alla pagina di destinazione
     			rd.forward(request, response);
	}

}
