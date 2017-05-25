<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String vegetalianOrProducer = (String)session.getAttribute("vegetalianOrProducer");
%>
<%
	if(vegetalianOrProducer == null || vegetalianOrProducer.equals("vegetalian")){
%>
		<jsp:include page="vegetalianHeader.jsp"/>
<%
	}else if(vegetalianOrProducer.equals("producer")){
%>
		<jsp:include page="producerHeader.jsp"/>
<%
	}
%>