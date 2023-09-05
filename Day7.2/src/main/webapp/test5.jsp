<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H5> from the next page</H5>
<%-- send product details to client --%>
<h5> Product Details : ${requestScope.product_details} </h5>
<h5> param : ${param}</h5>
</body>
</html>