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
<h2 align="center"><font face="verdana" color="blue">${message}</font></h2>

<fieldset id="lista-utenti">
	<Legend>Lista Utenti</Legend>
	<table>
		<c:forEach var="user" items="${allUsers}">
			<tr>
				<td>USERNAME :</td>
				<td>${user.userName}</td>
				<td>
					<form action="goToInformationPage.do" method="POST">
						<input type="hidden" name="userId" value="${user.id}" />
						<input type="hidden" name="isEditable" value="false" />
						<div class="button">
						<input type="submit" value="Profilo"/></div>
					</form>
				</td>
				<td>
					<form action="goTochatPage.do" method="POST">
						<input type="hidden" name="userId" value="${user.id}" />
						<div class="button">
						<input type="submit" class= "chat" value="Chat"/></div>
					</form>
				</td>
				<td>
					<form action="goToBanUser.do" method="POST">
						<input type="hidden" class="id_user" name="userId" value="${user.id}" />
						<div class="button">
						<input type="submit" class="ban" value="Segnala"/></div>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</fieldset>
	
	<script>
	var body = document.getElementsByTagName("body")[0];
	body.onload = function() {
		var sessionId = "<%= request.getSession().getAttribute("currentId") %>";
		var id_users = document.getElementsByClassName("id_user");
		var buttons_ban = document.getElementsByClassName("ban");
		var buttons_chat = document.getElementsByClassName("chat");
		
		for (var i = 0; i < id_users.length; i++) {
			var id = id_users[i];
			var button_ban = buttons_ban[i];
			
			if (id.value == sessionId){
				button_ban.style.display = "none";
			}
			else {
				button_ban.style.display = "";
			}
			}
		for (var i = 0; i < id_users.length; i++) {
			var id = id_users[i];
			var button_chat = buttons_chat[i];
			
			if (id.value == sessionId){
				button_chat.style.display = "none";
			}
			else {
				button_chat.style.display = "";
			}
			}
		
		
		}
	;
	</script>

		<form action="redirect.do" method="post">
			<input type="hidden" name="page" value="mainMenu.jsp" /> <input
				type="submit" value="Torna alla home" />
				
		</form>
		
</body>
</html>