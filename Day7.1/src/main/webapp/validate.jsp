<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
// JSP declaration block
HashMap<String,User> users;
public void jspInit()
{
	System.out.println("in jsp init");
	//create entry map
	users= new HashMap<>();
	//populate the same
	users.put("Rama",new User("Rama","1234",25));
	users.put("Raj",new User("Raj","3234",28));
}
//jspDestroy can be overridden from same jsp decl block or can create anothe one
%>

<body>
<%
//read name n pwd
String name = request.getParameter("name");
String pwd = request.getParameter("pass");
//validation
User validatedUser = users.get(name);
if(validatedUser != null)
{
	if(validatedUser.getPassword().equals(pwd))
	{
		//valid login: store user details under session scope
		session.setAttribute("user_details",validatedUser);
		//clnt pull 2 
		response.sendRedirect("details.jsp");
	}
	else
	{
		%>
		<h5>invalid password, do you want to register <a href="login.jsp"> Register</a></h5>
		
		<% }
	
}
else
{
%>
<h5>USer does not exist, do you want to register <a href="register.jsp"> Register</a></h5>

<%
}
%>
</body>
<%!
public void jspDestroy()
{
	System.out.println("in jsp Destroy");
}
%>
</html>