<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo utente</title>
</head>
<body bgcolor="F6D11D">
	<h1 align="center">
		<font face="verdana" color="blue">ECCO I DETTAGLI DEL TUO
			PROFILO :</font>
	</h1>
	<table align="center" border="2" color="blue">
		<c:forEach var="account" items="${accountDetails}">
			<tr>
				<td>${account.userName}</td>
			</tr>
			<tr>
				<td>${account.password}</td>
			</tr>


		</c:forEach>
	</table>
	<table align="center" border="2" color="blue">
		<c:forEach var="info" items="${informations}">
			<tr>
				<td>${info.name}</td>
			</tr>
			<tr>
				<td>${info.lastName}</td>
			</tr>
			<tr>
				<td>${info.city}</td>
			</tr>
			<tr>
				<td>${info.sex}</td>
			</tr>
			<tr>
				<td>${info.country}</td>
			</tr>
			<tr>
				<td>${info.height}</td>
			</tr>
			<tr>
				<td>${info.look}</td>
			</tr>
			<tr>
				<td>${info.relationship}</td>
			</tr>
			<tr>
				<td>${info.education}</td>
			</tr>
			<tr>
				<td>${info.job}</td>
			</tr>
			<tr>
				<td>${info.hobbies}</td>
			</tr>
			<tr>
				<td>${info.age}</td>
			</tr>


		</c:forEach>
	</table>

</body>
</html>