<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5> From the included page </h5>
<%-- try to access page scoped attribute using EL --%>
<h5> Value : ${pageScope.server_ts}</h5>
</body>
</html>