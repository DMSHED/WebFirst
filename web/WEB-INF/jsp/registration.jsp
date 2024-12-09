<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 07.12.2024
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <img src="${pageContext.request.contextPath}/images/users/3.jpg" alt="User image">

    <form action="/registration" method="post" enctype="multipart/form-data">
        <label for="nameId">Name:
            <input type="text" name="username" id="nameId" required>
        </label>
        <br>
        <label for="BirthdayId">Birthday:
            <input type="date" name="birthday" id="BirthdayId" required>
        </label>
        <br>
        <label for="imageId">Image:
            <input type="file" name="image" id="imageId" required>
        </label>
        <label for="emailId">Email:
            <input type="text" name="email" id="emailId" required>
        </label>
        <br>
        <label for="passwordId">Password:
            <input type="password" name="password" id="passwordId" required>
        </label>
        <br>
        <select name="role" id="roleId" >
            <c:forEach var="role" items="${requestScope.roles}">
                <option value="${role}">${role}</option>
                <br>
            </c:forEach>
        </select>
        <br>
        <c:forEach var="gender" items="${requestScope.gender}">
            <input type="radio" name="gender" value="${gender}"> ${gender}
            <br>
        </c:forEach>
        <button type="submit">Send</button>
        <br>
        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span>
                    <br>
                </c:forEach>
            </div>
        </c:if>


    </form>
</body>
</html>
