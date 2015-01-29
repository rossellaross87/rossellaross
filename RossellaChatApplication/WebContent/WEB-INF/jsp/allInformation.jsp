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
	<form action="editRegistration.do" method="POST">
	<fieldset>
		<legend>DETTAGLI DEL PROFILO</legend>
		<div class="field">
				<label>NOME :</label>
				<input type="text" name="name" value="${info.name}" />
				<label>COGNOME :</label>
				<input type="text" name="lastName" value="${info.lastName}" />
				<label>CITTA' :</label>
				<input type="text" name="city" value="${info.city}" />
				<label>SESSO :</label>
				<input type="radio" name="sex" value="M"
					<c:if test= "${info.sex == 'M'}" > checked </c:if> /> <span class="radio-label">MASCHIO</span>
				<input type="radio" name="sex" value="F"
					<c:if test= "${info.sex == 'F'}" > checked </c:if> /> <span class="radio-label">FEMMINA</span>
				<label>NAZIONALITA' :</label>
				<input type="text" name="country" value="${info.country}" />
				<label>ALTEZZA :</label>
				<input type="text" name="height" value="${info.height}" />
				<label>ASPETTO FISICO :</label>
				<select name="look" onchange="">
						<option value=""
							<c:if test= "${info.look == ''}" > selected </c:if>></option>
						<option value="ATLETICO"
							<c:if test= "${info.look == 'ATLETICO'}" > selected </c:if>>ATLETICO/A</option>
						<option value="MAGRO"
							<c:if test= "${info.look == 'MAGRO'}" > selected </c:if>>MAGRO/A</option>
						<option value="MEDIO"
							<c:if test= "${info.look == 'MEDIO'}" > selected </c:if>>CORPORATURA
							MEDIA</option>
						<option value="IN_CARNE"
							<c:if test= "${info.look == 'IN_CARNE'}" > selected </c:if>>IN
							CARNE</option>
				</select>
				<label>SITUAZIONE SENTIMENTALE :</label>
				<select name="relationship" onchange="">
						<option value=""
							<c:if test= "${info.relationship == ''}" > selected </c:if>>
						</option>
						<option value="SINGLE"
							<c:if test= "${info.relationship == 'SINGLE'}" > selected </c:if>>SINGLE</option>
						<option value="IMPEGNATO"
							<c:if test= "${info.relationship == 'IMPEGNATO'}" > selected </c:if>>IMPEGNATO/A</option>
						<option value="SPOSATO"
							<c:if test= "${info.relationship == 'SPOSATO'}" > selected </c:if>>SPOSATO/A</option>
						<option value="DIVORZIATO"
							<c:if test= "${info.relationship == 'DIVORZIATO'}" > selected </c:if>>DIVORZIATO/A</option>
				</select>
				<label>ISTRUZIONE :</label>
				<select name="education" onchange="">
						<option value=""
							<c:if test= "${info.education == ''}" > selected </c:if>></option>
						<option value="MASTER"
							<c:if test= "${info.education == 'MASTER'}" > selected </c:if>>MASTER</option>
						<option value="LAUREA"
							<c:if test= "${info.education == 'LAUREA'}" > selected </c:if>>LAUREA</option>
						<option value="DIPLOMA"
							<c:if test= "${info.education == 'DIPLOMA'}" > selected </c:if>>DIPLOMA</option>
						<option value="SCUOLA"
							<c:if test= "${info.education == 'SCUOLA'}" > selected </c:if>>SCUOLA
							DELL' OBBLIGO</option>
				</select>
				<label>LAVORO :</label>
				<input type="text" name="job" value="${info.job}" />
				<label>HOBBIES :</label>
				<input type="text" name="hobbies" value="${info.hobbies}" />
				<label>ETA' :</label>
				<input type="text" name="age" value="${info.age}" />
			</div>
		<jsp:useBean id="info" scope="session"
			class="com.ats.RCApplication.domain.Informazioni" />

		<%
			request.getSession().setAttribute("currentId", info.getIdUser());
		%>
		<div class="button">
			<input type="hidden" id="isEditable" value="${isEditable}" /> <input
				type="submit" value="Modifica" id="submit" />
		</div>

		<script>
			var body = document.getElementsByTagName("body")[0];
			body.onload = function() {
				var button = document.getElementById("submit");
				var isEditable = document.getElementById("isEditable").value;

				if (isEditable != null && isEditable != ""
						&& isEditable == "true")
					button.style.display = "";
				else
					button.style.display = "none";
			};
		</script>
		</fieldset>
	</form>

	<h4 align="center">
		<a href="goToMainMenu.do">Torna al menu</a>

	</h4>


</body>
</html>