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
		<title>購入履歴</title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div id="main">
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
			<p><a href="shopping"><button>一覧に戻る</button></a></p>
		</div>
	</body>
</html>