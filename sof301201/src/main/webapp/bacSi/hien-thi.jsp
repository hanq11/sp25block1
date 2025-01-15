<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/15/2025
  Time: 8:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them bac si
    <form action="/bac-si/add" method="post">
        Ten: <input type="text" name="ten"> <br>
        Luong: <input type="text" name="luong"> <br>
        Dia chi: <input type="text" name="diaChi"> <br>
        Phong kham:
            <select name="phongKham">
                <c:forEach items="${listPhongKham}" var="pk">
                    <option value="${pk.id}" label="${pk.ten}"></option>
                </c:forEach>
            </select> <br>
        <button>Submit</button>
    </form>
    <br>
    Thong tin
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Luong</th>
                <th>Dia chi</th>
                <th>Phong kham</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="bs">
                <tr>
                    <td>${bs.id}</td>
                    <td>${bs.ten}</td>
                    <td>${bs.luong}</td>
                    <td>${bs.diaChi}</td>
                    <td>${bs.phongKham.ten}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
