<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 07.12.2024
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <div>
        <span>Content. Русский</span>
        <p>Size: ${requestScope.flights.size()}</p>
        <p>Id: ${requestScope.flights[1].id}</p>
        <p>Map Id: ${sessionScope.flightsMap[1]}</p>
        <p>JSESSION id: ${cookie["JSESSIONID"]} unique identifier</p>
        <p>Header ${header["Cookie"]}</p>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
