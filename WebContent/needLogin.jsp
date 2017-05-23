<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Javavege-ログインページ</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css"/>
		<link rel="stylesheet" type="text/css" href="login.css"/>
		<link rel="stylesheet" type="text/css" href="footer.css"/>
		<link rel="stylesheet" type="text/css" href="shopping.css"/>
		<link rel="stylesheet" type="text/css" href="needLogin.css"/>
	</head>
	<body>
	<%@include file="producerHeader.jsp"%>
	<div class="maincontent">
		<div class="alert alert-info center-block needlogin text-center">このサービスにはログインが必要です</div>


			<div id="logbox">
				<%
					String mode = null;
					if(session.getAttribute("mode") != null){
						mode = (String)session.getAttribute("mode");
						request.setAttribute("mode", mode);
					}
				%>

				<form id="signup" method="post" action="needlogin">
					<h1>account login</h1>
					<input name="id" type="text" placeholder="ID" class="input pass"/>
					<input name="pass" type="password" placeholder="Password" required="required" class="input pass"/>
					<input name="mode" type="hidden" value="<%=mode %>"/>
					<button type="submit" class="inputButton">Login</button>
				</form>
				<div class="text-center">
				   	<a href="#" id="">create an account</a> - <a href="#" id="">forgot password</a>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.html" %>

	</body>
</html>