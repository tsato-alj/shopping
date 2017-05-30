<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.GoalBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>目標一覧</title>
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
						<h3 class="h3"><%=session.getAttribute("userName")%>さんの目標一覧</h3>
						<%
							ArrayList<GoalBean> goals = (ArrayList<GoalBean>)request.getAttribute("goals");
							if(goals != null){
						%>

								 <table class="table table-hover">
					                <thead>
					                    <tr>
					                        <th>購入番号</th>
					                        <th>目標内容</th>
					                        <th>開始日</th>
					                        <th>達成予定日</th>
					                        <th>終了日</th>
					                        <th></th>
					                    </tr>
					                </thead>
					                <tbody>
						                <%
							                int goalsMaxIndex = (Integer)request.getAttribute("goalsMaxIndex");
							                for(int i = goalsMaxIndex; i >= 0; i--){
							                	GoalBean goal = goals.get(i);
						                %>
												<tr>
													<td><%=goal.getHistoryId() %></td>
													<td><%=goal.getGoal() %></td>
													<td><%=goal.getStart() %></td>
													<td><%=goal.getGoalDate() %></td>
													<td>
														<%if(goal.getEndDate() != null){ %>
															<%=goal.getEndDate() %>
														<%
															}else{
														%>
																未達成
														<%
															}
														%>
													</td>
													<td>
														<%
															if(i == goalsMaxIndex && goal.getEndDate() == null){
														%>
																<form action="achievegoal"><button type="submit" name="orderId" value="<%=goal.getOrderId()%>">目標達成</button></form>
														<%
															}
														%>
													</td>
												</tr>

						                <%
						                	}
						                %>
						                </tbody>
						            </table>
					<%
						}else{
					%>
							<p>現在、目標の記録はありません。目標あるお買い物をはじめてみませんか?</p>
					<%
						}
					%>
					</div>
					 <div class="col-md-4">
						<jsp:include page="login.jsp" />
					</div>
				</div>
			</div>
		</div>
		<%@include file="footer.html" %>
		<%@include file="script.html" %>
	</body>
</html>