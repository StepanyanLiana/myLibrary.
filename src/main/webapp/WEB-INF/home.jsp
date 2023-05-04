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
    <style>
        body{
            background-image: url("../img/dd1303447f451537f2853177b2e4cc3b-700.jpg");
            background-position: center;
            background-size: 100% 100%;
        }
    </style>
    <title>Home Page</title>

</head>
<body>
<% User user = (User) session.getAttribute("user"); %>
<h1>Welcome Library</h1>
<%=user.getName()%> <%=user.getSurname()%> <br>
<h1><a href="/logout">logout</a></h1> <br>
<h1><a href="/allAuthors"> See all authors</a></h1> <br>
<h1><a href="/allBooks">see all books</a></h1><br>
<h1><a href="/createBooks"> Create books</a></h1><br>
<h1><a href="/createAuthors"> Create authors</a></h1>
</body>
</html>
