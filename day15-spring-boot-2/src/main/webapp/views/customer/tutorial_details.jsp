<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="background-color: lightgrey; margin: auto">
<caption> ${requestScope.selected_tut.tutorialName}</caption>
        <tr>
        <td>Author</td>
        <td>${requestScope.selected_tut.author}</td>
        </tr>
        <tr>
        <td>published on</td>
        <td>${requestScope.selected_tut.publishDate}</td>
        </tr>
        <tr>
        <td>Visits</td>
        <td>${requestScope.selected_tut.visits}</td>
        </tr>
 </table>  
 <h4><a href="<spring:url value='/user/logout'/>">Log Out</a></h4>
</body>
</html>