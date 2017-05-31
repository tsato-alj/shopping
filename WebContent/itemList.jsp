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
		<title>VegeSel - 商品一覧</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css"/>
		<link rel="stylesheet" type="text/css" href="login.css"/>
		<link rel="stylesheet" type="text/css" href="footer.css"/>
		<link rel="stylesheet" type="text/css" href="shopping.css"/>
		<link rel="stylesheet" type="text/css" href="needLogin.css"/>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="container maincontent">
			<div class="row width100margin0">
				<div class="col-md-8">
					<h1>商品一覧</h1>
					<div id="category">
						<form action="itemlist" method="post">
							<input type="hidden" name="category" value="All"/>
							<button type="submit" name="" class="cate_btn">All</button>
						</form>
						<form action="itemlist" method="post">
							<input type="hidden" name="category" value="Vegetable" />
							<button type="submit" name="" class="cate_btn">Vegetalian</button>
						</form>
						<form action="itemlist" method="post">
							<input type="hidden" name="category" value="Fruit" />
							<button type="submit" name="" class="cate_btn">Fruit</button>
						</form>
						<form action="itemlist" method="post">
							<input type="hidden" name="category" value="Rice" />
							<button type="submit" name="" class="cate_btn">Rice</button>
						</form>
						<form action="itemlist" method="post">
							<input type="hidden" name="category" value="Soy" />
							<button type="submit" name="" class="cate_btn">Soy</button>
						</form>
					</div>
					<table>
							<thead>
								<tr>
								<th>商品ID</th>
								<th>商品名</th>
								<th>価格</th>
								<th>在庫数</th>
								<th></th>
								</tr>
							</thead>
							<tbody>
								<% for ( ItemBean bean : beanList) { %>
									<form action="iteminfo" method="post">

										<tr>
											<td><%=bean.getItemId() %></td><input type="hidden" name="itemId" value="<%=bean.getItemId() %>" />
											<td><%=bean.getItemName() %></td>
											<td><%=bean.getItemPrice() %></td>
											<td><%=bean.getItemQuantity() %></td>
											<td><button type="submit">詳細ページ</button></td>
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