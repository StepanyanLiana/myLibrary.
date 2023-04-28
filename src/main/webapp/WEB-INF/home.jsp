<%@ page import="com.example.myLibrary.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<% User user = (User) session.getAttribute("user"); %>
<h1>Welcome Library</h1>
<%=user.getName()%> <%=user.getSurname()%> <a href="/logout">logout</a> <br>
<a href="/allAuthors"> See all authors</a> <br>|
<a href="/allBooks">see all books</a><br>
<a href="/createBooks"> Create books</a><br>
<a href="/createAuthors"> Create authors</a>
</body>
</html>
