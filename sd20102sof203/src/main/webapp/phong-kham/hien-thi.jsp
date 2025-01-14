<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/14/2025
  Time: 9:06 AM
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
                <th>Id</th>
                <th>Ten</th>
                <th>Dia chi</th>
                <th>So nha</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="pk">
                <tr>
                    <td>${pk.id}</td>
                    <td>${pk.ten}</td>
                    <td>${pk.diaChi}</td>
                    <td>${pk.soNha}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
