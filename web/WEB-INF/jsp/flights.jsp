<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08.12.2024
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%@include file="header.jsp"%>
  <h1>Список перелетов:</h1>
  <ul>
    <c:forEach var="flight" items="${requestScope.flights}">
      <li>
        <a href="/ticket?flightId=${flight.getId()}">${flight.getDescription()}</a>
      </li>
    </c:forEach>
  </ul>
</body>
</html>
