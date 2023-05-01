<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<%
  if(session.getAttribute("user") != null){
    response.sendRedirect("/home");
  }
%>
Register:
<form action="/register" method="post">
  name: <input name="name" type="text"><br/>
 surname: <input name="surname" type="text"><br/>
 email: <input name="email" type="text"><br/>
password:  <input name="password" type="password"><br/>
    <select name="type">
        <option value="ADMIN">ADMIN</option>
        <option value="USER">USER</option>
    </select><br/>
  <input type="submit" value="register">
</form>
<a href="/">Back</a>
</body>
</html>
