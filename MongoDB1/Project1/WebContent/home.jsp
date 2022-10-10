<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import=" model.Product , wp.Controller" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#sag {
	  float: center;
      width: 300px;
      border:1px solid black;
 	  text-align: center;
 	  position: relative;
      margin-left: 260px;
      margin-bottom: 110px;
    }
    #sol{
   	  float: right;
      width: 300px;
      border:1px solid black;
 	  text-align: center;
 	  position: relative;
      margin-right: 200px;
      margin-bottom: 100px;
    }
    .container {
	  position: relative;
	  text-align: center;
	  width: 100%;
	}
	
	.image {
	  opacity: 1;
	  display: block;
	  width: 100px;
	  height: 200px;
	  backface-visibility: hidden;
	  text-align: center;
	}
	
	.middle {
	  transition: .5s ease;
	  opacity: 0;
	  position: absolute;
	  top: 50%;
	  left: 50%;
	  transform: translate(-50%, -50%);
	  -ms-transform: translate(-50%, -50%);
	  text-align: center;
	}
	
	.container:hover .image {
	  opacity: 0.3;
	}
	
	.container:hover .middle {
	  opacity: 1;
	  text-align: center;
	}
	
	.text {
	  background-color: #000000;
      color: white;
  	  font-size: 16px;
 	  padding: 16px 32px;
  	  text-align: center;
	}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${username}">
		<div id=sag>
			<p><img src="DEU65siXUAAOmyc.jpg" style="width:70%"></p>
			<p> Hello my friend ${username} , welcome to my page.</p>
			<p> admin@hotmail.com</p>
		</div>
	</c:forEach>
	
	<c:forEach items="${requestScope.prods}" var="item">
		<div id=sol>
			<div class="container">
					<img src="${item.picture}"  alt="Avatar" class="image" style="width:100%">
					<div class="middle">
						<p><a href="handle_login?id=${item.id}">${item.name} </a></p>
					</div>
			</div>
		</div>
	</c:forEach>
	
	
</body>
</html>








