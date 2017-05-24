<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String itemId = (String)request.getAttribute("itemId");
	String itemName = (String)request.getAttribute("itemName");
	String category = (String)request.getAttribute("category");
	Integer price = (Integer)request.getAttribute("price");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>ProuVege 商品登録内容の確認</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css">
		<link rel="stylesheet" type="text/css" href="login.css">
		<link rel="stylesheet" type="text/css" href="footer.css">
		<link rel="stylesheet" type="text/css" href="shopping.css">
		<link rel="stylesheet" type="text/css" href="recordItem.css">
	</head>
	<body>
	 	<div class="maincontent">
			<div class="col-md-8">
				<div class="center-block">
					<h3 class="h3">商品登録内容の確認</h3>
					<p>以下の内容でよろしいでしょうか?</p>
					<form action="resultrecorditem">
						<p>商品ID:<%=itemId %><input type="hidden" name="itemId" value="<%=itemId %>"/></p>
						<p>商品名:<%=itemName %><input type="hidden" name="itemName" value="<%=itemName %>"/></p>
						<p>カテゴリー:<%=category %><input type="hidden" name="category" value="<%=category %>"/></p>
						<p>価格:&yen<%=price %><input type="hidden" name="price" value="<%=price %>"/></p>
						<p><button type="submit" class="btn btn-default submit"><i class="fa fa-paper-plane" aria-hidden="true"></i>  Submit</button></p>
					</form>
				</div>
			</div>
			<div class="col-md-4">
				<jsp:include page="login.jsp" />
			</div>
		</div>
		<%@include file="footer.html" %>
	</body>
</html>