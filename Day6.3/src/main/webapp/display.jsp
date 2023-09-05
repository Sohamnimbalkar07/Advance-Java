<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Testing Scriplets</h4>
<%
String email=request.getParameter("em");
String pwd = request.getParameter("pass");
//send same to clnt
out.print("<h5> Email" + email+ "</h5>");
out.print("<h5> Password" +pwd+ "</h5>");
%>
<h4>Testing JSP Expression</h4>
<h5> Email : <%= request.getParameter("em") %></h5>
<h5> Password : <%= request.getParameter("pass") %></h5>
<h4> testing EL Syntax</h4>
${param}
<h5> Email : ${param.em}</h5>
<h5> password : ${param.pass}</h5>
</body>
</html>