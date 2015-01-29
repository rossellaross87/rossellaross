<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione </title>
</head>
<body bgcolor = "F6D11D">

<h2 align = "center">
<font face="verdana" color = "blue">${message} </font></h2>
<form action="saveRegistration.do" method="POST">
<h1 align="center"  > 
<font face="verdana" color = "blue">Inserisci i tuoi dati <br> e registrati  </font></h1> 
<table align = "center" border = "2"  color="blue">
<tr><td><Label font = "verdana">USERNAME :</Label></td><td><input type = "text" name="userName" value=""/></td>
</tr>
<tr><td><Label font = "verdana">PASSWORD :</Label></td><td><input type = "text" name="password" value=""/></td>
</tr>
<tr><td><Label font = "verdana">NOME :</Label></td><td><input type = "text" name="name" value=""/></td>
</tr>
<tr><td><Label font = "verdana">COGNOME :</Label></td><td><input type = "text" name="lastName" value=""/></td>
</tr>
<tr><td><Label font = "verdana">CITTA' :</Label></td><td><input type = "text" name="city" value=""/></td>
</tr>
<tr><td><Label font = "verdana">SESSO :</Label></td><td><input type="radio" name="sex" value="M"> MASCHIO</input>
<input type="radio" name="sex" value="F"> FEMMINA </input></td>
</tr>
<tr><td><Label font = "verdana">NAZIONALITA' :</Label></td><td><input type = "text" name="country" value=""/></td>
</tr>
<tr><td><Label font = "verdana">ALTEZZA :</Label></td><td><input type = "text" name="height" value=""/></td>
</tr>
<tr><td><Label font = "verdana">ASPETTO FISICO :</Label></td><td><select name="look" onchange="">
<option value=""></option>
<option value="ATLETICO">ATLETICO/A</option>
<option value="MAGRO">MAGRO/A</option>
<option value="MEDIO">CORPORATURA MEDIA</option>
<option value="IN_CARNE">IN CARNE</option>
</select></td>
</tr>
<tr><td><Label font = "verdana">STATO SENTIMENTALE :</Label></td><td><select name="relationship" onchange="">
<option value=""></option>
<option value="SINGLE">SINGLE</option>
<option value="IMPEGNATO">IMPEGNATO/A</option>
<option value="SPOSATO">SPOSATO/A</option>
<option value="DIVORZIATO">DIVORZIATO/A</option>
</select>  </td>
</tr>
<tr><td><Label font = "verdana">ISTRUZIONE :</Label></td><td><select name="education" onchange="">
<option value=""></option>
<option value="MASTER">MASTER</option>
<option value="LAUREA">LAUREA</option>
<option value="DIPLOMA">DIPLOMA</option>
<option value="SCUOLA">SCUOLA DELL' OBBLIGO</option>
</select></td>
</tr>
<tr><td><Label font = "verdana">LAVORO :</Label></td><td><input type = "text" name="job" value=""/></td>
</tr>
<tr><td><Label font = "verdana">HOBBIES :</Label></td><td><input type = "text" name="hobbies" value=""/></td>
</tr>
<tr><td><Label font = "verdana">ETA' :</Label></td><td><input type = "text" name="age" value=""/></td>
</tr>
</table>
<br>
<br>
<h2 align = "center"><input type="submit" align="right"
		value="REGISTRATI" style="background-color: #0099CC; "/>
</h2>
</form>
<br>
<br>
<h4 align="center">
<a href="index.jsp">Torna alla pagina iniziale</a>

</h4>
</body>
</html>