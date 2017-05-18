<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
	<div id="logbox">
		<% if(session.getAttribute("userId") != null) { %>
			<h1 class="text-center">ようこそ、<%=session.getAttribute("userName")%>さん</h1>
				<div class="list-group">
					<a href="login?choice=history" class="list-group-item textcenter">購入履歴</a>
					<a href="login?choice=logout" class="list-group-item textcenter">ログアウト</a>

				</div>
		<% }else{%>
				<form id="signup" method="post" action="login">
					<h1>account login</h1>
					<input name="id" type="text" placeholder="ID" class="input pass"/>
					<input name="pass" type="password" placeholder="Password" required="required" class="input pass"/>
					<button type="submit" name="choice" value="login" class="inputButton">Login</button>
				</form>
				<div class="text-center">
			    	<a href="#" id="">create an account</a> - <a href="#" id="">forgot password</a>
			    </div>
		<%} %>
	</div>