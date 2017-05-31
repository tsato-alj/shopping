<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)request.getAttribute("userId");
	String pass = (String)request.getAttribute("pass");
	String name = (String)request.getAttribute("name");
	String email = (String)request.getAttribute("email");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>VegeSel - 新規アカウント作成(入力内容確認)</title>
		<%@ include file="head.html" %>
		<link rel="stylesheet" type="text/css" href="header.css">
		<link rel="stylesheet" type="text/css" href="login.css">
		<link rel="stylesheet" type="text/css" href="footer.css">
		<link rel="stylesheet" type="text/css" href="shopping.css">
		<link rel="stylesheet" type="text/css" href="recordItem.css">
	</head>
	<body>
		<div class="maincontent">
			<%@include file="header.jsp"%>
				<div class="row">
					<div class="col-md-8">
						<div class="center-block">
							<h3 class="h3">商品登録内容の確認</h3>
							<p>以下の内容でよろしいでしょうか?</p>
							<form action="resultcreateanaccount">
								<p>アカウントID:<%=userId %><input type="hidden" name="userId" value="<%=userId %>"/></p>
								<p>pass:<%if(pass != null && !pass.equals("")){%>
											<%
												for(int i = 0; i < pass.length(); i++){
											%>
													*
											<%
												}
											%>
											(情報保護のため非表示)
										<%}else{%>
											未設定
										<%}%>
								</p>
								<input type="hidden" name="pass" value="<%=pass %>"/></p>
								<p>お名前:<%=name%><input type="hidden" name="name" value="<%=name %>"/></p>
								<p>E-mail:<%if(email != null && !email.equals("")){%>
											<%=email %>
										<%}else{%>
											未設定
										<%}%>
								<input type="hidden" name="email" value="<%=email %>"/></p>
								<p><button type="submit" class="btn btn-default submit"><i class="fa fa-paper-plane" aria-hidden="true"></i>  Submit</button></p>
							</form>
						</div>
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