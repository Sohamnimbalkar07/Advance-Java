<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Login Form</title>
  </head>
  <body>
  <h5> ${requestScope.message}</h5>
    <form method="post">
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
