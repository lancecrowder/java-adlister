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
    <title>Enter Summands</title>
</head>
<body>
<form action="/multiplication" method="POST">
    <h1>Please enter your first Number</h1>
    <input type="number" placeholder="Your First Number Here" name="multiplicand1" required autofocus>

    <h1>Please enter your Second Number</h1>
    <input type="number" placeholder="Your Second Number Here" name="multiplicand2" required autofocus>

    <button type="submit">Enter!</button>
</form>
</body>
</html>