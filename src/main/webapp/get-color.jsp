<%--
  Created by IntelliJ IDEA.
  User: lancecrowder
  Date: 6/1/18
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Enter Color</title>
</head>
<body>
<form action="pickcolor" method="post">
    <h1>Please enter your favorite color</h1>
    <input type="color" placeholder="Please enter your favorite color Here" name="color" required>
    <button type="submit">Enter!</button>
</form>
</body>
</html>