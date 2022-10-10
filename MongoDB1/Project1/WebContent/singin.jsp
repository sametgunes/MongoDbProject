<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
	table {
	  text-align: center;
      margin: auto;
	}
</style>
<body style="background-color:powderblue;">
	<form action ="handle_login" method="post">
		<table>
			<tr>
				<td><h2 style="color:red;">Welcome To Login Page!</h2></td>
			</tr>
			<tr>
				<td> Name: <input type="text" name="name"> </td>
			</tr>
			<tr>
				<td> UserName: <input type="text" name="username"> </td>
			</tr>
			<tr>
				<td> Password:  <input type="password" name="pwd">  </td>
			</tr>
			<tr>
				<td> <input type="submit" value="login"> </td> 
			</tr>
		</table>
	</form>
</body>
</html>