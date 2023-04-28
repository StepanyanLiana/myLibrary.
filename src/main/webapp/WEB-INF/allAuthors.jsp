<%@ page import="com.example.myLibrary.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.myLibrary.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all authors</title>
</head>
<% List<Author> authors = (List<Author>) request.getAttribute("authors");%>
<body>
<a href="/"> Back </a>
<table border="1">
  <tr>
    <th>id</th>
    <th>name</th>
    <th>surname</th>
    <th>email</th>
    <th>age</th>
    <th>action</th>

  </tr>
  <% if(authors != null && !authors.isEmpty()) {%>
  <% for (Author author : authors) { %>
  <tr>
    <td><%=author.getId()%></td>
    <td><%=author.getName()%></td>
    <td><%=author.getSurname()%></td>
    <td><%=author.getEmail()%></td>
    <td><%=author.getAge()%></td>
    <td><a href="/removeAuthor?id=<%=author.getId()%>">Delete</a>
      / <a href="updateAuthor?id=<%=author.getId()%>">Update</a> </td>
    <%}%>
  </tr>
  <%}%>
</table>
</body>
</html>
