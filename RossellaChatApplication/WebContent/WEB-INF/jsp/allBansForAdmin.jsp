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
		<Legend>Lista Segnalazioni</Legend>
		<div class="field">
			<c:forEach var="ban" items="${allBans}">
				<fieldset>
					<label>SEGNALATORE :</label> <input type="text"
						value="${ban.userNameBanner}" disabled /> <label>SEGNALATO
						:</label> <input type="text" value="${ban.userNameBanned}" disabled /> <label>DATA
						SEGNALAZIONE:</label> <input type="text" value="${ban.dateBanString}"
						disabled />
				</fieldset>
			</c:forEach>
		</div>
	</fieldset>

	
		<form action="redirect.do" method="post">
			<input type="hidden" name="page" value="adminPage.jsp" /> <input
				type="submit" value="Torna alla home" />
		</form>
	
</body>
</html>