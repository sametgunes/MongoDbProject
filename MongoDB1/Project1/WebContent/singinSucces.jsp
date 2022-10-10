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
	String userName = (String) session.getAttribute("username");
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if(cookies !=null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("user")) user = cookie.getValue();
		if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
	}
	}
	%>
	<h3>Hi <%=user %>, Login successful. Your Session ID = <%=sessionID %></h3>
	<br>
	User = <%=userName %>
	<br>
	<table>
		<tr> 
			<td> <a href="CheckOut.jsp">Checkout Page</a> </td>
			<form action="LogoutServlet" method="post">
			<td></td>
			<td> <input type="submit" value="Logout" ></td>
			</form>	
		</tr>
		
	</table>
	
</body>
</html>