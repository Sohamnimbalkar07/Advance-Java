<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"  %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5> validated User Details : ${sessionScope.user_details}</h5>
<spring:url var="url" value="/customer/tutorials" />
<%-- <h5>Topic List :  ${requestScope.topic_list} </h5> --%>
<form:form action="${url}" method="get" modelAttribute="myTopic">
<table style="background-color:lightgrey; margin : auto">
<form:radiobuttons path="id" items="${requestScope.topic_list}" itemLabel="topicName" itemValue="id"  /> 
<tr>
<td> <input type="submit" value="Choose Topic"/></td>
</tr>
</table>
</form:form>
</body>
</html>     




<%-- <c:forEach var="topic" items="${requestScope.topic_list}"> --%>
<tr>
<td> <input type="radio" name="Id" value="${topic.id}"  /> </td>
<td> ${topic.topicName}</td>
</tr>
<%-- </c:forEach> --%>                                                                                                                                                