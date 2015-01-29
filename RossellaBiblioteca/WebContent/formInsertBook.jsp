<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci uno libro </title>
</head>
<body bgcolor = "lightgreen">
${message}
<form action="saveBook.do" method="POST">
<h1 align="center"  > 
<font face="verdana" color = "green">Inserisci qui sotto un nuovo libro </font></h1> 
<table align = "center" border = "2"  color="blue">
<tr><td><Label font = "verdana">ISBN :</Label></td><td><input type = "text" name="isbn" value=""/></td>
</tr>
<tr><td><Label font = "verdana">TITOLO :</Label></td><td><input type = "text" name="titolo" value=""/></td>
</tr>
<tr><td><Label font = "verdana">DESCRIZIONE :</Label></td><td><input type = "text" name="descrizione" value=""/></td>
</tr>
<tr><td><Label font = "verdana">PREZZO :</Label></td><td><input type = "text" name="prezzo" value=""/></td>
</tr>
<tr><td><Label font = "verdana">NUMERO DI PAGINE :</Label></td><td><input type = "text" name="numPagine" value=""/></td>
</tr>
<tr><td><Label font = "verdana">CATEGORIA :</Label></td><td><input type = "text" name="categoria" value=""/></td>
</tr>
<tr><td><Label font = "verdana">EDITORE :</Label></td><td><input type = "text" name="editore" value=""/></td>
</tr>

</table>
<input type="submit" align="right"
		value="inserisci il libro" style="background-color: Green; "/>

</form>
</body>
</html>