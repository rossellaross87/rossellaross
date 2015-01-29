<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli account</title>
</head>
<body>
	<h2 align="center">
	<font face="verdana" color="blue">${message}</font></h2>

	<form action="editPassword.do" method="POST">
	<fieldset>
		<legend>Cambia password :</legend>
		<div class="field">
				<label>Username :</label>
				<input type="text" value="${user.userName}" disabled/>
				<label>Password :</label>
				<input type="password" name="password" value="${user.password}" />
				<label>Conferma nuova password :</label>
				<input type="password" name="password2" value="" />
		</div>
		<div class="button">
			<input type="submit" value="Modifica" />
		</div>
	</fieldset>
	</form>

	<h4 align="center">
		<a href="index.jsp">Torna alla pagina iniziale</a>

	</h4>


</body>
</html>