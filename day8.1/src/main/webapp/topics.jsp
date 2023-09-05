<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- WC : session.getAttribute("user").getValidatedUserDetails().getName() --%>

<h5> Hello, ${sessionScope.user.validatedUserDetails.name} </h5>

</body>
</html>