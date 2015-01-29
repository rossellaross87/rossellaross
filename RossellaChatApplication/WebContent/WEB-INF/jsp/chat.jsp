<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat</title>
</head>
<body>
	<h2 align="center">
		<font face="verdana" color="blue">${message}</font>
	</h2>
	<form action="sendMessage.do" method="POST">
		<fieldset>
			<legend> CHAT CON ${receiver.userName}</legend>
			<div class="field">
				<textarea rows="4" cols="50" name="msgText" onFocus="this.value='';">INSERISCI IL MESSAGGIO </textarea>
			</div>
			<div class="button">
				<input type="submit" value="SEND MSG" /> <input type="hidden"
					class="id_user" name="receiverId" value="${receiver.id}" />
			</div>
		</fieldset>

	</form>


	<form action="goTochatPage.do" method="POST" id="cronologia">
		<fieldset>
			<legend>Cronologia</legend>
			<div class="button">
				<input type="submit" value="RICARICA"/>
				<input type="hidden"
					class="id_user" name="userId" value="${receiver.id}"/>
			</div>
			<table align="center" border="2">
				<tr>
					<td>MITT</td>
					<td>DEST</td>
					<td>MESSAGGIO</td>
					<td>DATA</td>
				</tr>
				<c:forEach var="msg" items="${messaggi}">
					<tr>
						<td>${msg.userSender}</td>
						<td>${msg.userReceiver}</td>
						<td>${msg.text}</td>
						<td>${msg.dateMessString}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</form>


		<form action="redirect.do" method="post">
			<input type="hidden" name="page" value="mainMenu.jsp" /> <input
				type="submit" value="Torna alla home" />
				
		</form>
</body>
</html>