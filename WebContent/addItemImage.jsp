<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String itemId = (String)request.getAttribute("itemId");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>VegeSel - 商品説明文の追加</title>
	<%@ include file="head.html" %>
	<link rel="stylesheet" type="text/css" href="header.css">
	<link rel="stylesheet" type="text/css" href="login.css">
	<link rel="stylesheet" type="text/css" href="footer.css">
	<link rel="stylesheet" type="text/css" href="shopping.css">
	<link rel="stylesheet" type="text/css" href="recordItem.css">
	</head>
	<body>
		<%@include file="producerHeader.jsp"%>
		<div class="container maincontent">
			<div class="row width100margin0">
				<div class="col-md-8">
					<h3 class="h3">商品イメージの追加</h3>
					<p>商品の登録が完了しました。引き続き商品イメージを追加ください。</p>
					<section id="record">
								<div class="record-content">
									<h3 class="h3">Record Item</h3>
									<p>Please enter the information.</p>
								</div>
								<div class="record-section">
								<div class="container formlist">
									<form class="center-block" method="post" action="additemimage" enctype="multipart/form-data">
										<div class="col-md-6 form-line">
											<div class="form-group">
										    	<label for="image">Image</label>
										    	<p><label id="image" for="file_photo" class="btn btn-default" >画像を追加<input type="file" accept="image/*" id="file_photo" style="display:none;" name="image"></label></p>
										    	<input type="hidden" name="itemId" value="<%=itemId %>">
										  	</div>
								  		</div>
								  			<div>
								  				<button type="submit" class="btn btn-default submit"><i class="fa fa-paper-plane" aria-hidden="true"></i>  Submit</button>
								  			</div>
									</form>
								</div>
							</section>
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