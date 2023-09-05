<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Login Form</title>
  </head>
  <%-- create jB instance w/o java code : jsp:useBean --%>
<%-- After checking : in case of null --session.setAttribute("user",new UseBean()) --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<%-- create instance of TopicTutBean n save it under session scope --%>
<jsp:useBean id="topic_tut" class="beans.TopicTutorialBean" scope="session"/>
  <body>
  <h5> ${sessionScope.user.message}</h5>
    <form action="validate.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Enter User Email</td>
          <td><input type="text" name="email" /></td>
        </tr>
        <tr>
          <td>Enter Password</td>
          <td><input type="password" name="password" /></td>
        </tr>

        <tr>
          <td><input type="submit" value="Login" /></td>
        </tr>
      </table>
    </form>
  </body>
</html>
