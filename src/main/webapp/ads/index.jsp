<%--
  Created by IntelliJ IDEA.
  User: lancecrowder
  Date: 6/4/18
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Ads!" />
    </jsp:include>
</head>
<body>

<jsp:include page="/partials/navbar.jsp"/>

<c:forEach var="ads" items="${ad}">
    <h1>${ad.title}</h1>
    <p>${ad.description}</p>
</c:forEach>
</body>
</html>
