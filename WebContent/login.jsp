<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="textｓ/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.GoalBean"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.temporal.ChronoUnit"%>
<%
    String messageAboutGoal = null;
    if(session.getAttribute("goals") != null){
        ArrayList<GoalBean> goals = (ArrayList<GoalBean>)session.getAttribute("goal");
        if(goals != null){
            GoalBean newestGoal = null;
            for(GoalBean goal: goals){
                newestGoal = goal;
            }
            LocalDate EndDate = null;
            if(newestGoal != null){
                EndDate = newestGoal.getEndDate();
            }
            if(EndDate != null){
                messageAboutGoal = "現在新しい目標は設定されていません";
            }else{
                LocalDate goalDate = newestGoal.getGoalDate();
                LocalDate today = LocalDate.now();
                Long dayDiff = ChronoUnit.DAYS.between(today, goalDate);
                if(dayDiff > 0){
                    messageAboutGoal = "目標達成予定日まで後<strong>" + dayDiff + "</storong>日";
                }else if(dayDiff == 0){
                    messageAboutGoal = "目標達成予定日は<strong>本日</strong>";
                }
            }
        }else {
            messageAboutGoal = "目標があるお買い物をはじめましょう";
        }
    }else {
        messageAboutGoal = "目標があるお買い物をはじめましょう";
    }
%>
	<div id="logbox">
		<% if(session.getAttribute("userId") != null) { %>
			<h1 class="text-center">ようこそ、<%=session.getAttribute("userName")%>さん</h1>
				<div class="list-group">
					<p class="list-group-item textcenter">
						<%=messageAboutGoal %>
						<a href="viewgoal"></a>
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