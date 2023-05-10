<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/9/2023
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List Student</h2>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>action</th>
    </tr>
    <c:forEach items="${listStudent}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.sex?"nam":"nu"}</td>
            <td><a href="<%=request.getContextPath()%>/studentController/edit?id=${student.id}">sua</a></td>
            <td><a href="<%=request.getContextPath()%>/studentController/delete?id=${student.id}">xoa</a></td>
        </tr>
    </c:forEach>
    </thead>
</table>
<a href="<%=request.getContextPath()%>/views/createStudent.jsp">create student</a>
</body>
</html>
