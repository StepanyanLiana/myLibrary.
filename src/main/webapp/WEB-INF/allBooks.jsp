<%@ page import="com.example.myLibrary.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.myLibrary.model.Book" %>
<%@ page import="com.example.myLibrary.model.User" %>
<%@ page import="com.example.myLibrary.model.UserType" %>
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
        <th>user_id</th>
        <th>action</th>
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
        <td><%=(book.getUser() != null) ? book.getUser().getId() : "" %></td>
        <td><a href="/removeBook?id=<%=book.getId()%>">Delete</a>
            / <a href="/updateBook?id=<%=book.getId()%>">Update</a> </td>
    </tr>
    <%}%>
    <%}%>
</table>
</body>
</html>
