<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utenti registrati</title>
</head>
<body>
	<h2 align="center">
		<font face="verdana" color="blue">${message}</font>
	</h2>

	<fieldset id="lista-utenti">
		<Legend>Lista Utenti</Legend>
		<c:forEach var="user" items="${allUsers}">
			<div class="field">
				<label>USERNAME :</label> <input type="text"
					value="${user.userName}" /> <label>E' AMMINISTRATORE ? </label> <input
					type="text" value="${user.admin}" /> <label>E' BANNATO ?</label> <input
					type="text" value="${user.banned}" />
			</div>

			<form action="goToInformationPage.do" method="POST">
				<input type="hidden" name="userId" value="${user.id}" /> <input
					type="hidden" name="isEditable" value="false" />
				<div class="button">
					<input type="submit" value="Profilo" />
				</div>
			</form>

			<form action="goToDeleteUserForAdmin.do" method="POST">
				<input type="hidden" class="id_user" name="userId"
					value="${user.id}" />
				<div class="button">
					<input type="submit" class="ban" value="Cancella" />
				</div>
			</form>
		</c:forEach>
	</fieldset>


		<form action="redirect.do" method="post">
			<input type="hidden" name="page" value="adminPage.jsp" /> <input type="submit"
				value="Torna alla home" />
		</form>
	
</body>
</html>