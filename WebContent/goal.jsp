<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer historyId = (Integer)request.getAttribute("historyId");
%>
<!doctype html>
<html lang="ja">
<head>
  <meta charset="utf-8" />
  <title>目標設定</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
  <link rel="stylesheet" href="/demos/style.css" />
  <script>
  $(function() {
    $.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
    $( ".datepicker" ).datepicker();
  });
  </script>
  <%@ include file="head.html" %>
  <link rel="stylesheet" type="text/css" href="header.css"/>
  <link rel="stylesheet" type="text/css" href="login.css"/>
  <link rel="stylesheet" type="text/css" href="footer.css"/>
  <link rel="stylesheet" type="text/css" href="shopping.css"/>
  <link rel="stylesheet" type="text/css" href="needLogin.css"/>
</head>



<body>
	<%@include file="header.jsp"%>
	<div class="maincontent">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<form action="recordgoal" method="post">
						<input type="hidden" name="historyId" value="<%=historyId%>"/>
						<p>目標: <textarea name="goal" rows="2" cols="30" maxlength="50" ></textarea></p>
				 		<p>開始日: <input type="date" class="datepicker" name="startDate"  required /></p>
				 		<p>達成予定日: <input type="date" class="datepicker" name="goalDate" required /></p>
				 		<p><button type="submit" name="" value="">目標を設定する</button></p>
				 		<p><button type="reset" name="" value="">リセット</button></p>
					</form>
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