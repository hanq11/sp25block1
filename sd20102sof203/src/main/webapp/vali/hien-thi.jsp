<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/11/2025
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Bang thong tin</h2>
    <table>
        <thead>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Gia</th>
            <th>Hanh dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSach}" var="vali">
            <tr>
                <td>${vali.ma}</td>
                <td>${vali.ten}</td>
                <td>${vali.gia}</td>
                <td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
