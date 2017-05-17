<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.LoginUserBean" %>
<div id="headger">
	<p>
		ようこそ<%=session.getAttribute("userName") %>さん
		<a href="login?choice=history">購入履歴</a>
		<a href="login?choice=logout">ログアウト</a>
	</p>
</div>