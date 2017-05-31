<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ItemBean"%>
<%@ page import="bean.LoginUserBean"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.ReviewBean"%>
<%
 	ItemBean item = (ItemBean)request.getAttribute("item");
	String itemId = item.getItemId();
	String itemName = item.getItemName();
	int itemPrice = item.getItemPrice();
	String itemDescription = item.getDescription();
	String itemImage = item.getImage();
	String category = item.getCategory();
	int quantity = item.getItemQuantity();

	LoginUserBean producer = (LoginUserBean)request.getAttribute("producer");
	String producerId = producer.getId();
	String producerName = producer.getName();
	String address = producer.getAddress();
	String producerImage = producer.getImage();
	String userIntroduction = producer.getUserIntroduction();

	ArrayList<ReviewBean> reviews = null;
	if(request.getAttribute("review") != null){
		reviews = (ArrayList<ReviewBean>)request.getAttribute("review");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>VegeSel - <%=itemName %></title>
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
					<h3 class="h3">商品詳細</h3>
					<div class="row">
						<div class="col-md-4">
							<img src="<%=itemImage%>"/>
						</div>
						<div class="col-md-8">
							<p><%=itemName %></p>
							<p>&yen<%=itemPrice %></p>
							<p>category:<%=category %></p>
						</div>
					</div>
					<h4 class="h4">商品説明</h4>
					<p><%=itemDescription %></p>
					<h3 class="h3">生産者について</h3>
					<div class="container">
						<div class="row">
							<div class="col-md-4">
								<img src="<%=producerImage%>"/>
							</div>
							<div class="col-md-8">
								<p><%=producerName %></p>
								<p><%=address %></p>
							</div>
						</div>
					</div>
					<h4 class="h4">生産者紹介</h4>
					<p><%=userIntroduction %></p>
					<hr/>
					<p><%=itemDescription %></p>
					<form action="addtocart">
						<input type="hidden" name="itemId" value=<%= itemId %>></input>
						<input type="hidden" name="mode" value="/addtocart?itemId=<%= itemId %>"></input>
						<select name="quantity">
						<% for(int i = 0; i <= quantity; i++ ) {%>
							<option value=<%=i%>><%=i%></option>
						<% }%>
						</select>
						<input type="submit" value="カートに入れる"></input>
					</form>
					</div>
					<div id="review">

					<form action="review" method="post">
				 		<p>ニックネーム: <input type="text"  name="nickname" value="" required /></p>
						<p>評価: <select name="evaluation" required>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
								 </select></p>
						<p>タイトル:<input type="text" name="title" value="" required /></p>
						<p>内容:<br /><textarea name="contenttext" rows="10" cols="30" maxlength="200" required ></textarea></p>

						<input type="hidden" name="itemId" value=<%= itemId %> />
					 	<p><button type="submit">レビューする</button>
					 	<button type="reset" name="" value="">リセット</button></p>
					</form>
					<table>
						<thead>
							<th>タイトル</th>
							<th>ニックネーム</th>
							<th>コメント</th>
							<th>評価</th>
							<th>投稿日時</th>
						</thead>
						<tbody>
						<%
							if(reviews != null){
								for(ReviewBean review: reviews){
						%>
									<td><%=review.getTitle() %></td>
									<td><%=review.getNickname() %></td>
									<td><%=review.getComent() %></td>
									<td><%=review.getEvaluation() %></td>
									<td><%=review.getContribution_time() %></td>
						<%
								}
							}
						%>
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