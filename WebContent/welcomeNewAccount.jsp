<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css">
		<link rel="stylesheet" type="text/css" href="login.css">
		<link rel="stylesheet" type="text/css" href="footer.css">
		<link rel="stylesheet" type="text/css" href="shopping.css">
	</head>
	<body>
		<%@include file="vegetalianHeader.jsp"%>
		<div class="container maincontent">
			<div class="center-block">
				<h3 class="h3">アカウント作成の完了</h3>
				<p>アカウント作成が終了いたしました。引き続きショッピングをお楽しみください。</p>
				<jsp:include page="login.jsp" />
			</div>
		</div>
		<%@include file="footer.html" %>
	</body>
</html>