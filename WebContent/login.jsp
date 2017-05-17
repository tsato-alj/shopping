<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>ショッピングサイトへようこそ!</title>
		<style>
			<%@include file="shopping.css" %>
		</style>
	</head>
	<body>
		<div id="main">
			<h1>ログイン画面へようこそ!</h1>
			<p>ログインIDとパスワードを入力して下さい</p>
			<form action="login" method="get">
				<p>userID<input type="text" name="id" value=""/></p>
				<p>パスワード<input type="password" name="pass" value=""/></p>
				<p><button type="submit" name="choice" value="login">ログイン</button>
				<% if(session.getAttribute("userId") != null) { %>
					<button type="submit" name="choice" value="logout">ログアウト</button>
				<% }%>
			</form>
		</div>
	</body>
</html>