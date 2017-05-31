<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>VegeSel - 新規アカウント作成</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css">
		<link rel="stylesheet" type="text/css" href="login.css">
		<link rel="stylesheet" type="text/css" href="footer.css">
		<link rel="stylesheet" type="text/css" href="shopping.css">
		<link rel="stylesheet" type="text/css" href="recordItem.css">
	</head>
	<body>
		<div class="maincontent">
			<div class="col-md-8">
				<%@include file="header.jsp"%>
				<section id="record">
								<div class="record-content">
									<h3 class="h3">新規アカウント作成</h3>
									<p>次の情報を入力して下さい。</p>
								</div>
								<div class="record-section">
								<div class="container formlist">
									<form class="center-block" method="post" action="createanaccount">
										<div class="row">
											<div class="col-md-6 form-line">
												<div class="form-group" >

											    	<label for="userId">アカウントID</label>
											    	<p><input type="text"  class="form-control" name="userId" id="userId" value="" required/></p>
											  	</div>
												<div class="form-group" >

											    	<label for="pass">パスワード</label>
											    	<p><input type="text"  class="form-control" name="pass" id="pass" value=""/></p>
											  	</div>
											  	<div class="form-group">
											    	<label for="name">お名前</label>
											    	<p><input type="text" class="form-control" id="name" name="name" value=""></p>
									  			</div>
											  	<div class="form-group">
											    	<label for="email">E-mail</label>
											    	<p><input type="email" class="form-control" id="email" name="email"></p>
									  			</div>
									  			<div>
									  				<button type="submit" class="btn btn-default submit"><i class="fa fa-paper-plane" aria-hidden="true"></i>  Submit</button>
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
		<%@include file="footer.html" %>
		<%@include file="script.html" %>
	</body>
</html>