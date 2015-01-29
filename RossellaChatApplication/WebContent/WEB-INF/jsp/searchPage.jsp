<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca utenti</title>
</head>
<body>
	<form action="searchByUserName.do" method="POST">
	<fieldset>
		<legend>Cerca Utente</legend>
		<div class="field">
			<label>Username</label>
			<input type="text" name="username" value="" />
		</div>
		<div class="button">
			<input type="submit" value="Cerca"/>
		</div>
	</fieldset>
	</form>

	<form action="searchByCity.do" method="POST">
	<fieldset>
		<legend>Cerca Città</legend>
		<div class="field">
			<label>Città</label>
			<input type="text" name="username" value="" />
		</div>
		<div class="button">
			<input type="submit" value="Cerca"/>
		</div>
	</fieldset>
	</form>

	<form action="searchBySex.do" method="POST">
		<fieldset>
			<legend>Cerca per sesso</legend>
			<div class="field">
				<label>Sesso</label>
				<input type="radio" name="sex" value="M"/> <span class="radio-label">MASCHIO</span> 
				<input type="radio" name="sex" value="F"/> <span class="radio-label">FEMMINA</span>
			</div>
		<div class="button">
			<input type="submit" value="Cerca"/>
		</div>
		</fieldset>
	</form>

	<form action="searchByRelationship.do" method="POST">
	<fieldset>
		<legend>Cerca Stato Sentimentale</legend>
		<div class="field">
			<label>Stato</label>
			<select name="relationship" onchange="">
						<option value=""></option>
						<option value="SINGLE">SINGLE</option>
						<option value="IMPEGNATO">IMPEGNATO/A</option>
						<option value="SPOSATO">SPOSATO/A</option>
						<option value="DIVORZIATO">DIVORZIATO/A</option>
				</select>
		</div>
		<div class="button">
			<input type="submit" value="Cerca"/>
		</div>
	</fieldset>
	</form>

	<form action="searchByAge.do" method="POST">
	<fieldset>
		<legend>Cerca Per Eta'</legend>
		<div class="field">
			<label>Maggiore/Uguale</label>
			<input type="text" name="age1" value="" />
			<label>Minore/Uguale</label>
			<input type="text" name="age1" value="" />
		</div>
		<div class="button">
			<input type="submit" value="Cerca"/>
		</div>
	</fieldset>
	</form>

	<br>
	<h4 align="center">
		<a href="goToMainMenu.do">Torna al menu</a>

	</h4>
</body>
</html>