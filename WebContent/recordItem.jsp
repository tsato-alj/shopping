<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>ProudVege - 商品登録</title>
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
					<section id="contact">
								<div class="section-content">
									<h3 class="h3">商品登録</h3>
									<p>以下の情報を入力して下さい。</p>
								</div>
								<div class="contact-section">
								<div class="container fomrlist">
									<form>
										<div class="col-md-6 form-line">
								  			<div class="form-group">
								  				<label for="exampleInputUsername">Your name</label>
										    	<input type="text" class="form-control" id="" placeholder=" Enter Name">
									  		</div>
									  		<div class="form-group">
										    	<label for="exampleInputEmail">Email Address</label>
										    	<input type="email" class="form-control" id="exampleInputEmail" placeholder=" Enter Email id">
										  	</div>
										  	<div class="form-group">
										    	<label for="telephone">Mobile No.</label>
										    	<input type="tel" class="form-control" id="telephone" placeholder=" Enter 10-digit mobile no.">
								  			</div>
								  		</div>
								  		<div class="col-md-6">
								  			<div class="form-group">
								  				<label for ="description"> Message</label>
								  			 	<textarea  class="form-control" id="description" placeholder="Enter Your Message"></textarea>
								  			</div>
								  			<div>

								  				<button type="button" class="btn btn-default submit"><i class="fa fa-paper-plane" aria-hidden="true"></i>  Send Message</button>
								  			</div>

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
</html>