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
    <title>update author</title>
</head>
<body>
<%Author author = (Author) request.getAttribute("author");%>
<a href="/allAuthors"> Back </a>
<h2>Update Author</h2>
<form action="/updateAuthor" method="post">
  <input name="id" type="hidden" value="<%=author.getId()%>">
  name: <input type="text" name="name" value="<%=author.getName()%>"><br>
  surname: <input type="text" name="surname" value="<%=author.getSurname()%>"> <br>
  email: <input type="email" name="email" value="<%=author.getEmail()%>"> <br>
  age: <input type="text" name="age" value="<%=author.getAge()%>"> <br>
  <input type="submit" value="update">
</form>
</body>
</html>
