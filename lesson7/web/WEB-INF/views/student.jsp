<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New product</title>
</head>
<body>

<c:url value="/students/save" var="createUrl"/>
<form action="${createUrl}" method="post">
    <input type="hidden" name="id" id="id" value="${student.id}">
    <p>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="${student.name}"/>
    </p>
    <p>
        <label for="age">Age</label>
        <input type="text" id="age" name="category" value="${student.age}" disabled/>
    </p>

    <input type="submit"/>
</form>

</body>
</html>
