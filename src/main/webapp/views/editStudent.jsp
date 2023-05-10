<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/9/2023
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/studentController/update" method="post">
    <table>
        <thead>
        <tr>
            <td>id</td>
            <td><input type="number" name="id" value="${editStudent.id}"></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input type="text" name="name" value="${editStudent.name}"></td>
        </tr>
        <tr>
            <td>age</td>
            <td><input type="number" name="age" value="${editStudent.age}"></td>
        </tr>
        <tr>
            <td>sex</td>
            <td><select name="sex" id="">
                <option value="true" ${editStudent.sex}>nam</option>
                <option value="false" ${editStudent.sex}>nu</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">update</button></td>
        </tr>
        </thead>
    </table>
</form>
</body>
</html>
