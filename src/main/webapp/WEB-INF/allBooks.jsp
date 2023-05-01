<%@ page import="com.example.myLibrary.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.myLibrary.model.Book" %>
<%@ page import="com.example.myLibrary.model.User" %>
<%@ page import="com.example.myLibrary.model.UserType" %><%--
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
<% List<Book> books = (List<Book>) request.getAttribute("books");
    User user = (User) session.getAttribute("user");
String keyword = request.getParameter("keyword") == null ||
        request.getParameter("keyword").equals("null")
    ? "" : request.getParameter("keyword");
%>
<body>
<a href="/"> Back </a>
<h1>Books</h1>
<form action="/allBooks" method="get">
   search book <input type="text" name="keyword" value="<%=keyword%>">
    <input type="submit"value="search">
</form>
<table border="1">
    <tr>
        <th>image</th>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>price</th>
        <th>author name</th>
        <%if (user.getUserType() == UserType.ADMIN) {%>
        <th>action</th>
        <%}%>
    </tr>
    <% if(books != null && !books.isEmpty()) {%>
    <% for (Book book : books) { %>
    <tr>
        <td>
        <% if (book.getPicName() == null || book.getPicName().equalsIgnoreCase("null")){ %>
        <img src="/img/default_pic.webp" width="100">
        <%}else {%>
        <a href="/getImageBook?picName=<%=book.getPicName()%>"><img
                src="/getImageBook?picName=<%=book.getPicName()%>" width="100"></a></td>
        </td>
        <%}%>
        <td><%=book.getId()%></td>
        <td><%=book.getTitle()%></td>
        <td><%=book.getDescription()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getAuthor().getName()%></td>
        <%if (user.getUserType() == UserType.ADMIN) {%>
        <td><a href="/removeBook?id=<%=book.getId()%>">Delete</a>
            / <a href="/updateBook?id=<%=book.getId()%>">Update</a> </td>
        <%}%>
    </tr>
    <%}%>
    <%}%>
</table>
</body>
</html>
