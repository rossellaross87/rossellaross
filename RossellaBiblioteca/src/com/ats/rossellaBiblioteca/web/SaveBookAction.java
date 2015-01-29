package com.ats.rossellaBiblioteca.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.rossellaBiblioteca.domain.Book;
import com.ats.rossellaBiblioteca.infrastructure.BibliotecaRepository;
import com.ats.rossellaBiblioteca.infrastructure.DataException;
import com.sun.org.apache.xpath.internal.operations.Or;


public class SaveBookAction implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws DataException {
		BibliotecaRepository rep = new BibliotecaRepository();
		String isbn = (String) request.getParameter("isbn");
		String titolo = (String) request.getParameter("titolo");
		String descrizione = (String) request.getParameter("descrizione");
		String prezzo = (String) request.getParameter("prezzo");
		String numPagine =(String) request.getParameter("numPagine");
		String categoria = (String) request.getParameter("categoria");
		String editore = (String) request.getParameter("editore");
//		
//			if(isbn==null || isbn.equals("") || titolo==null || titolo.equals("") || descrizione==null
//				|| descrizione.equals("") || prezzo == null || prezzo.equals("" ) ||
//				numPagine==null|| numPagine.equals("") || categoria==null || categoria.equals("")
//				|| editore == null || editore.equals("")
//	){request.setAttribute("message", "non hai inserito un campo");}
//
//		
//		return "formInsertBook.jsp";
//		else 	{
		try {
			double price = Integer.parseInt(prezzo);
			int nrPag = Integer.parseInt(numPagine);
			System.out.println("sono il saveBook " + price + " "
					+ nrPag);
			// ArrayList<String> parameterNames = new ArrayList<String>();
			Book b = new Book(isbn, titolo, descrizione, price, nrPag, categoria, editore);
			
			b = rep.save(b);
		} catch (NumberFormatException e ) {
			
			if(isbn==null || isbn.equals("") || titolo==null || titolo.equals("") || descrizione==null
					|| descrizione.equals("") || prezzo == null || prezzo.equals("" ) ||
					numPagine==null|| numPagine.equals("") || categoria==null || categoria.equals("")
					|| editore == null || editore.equals("")
		){request.setAttribute("message", "non hai inserito un campo");}

			
			return "formInsertBook.jsp";
		}
		request.setAttribute("message", "salvataggio eseguito con successo");
		return "formInsertBook.jsp";
	}

}
