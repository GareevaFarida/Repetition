<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15.05.2020
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список студентов</title>
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
    </tr>

    <c:forEach items="${students}" var="stud">
        <tr>
            <td>${stud.id}</td>

            <c:url value="/students/edit" var="editStudentUrl">
                <c:param name="id" value="${stud.id}"/>
            </c:url>
            <td><a href="${editStudentUrl}">${stud.name}</a></td>

            <td>${stud.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
