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
    Tim kiem bac si:
    <form action="/bac-si/search" method="get">
        Ten: <input type="text" name="ten"> <br>
        <button>Submit</button>
    </form>
    <br>
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
                    <td>
                        <a href="/bac-si/detail?id=${bs.id}">Detail</a>
                        <a href="/bac-si/delete?id=${bs.id}">Delete</a>
                        <a href="/bac-si/view-update?id=${bs.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/bac-si/paging?page=${pageNo - 1}">Prev</a> <br>
    <a href="/bac-si/paging?page=${pageNo + 1}">Next</a>
</body>
</html>
