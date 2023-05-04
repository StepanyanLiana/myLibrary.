<%@ page import="com.example.myLibrary.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.myLibrary.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 15:51
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
    <title>Create books</title>
</head>
<%List<Author> authorList = (List<Author>) request.getAttribute("authors");
List<User> userList = (List<User>) request.getAttribute("users");
%>
<body>
<a href="/allBooks"> Back </a>

<h2>Create books</h2>
<form action="/createBooks" method="post" enctype="multipart/form-data">
  title: <input type="text" name="title"><br>
  description: <input type="text" name="description"><br>
  price: <input type="text" name="price"><br>
  author:
  <select name="author_id">
    <% for (Author author: authorList) { %>
    <option value="<%=author.getId()%>"><%=author.getName()%> <%=author.getSurname()%></option>
    <% }%>
  </select><br>
  user:
  <select name="user_id">
    <%
      for (User user : userList) {%>
    <option value="<%=user.getId()%>"><%=user.getName()%><%=user.getSurname()%>
  </option>
    <%}%>
  </select><br>
  image:
  <input type="file" name="profilePic"> <br>
  <input type="submit" value="create">
</form>
</body>
</html>
