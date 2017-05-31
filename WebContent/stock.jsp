<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.ItemBean"%>
<%
	ArrayList<ItemBean> producersItem = (ArrayList<ItemBean>)request.getAttribute("producersItem");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>VegeSel</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css"/>
		<link rel="stylesheet" type="text/css" href="login.css"/>
		<link rel="stylesheet" type="text/css" href="footer.css"/>
		<link rel="stylesheet" type="text/css" href="shopping.css"/>
		<link rel="stylesheet" type="text/css" href="needLogin.css"/>
	</head>
	<body>
		<%@include file="header.jsp"%>
		<div class="container maincontent">
			<div class="row width100margin0">
				<div class="col-md-8">
					<h3 class="h3">商品一覧</h3>
					<table>
							<thead>
								<tr>
								<th>商品ID</th>
								<th>商品名</th>
								<th>価格</th>
								<th>在庫数</th>
								<th></th>
								<th></th>
								</tr>
							</thead>
							<tbody>
								<% for ( ItemBean bean : producersItem) { %>
									<form action="viewstock" method="post">

										<tr>
											<td><%=bean.getItemId() %></td><input type="hidden" name="itemId" value="<%=bean.getItemId() %>" />
											<td><%=bean.getItemName() %></td>
											<td><%=bean.getItemPrice() %></td>
											<td><%=bean.getItemQuantity() %></td>
											<td>在庫数を変更する:<input type="number" name="quantity"></input></td>
											<td><button type="submit">変更</button></td>
										</tr>
									</form>
								<%} %>
							</tbody>
					</table>
				</div>
				<div class="col-md-4">
					<jsp:include page="login.jsp" />
				</div>
			</div>
		</div>
		<%@include file="footer.html" %>
		<%@include file="script.html" %>
	</body>
</html>