<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page!!</title>
</head>
<body  bgcolor="F6D11D" >
<h1 align="center"> <font  font="verdana" color ="blue">HAI SBAGLIATO QUALCOSA </font></h1>
<div align="center"> ${message} </div>
<h2 align="center">
<a href="index.jsp">Torna alla pagina iniziale</a>
<script type="text/javascript" >
<input type="button" value="Torna indietro" name="goBack" 
onclick="document.forms[0].action = 'index.jsp'; return true;" />
</script>
</h2>
</body>
</html>