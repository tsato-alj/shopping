<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ItemBean"%>
<%
	ItemBean item = (ItemBean)request.getAttribute("item");
	String itemId = item.getItemId();
	String itemName = item.getItemName();
	int itemPrice = item.getItemPrice();
	int quantity = item.getItemQuantity();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<style>
		<%@include file="shopping.css" %>
	</style>
	<title>VegeSel - 購入確認</title>
	</head>
	<body>
		<%@include file="header.jsp"%>
		<div id="main">
			<h1>商品一覧</h1>
			<p>つぎの商品を購入しますか?</p>
			<table>
				<form action="result" method="get">
					<thead>
						<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫数</th>
						<th>購入数</th>
						<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><%=itemId %></td><input type="hidden" name="item_id" value="<%=itemId%>">
							<td><%=itemName %></td>
							<td><%=itemPrice %></td>
							<td><%=quantity %></td><input type="hidden" name="quantity" value="<%=request.getAttribute("quantity")%>">
							<td><%=request.getAttribute("quantity")%></td>
							<td><button type="submit">購入する</button></td>
						</tr>
					</tbody>
				</form>
			</table>
			<p><a href="itmlist"><button>戻る</button></a></p>
		</div>
		<%@include file="footer.html" %>
		<%@include file="script.html" %>
	</body>
</html>