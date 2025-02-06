<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/6/2025
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them thong tin: <br>
    <form action="/sinh-vien/add" method="post">
        Id: <input type="text" name="id"> <br>
        Ten: <input type="text" name="ten"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Gioi tinh: Nam <input type="radio" name="gioiTinh" value="true">
        Nu <input type="radio" name="gioiTinh" value="false"> <br>
        <button>Submit</button>
    </form>
    <br>
    Bang thong tin:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Gioi Tinh</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSinhVien}" var="sinhVien">
                <tr>
                    <td>${sinhVien.id}</td>
                    <td>${sinhVien.ten}</td>
                    <td>${sinhVien.tuoi}</td>
                    <td>${sinhVien.gioiTinh ? "Nam" : "Nu"}</td>
                    <td>
                        <a href="/sinh-vien/view-update?id=${sinhVien.id}">View update</a>
                        <a href="/sinh-vien/xoa?id=${sinhVien.id}">Xoa</a>
                        <a href="/sinh-vien/detail?id=${sinhVien.id}">Detail</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
