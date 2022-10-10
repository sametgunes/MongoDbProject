<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String user = (String) session.getAttribute("user");
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if(cookies !=null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("user")) user = cookie.getValue();
	}
	}
	%>
	<h3>Hi <%=user %>, do the checkout.</h3>
	<br>
	<table>
		<tr>
			<td>
				<form action="LogoutServlet" method="post">
				<input type="submit" value="Logout" >
				</form>
			</td>
			<td>
				<form action="HomeServlet" method="post">
				<input type="submit" value="Continue" >
				</form>
			</td>
		</tr>
	
	</table>

</body>
</html>