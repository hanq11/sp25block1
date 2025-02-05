<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/5/2025
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them dieu hoa:
    <form action="/dieu-hoa/add" method="post">
        Ten: <input type="text" name="ten"> <br>
        Gia: <input type="text" name="gia"> <br>
        So luong: <input type="text" name="soLuong"> <br>
        Loai dieu hoa: <select name="idLoaiDieuHoa">
            <c:forEach items="${listLoaiDieuHoa}" var="ldh">
                <option value="${ldh.id}" label="${ldh.ten}"></option>
            </c:forEach>
        </select> <br>
        <button>Submit</button>
    </form>
    Bang thong tin:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Gia</th>
                <th>So luong</th>
                <th>Loai dieu hoa</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listDieuHoa}" var="dh">
                <tr>
                    <td>${dh.id}</td>
                    <td>${dh.ten}</td>
                    <td>${dh.gia}</td>
                    <td>${dh.soLuong}</td>
                    <td>${dh.loaiDieuHoa.ten}</td>
                    <th>
                        <a href="/dieu-hoa/delete?id=${dh.id}">Delete</a>
                        <a href="/dieu-hoa/detail?id=${dh.id}">Detail</a>
                        <a href="/dieu-hoa/view-update?id=${dh.id}">View update</a>
                    </th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
