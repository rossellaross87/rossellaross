<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" href="css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
<form action="login.do" method="POST">
	<fieldset>
		<legend>Sign in</legend>
		<div class="field">
			<label>USERNAME :</Label>
			<input type = "text" name="userName" value=""/>
			<Label>PASSWORD :</Label>
			<input type = "password" name="password" value=""/>
		</div>
		<div class="button">
			<input type="submit"/>
		</div>
	</fieldset>
</form>

<form action="registration.do" method ="POST">
	<div class="button">
		<input type="submit" value="Registrati"/>
	</div>
</form>
<div class="message">${MESSAGE}</div>

</body>
</html>