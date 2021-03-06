<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="textｓ/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.GoalBean"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.temporal.ChronoUnit"%>
<%
    String messageAboutGoal = (String)session.getAttribute("messageAboutGoal");
%>
	<div id="logbox">
		<% if(session.getAttribute("userId") != null) { %>
			<h1 class="text-center">ようこそ、<%=session.getAttribute("userName")%>さん</h1>
				<div class="list-group">
					<p class="list-group-item textcenter">
						<%=messageAboutGoal %>
					</p>
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
			    	<a href="login?choice=createAnAccount">create an account</a> - <a href="#" id="">forgot password</a>
			    </div>
		<%} %>
	</div>