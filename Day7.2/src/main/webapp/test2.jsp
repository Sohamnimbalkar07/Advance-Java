<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5> from test2.jsp....</h5>
<%-- create page scope attribute to store timestamp --%>
<% 
pageContext.setAttribute("server_ts",LocalDateTime.now());
%>
<%-- use include directive --%>
<%@ include file="test3.jsp" %>
</body>
</html>