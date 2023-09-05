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
<h3> Welcome to jsp!, server TimeStamp : <%=LocalDateTime.now() %></h3>
<h5> <a href="comments.jsp"> JSP Comments</a></h5>
<h5> <a href="login.jsp">Testing Scriptlets and expressions</a></h5>

</body>
</html>