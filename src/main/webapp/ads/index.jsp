<%--
  Created by IntelliJ IDEA.
  User: lancecrowder
  Date: 6/4/18
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Ads!" />
    </jsp:include>
</head>
<body>

<jsp:include page="/partials/navbar.jsp"/>
<h1>Here's yer ads</h1>

<c:forEach var="ad" items="${ads}">
    <h1>${ad.title}</h1>
    <p>${ad.description}</p>
</c:forEach>

</body>
</html>
