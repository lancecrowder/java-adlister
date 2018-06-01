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
    <title>Enter Name</title>
</head>
<body>
<form action="/name" method="post">
<h1>Please enter your first Name</h1>
<input type="text" placeholder="Your First Name Here" name="name" required>
<button type="submit">Enter!</button>
</form>
</body>
</html>