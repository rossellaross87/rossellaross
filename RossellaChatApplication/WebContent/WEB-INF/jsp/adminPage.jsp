<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo utente</title>
</head>
<body>

	<label class="title">BENVENUTO/A ${user.userName}</label>
	<font face="verdana" color="blue">${message} </font>

	<fieldset>
		<legend>Menu</legend>
		<a href="changePwd.do"> Modifica Password </a> <a
			href="allUsersForAdmin.do"> LISTA DI TUTTI GLI UTENTI </a> <a
			href="allBansForAdmin.do"> LISTA DI TUTTE LE SEGNALAZIONI </a> <a
			href="logout.do"> Logout </a>
	</fieldset>


	<jsp:useBean id="user" scope="session"
		class="com.ats.RCApplication.domain.Utente" />
<h4 align="center">
<a href="index.jsp">Torna alla pagina iniziale</a>
</h4>
</body>
</html>