<%@ page import="com.example.myLibrary.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.myLibrary.model.User" %>
<%@ page import="com.example.myLibrary.model.UserType" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 15:17
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
    <title>all authors</title>
</head>
<% List<Author> authors = (List<Author>) request.getAttribute("authors");
User user = (User) session.getAttribute("user");%>
<body>
<a href="/"> Back </a>
<h2>Authors</h2>
<form action="/allAuthors" method="get">
  <input type="text" name="keyword">
  <input type="submit" value="search">
</form>
<table border="1">
  <tr>
    <th>image</th>
    <th>id</th>
    <th>name</th>
    <th>surname</th>
    <th>email</th>
    <th>age</th>
    <%if (user.getUserType() == UserType.ADMIN) { %>
    <th>action</th>
<%}%>
  </tr>
  <% if(authors != null && !authors.isEmpty()) {%>
  <% for (Author author : authors) { %>
  <tr>
    <td>
      <% if (author.getImage() == null || author.getImage().equalsIgnoreCase("null")){ %>
      <img src="/img/default_pic.webp" width="100">
      <%}else {%>
      <a href="/getImage?picName=<%=author.getImage()%>"><img
            src="/getImage?picName=<%=author.getImage()%>" width="100"></a></td>
    <%}%>
    <td><%=author.getId()%></td>
    <td><%=author.getName()%></td>
    <td><%=author.getSurname()%></td>
    <td><%=author.getEmail()%></td>
    <td><%=author.getAge()%></td>
  <%if (user.getUserType() == UserType.ADMIN) {%>
    <td><a href="/removeAuthor?id=<%=author.getId()%>">Delete</a>
      / <a href="updateAuthor?id=<%=author.getId()%>">Update</a> </td>
    <%}%>
  </tr>
  <%}%>
  <%}%>
</table>
</body>
</html>
