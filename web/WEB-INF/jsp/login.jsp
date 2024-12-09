<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08.12.2024
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login" method="post">
        <label for="emailId">Email:
            <input type="text" name="email" id="emailId" value="${param.email}" required>
        </label>
        <br>
        <label for="passwordId">Password:
            <input type="password" name="password" id="passwordId" required>
        </label>
        <br>
        <button type="submit">Login</button>
        <a href="registration">
            <button type="button">Register</button>
        </a>
        <div>
            <c:if test="${param.error} != null">
                <div>
                    <span>Email or password is not correct</span>
                </div>
            </c:if>
        </div>
    </form>
</body>
</html>
