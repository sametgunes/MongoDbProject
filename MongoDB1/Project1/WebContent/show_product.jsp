<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<style>
	div{
		
		border:1px solid black;
 	 	text-align: center;
 	 	width: 500px;
 	 	position: relative;
        margin: auto;
		
 	 }
	p{
		text-align: center;
	}
	img {
		  opacity: 1;
		  display: block;
		  width: 490px;
		  height: 490px;
		  backface-visibility: hidden;
		  text-align: center;
		  position: relative;
       	  margin: auto;
		}
	p {

		  font-size: 26px;
		  text-align: center;
		}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<div>
				<h1> ${requestScope.product.name} </h1>
			</div>
			<div>
				<p> <img src="${requestScope.product.picture}"  alt="Avatar"> </p>
				<p> Description: ${requestScope.product.description} </p>
				<p> Price (Avarage 2 people): ${requestScope.product.price}TL</p>
				<p> Address: ${requestScope.product.a}</p>
				<p> District: ${requestScope.product.konum}</p>
			</div>
</body>
</html>




