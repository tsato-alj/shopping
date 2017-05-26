<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.ItemBean" %>
<%@ page import="bean.LoginUserBean" %>
<%
	ArrayList<ItemBean> cart = (ArrayList<ItemBean>)session.getAttribute("cart");
	ArrayList<LoginUserBean> producers = (ArrayList<LoginUserBean>)session.getAttribute("producers");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>カート</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css"/>
		<link rel="stylesheet" type="text/css" href="login.css"/>
		<link rel="stylesheet" type="text/css" href="footer.css"/>
		<link rel="stylesheet" type="text/css" href="shopping.css"/>
		<link rel="stylesheet" type="text/css" href="needLogin.css"/>
	</head>
	<body>
		<%@include file="producerHeader.jsp"%>
		<div class="maincontent">
			<div class="container">
		   		<div class="row">
		   			<div class="col-md-8">
			            <table class="table table-hover">
			                <thead>
			                    <tr>
			                        <th>商品</th>
			                        <th>個数</th>
			                        <th class="text-center">価格</th>
			                        <th class="text-center">合計</th>
			                        <th> </th>
			                    </tr>
			                </thead>
			                <tbody>
			                <%
			                	int allItemPrice = 0;
			                	for(int i = 0; i < cart.size(); i++){
			                		ItemBean item = cart.get(i);
			                		LoginUserBean producer = producers.get(i);
			                		int orderId = item.getOrderId();
			                		String itemId = item.getItemId();
			                		String itemName = item.getItemName();
			                		String producerName = producer.getName();
			                		int quantity = item.getItemQuantity();
			                		int price = item.getItemPrice();
			                		int itemTotalPrice = price * quantity;
			                		String image = item.getImage();
			                		allItemPrice += itemTotalPrice;
			                %>
				                    <tr>
				                        <td class="col-sm-8 col-md-6">
				                        <div class="media">
				                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="<%=image %>" style="width: 72px; height: 72px;"> </a>
				                            <div class="media-body">
				                                <h4 class="media-heading"><a href="#"><%=itemName %></a></h4>
				                                <h5 class="media-heading"> by <a href="#"><%=producerName %></a></h5>
				                            </div>
				                        </div></td>
				                        <td class="col-sm-1 col-md-1" style="text-align: center">
				                        <%=quantity %>
				                        <input type="hidden" name"<%=itemId%>list" value="<%=quantity%>">
				                        </td>
				                        <td class="col-sm-1 col-md-1 text-center"><strong><%=price %></strong></td>
				                        <td class="col-sm-1 col-md-1 text-center"><strong><%=itemTotalPrice %></strong></td>
				                        <td class="col-sm-1 col-md-1">
				                        <button type="submit" name="delete" value="<%=orderId %>" class="btn btn-danger" action="shopping?mode=deleteItemInCart">
				                            <span class="glyphicon glyphicon-remove"></span> Remove
				                        </button></td>
				                    </tr>
			                <%
			                	}
			                %>
			                    <tr>
			                        <td>   </td>
			                        <td>   </td>
			                        <td>   </td>
			                        <td><h3>Total</h3></td>
			                        <td class="text-right"><h3><strong><%=allItemPrice %></strong></h3></td>
			                    </tr>
			                    <tr>
			                        <td>   </td>
			                        <td>   </td>
			                        <td>   </td>
			                        <td>
			                        <button type="button" class="btn btn-default">
			                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
			                        </button></td>
			                        <td>
			                        <form action="result" method="post">
				                        <button type="submit" class="btn btn-success">
				                            Checkout <span class="glyphicon glyphicon-play"></span>
				                        </button>
			                        </form>
			                        </td>
			                    </tr>
			                </tbody>
			            </table>
			        </div>
			        <div class="col-md-4">
						<jsp:include page="login.jsp" />
					</div>
			    </div>
			</div>
		</div>
		<%@include file="footer.html" %>
	</body>
</html>