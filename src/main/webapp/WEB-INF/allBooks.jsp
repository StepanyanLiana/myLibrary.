<%@ page import="com.example.myLibrary.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.myLibrary.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all books</title>
</head>
<% List<Author> authors = (List<Author>) request.getAttribute("authors");%>
<% List<Book> books = (List<Book>) request.getAttribute("book");%>
<body>
<a href="/"> Back </a>
<h1>Books</h1>
<form action="/searchBooks" method="post">
   search book <input type="text">
    <a href="/searchBooks"></a>
    <input type="submit"value="search">
</form>
<table border="1">
    <tr>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>price</th>
        <th>author</th>
        <th>action</th>
    </tr>
    <% if(books != null && !books.isEmpty()) {%>
    <% for (Book book : books) { %>
    <tr>
        <td><%=book.getId()%></td>
        <td><%=book.getTitle()%></td>
        <td><%=book.getDescription()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getAuthor().getName()%></td>
        <td><a href="/removeBook?id=<%=book.getId()%>">Delete</a>
            / <a href="updateBoo?id=<%=book.getId()%>">Update</a> </td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>
