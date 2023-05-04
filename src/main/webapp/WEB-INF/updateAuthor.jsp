<%@ page import="com.example.myLibrary.model.Author" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 18:43
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
    <title>update author</title>
</head>
<body>
<%Author author = (Author) request.getAttribute("author");%>
<a href="/allAuthors"> Back </a>
<h2>Update Author</h2>
<form action="/updateAuthor" method="post" enctype="multipart/form-data">
  <input name="id" type="hidden" value="<%=author.getId()%>">
  name: <input type="text" name="name" value="<%=author.getName()%>"><br>
  surname: <input type="text" name="surname" value="<%=author.getSurname()%>"> <br>
  email: <input type="email" name="email" value="<%=author.getEmail()%>"> <br>
  age: <input type="text" name="age" value="<%=author.getAge()%>"> <br>
  image: <input type="file" name="profilePic" value="<%=author.getImage()%>"> <br>
  <input type="submit" value="update">
</form>
</body>
</html>
