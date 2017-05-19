<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.ItemBean"%>
<%
	ArrayList<ItemBean> beanList = (ArrayList<ItemBean>)request.getAttribute("itemBeanList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<style>
		<%@include file="shopping.css" %>
	</style>
	<title>商品一覧</title>
	</head>
	<body>
		<jsp:include page="vegetalianHeader.jsp"/>
		<div id="main">
			<h1>商品一覧</h1>
			<table>
				<form action="buyitem" method="post">
					<thead>
						<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫数</th>
						<th>数量</th>
						<th></th>
						</tr>
					</thead>
					<tbody>
						<% for ( ItemBean bean : beanList) { %>
							<form>
								<tr>
									<td><%=bean.getItemId() %></td><input type="hidden" name="item" value="<%=bean.getItemId() %>" />
									<td><%=bean.getItemName() %></td>
									<td><%=bean.getItemPrice() %></td>
									<td>

									</td>
									<td>
										<select name="<%= bean.getItemId() %>list">
											<% for(int i = 0; i <= bean.getItemQuantity(); i++ ) {%>
												<option value=<%=i%>><%=i%></option>
											<% }%>
										</select>
									</td>
									<td><button type="submit">購入する</button></td>
								</tr>
							</form>
						<%} %>
					</tbody>
				</form>
			</table>
			<p><a href="login.jsp"><button>戻る</button></a></p>
		</div>
	</body>
</html>