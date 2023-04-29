<%@ page import="java.util.List" %>
<%@ page import="com.example.myLibrary.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search book</title>
</head>
<body>
<h1>Search books</h1>
<% List<Book> books = (List<Book>) request.getAttribute("searchBook");
%>
<a href="/allBooks" >Back</a>
<table border="1">
  <tr>
    <th>id</th>
    <th>title</th>
    <th>description</th>
    <th>price</th>
    <th>author_id</th>
  </tr>
  <% for (Book book : books) { %>
  <tr>
    <td><%= book.getId() %></td>
    <td><%= book.getTitle() %></td>
    <td><%= book.getDescription() %></td>
    <td><%= book.getPrice() %></td>
    <td><%= book.getAuthor().getId() %></td>
  </tr>
  <% } %>
  </tr>
</table>
</body>
</html>
