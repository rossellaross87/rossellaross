package com.ats.rossellaBiblioteca.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.rossellaBiblioteca.infrastructure.DataException;



public interface Command {
	String execute(HttpServletRequest request,HttpServletResponse response) throws DataException;
}
