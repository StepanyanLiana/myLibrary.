<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2023
  Time: 16:08
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
    <title>Create authors</title>
</head>
<body>
<a href="/allAuthors"> Back </a>

<h2>Create authors</h2>
<form action="/createAuthors" method="post" enctype="multipart/form-data">
    name: <input type="text" name="name"><br>
    surname: <input type="text" name="surname"><br>
    email: <input type="email" name="email"><br>
    age: <input type="text" name="age"><br>
    image: <input type="file" name="profilePic" value="chooseImage"><br>
    <input type="submit" value="create">
</form>
</body>
</html>
