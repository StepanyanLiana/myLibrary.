<%@ page import="com.example.myLibrary.model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create books</title>
</head>
<%List<Author> authorList = (List<Author>) request.getAttribute("authors"); %>
<body>
<a href="/allBooks"> Back </a>

<h2>Create books</h2>
<form action="/createBooks" method="post">
  title: <input type="text" name="title"><br>
  description: <input type="text" name="description"><br>
  price: <input type="text" name="price"><br>
  author:
  <select name="author_id">
    <% for (Author author: authorList) { %>
    <option value="<%=author.getId()%>"><%=author.getName()%> <%=author.getSurname()%></option>
    <% }%>
  </select>
  <input type="submit" value="create">
</form>
</body>
</html>
