<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/8/2025
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them phong kham
    <form action="/phong-kham/add" method="post">
        Ten: <input type="text" name="ten"> <br>
        Dia chi: <input type="text" name="diaChi"> <br>
        <button>Submit</button>
    </form>

    <br>

    Danh sach phong kham
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Dia chi</th>
                <th colspan="3">Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="pk">
                <tr>
                    <td>${pk.id}</td>
                    <td>${pk.ten}</td>
                    <td>${pk.diaChi}</td>
                    <td>
                        <a href="/phong-kham/detail?id=${pk.id}">Detail</a>
                        <a href="/phong-kham/delete?id=${pk.id}">Delete</a>
                        <a href="/phong-kham/view-update?id=${pk.id}">View update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
