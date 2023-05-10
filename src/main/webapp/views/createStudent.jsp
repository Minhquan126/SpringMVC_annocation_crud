<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/9/2023
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/studentController/add" method="post">
    <table>
        <thead>
        <tr>
            <td>name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>age</td>
            <td><input type="number" name="age"></td>
        </tr>
        <tr>
            <td>sex</td>
            <td><select name="sex" id="sex">
                <option value="true">nam</option>
                <option value="false">nu</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">add</button></td>
        </tr>
        </thead>
    </table>
</form>
</body>
</html>
