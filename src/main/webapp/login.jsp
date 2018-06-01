<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (request.getMethod().equalsIgnoreCase("post")){
    String username = request.getParameter("uname");
    String password = request.getParameter("psw");

}%>

<html>
<head>login.jsp</head>
<body><h1>Please Log In: </h1>
<input type="text" placeholder="Enter Username" name="uname" required>
<input type="password" placeholder="Enter Password" name="psw" required>
<button type="submit">Login</button>


</body>
</html>