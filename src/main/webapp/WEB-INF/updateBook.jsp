<%@ page import="com.example.myLibrary.model.Book" %>
<%@ page import="com.example.myLibrary.model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <a href="/allBooks">Back</a>
    <title>Update book</title>
</head>
<body>
<%Book book = (Book) request.getAttribute("book");%>
<%List<Author> authorList = (List<Author>) request.getAttribute("authorsList");%>
<h2>Update Book</h2>
<form action="/updateBook" method="post">
    <input name="id" type="hidden" value="<%=book.getId()%>">
    title: <input type="text" name="title" value="<%=book.getTitle()%>"><br>
    description: <input type="text" name="description" value="<%=book.getDescription()%>"><br>
    price: <input type="email" name="price" value="<%=book.getPrice()%>"><br>
    author: <select name="author_id" >
    <%for (Author author : authorList) {%>
    <option value="<%=book.getAuthor().getId()%>"><%=author.getName()%><%=author.getSurname()%>
            <% }%>
</select><br>
    <input type="submit" value="update">
</form>
</body>
</html>
