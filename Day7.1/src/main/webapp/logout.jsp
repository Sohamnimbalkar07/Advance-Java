<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5> Hello, ${sessionScope.user_details.userName}</h5>
<%
session.invalidate();
%>
<h5>
<a href="login.jsp"> visit again</a>
</h5>
</body>
</html>