<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>ショッピングサイトへようこそ!</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css">

		<link rel="stylesheet" type="text/css" href="login.css">
		<link rel="stylesheet" type="text/css" href="shopping.css">
		<link rel="stylesheet" type="text/css" href="footer.css">

	</head>
	<body>
		<div class="maincontent">
			<%@include file="header.jsp" %>
			<div class="container">
				<div class="row">
					<div class="col-md-8">
					</div>
		   			<div class="col-md-4">
		    			<%@include file="login.jsp" %>
		    		</div>
	    		</div>
			</div>
		</div>
		<%@include file="footer.html" %>
		<%@include file="script.html" %>
	</body>
</html>