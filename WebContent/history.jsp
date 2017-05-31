<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user_db" scope="session" class="bean.LoginUserBean" />
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.HistoryBean"%>
<% String userName = (String)session.getAttribute("userName"); %>
<%
	ArrayList<HistoryBean> historyList = (ArrayList<HistoryBean>)request.getAttribute("historyList");
%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8"/>
		<style>
			<%@include file="shopping.css" %>
		</style>
		<title>VegeSel - 購入履歴</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css">
		<link rel="stylesheet" type="text/css" href="login.css">
		<link rel="stylesheet" type="text/css" href="footer.css">
		<link rel="stylesheet" type="text/css" href="shopping.css">
	</head>
	<body>
		<%@include file="header.jsp"%>
		<div class="container maincontent">
			<div class="row width100margin0">
				<div class="col-md-8">
					<h1><%=userName %>さんの購入確認</h1>
					<table>
						<thead>
							<th>商品ID</th>
							<th>商品名</th>
							<th>購入数</th>
						</thead>
						<tbody>
							<%for(HistoryBean history: historyList){%>
								<tr>
									<td><%=history.getItemId() %><td>
									<td><%=history.getItemName() %><td>
									<td><%=history.getItemByQuantity() %><td>
								</tr>
							<%} %>
						</tbody>
					</table>
					<p><a href="modechange"><button>トップページに戻る</button></a></p>
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