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
    <h2>Form them thong tin</h2>
    <form action="/xe/add" method="post">
        maXe: <input type="text" name="maXe"> <br>
        tenXe: <input type="text" name="tenXe"> <br>
        hangSanXuat: <input type="text" name="hangSanXuat"> <br>
        gia: <input type="text" name="gia"> <br>
        soLuong: <input type="text" name="soLuong"> <br>
        mauSac: <input type="text" name="mauSac"> <br>
        ngayNhap: <input type="text" name="ngayNhap"> <br>
        isNew: Moi <input type="radio" name="isNew" value="true">
        Cu <input type="radio" name="isNew" value="false">
        <br>
        <button>Submit</button>
    </form>

    <h2>Bang thong tin</h2>
    <table>
        <thead>
        <tr>
            <th>maXe</th>
            <th>tenXe</th>
            <th>hangSanXuat</th>
            <th>gia</th>
            <th>soLuong</th>
            <th>mauSac</th>
            <th>ngayNhap</th>
            <th>isNew</th>
            <th>Hanh dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSach}" var="xe">
            <tr>
                <th>${xe.maXe}</th>
                <th>${xe.tenXe}</th>
                <th>${xe.hangSanXuat}</th>
                <th>${xe.gia}</th>
                <th>${xe.soLuong}</th>
                <th>${xe.mauSac}</th>
                <th>${xe.ngayNhap}</th>
                <th>${xe.isNew ? "Moi" : "Cu"}</th>
                <td>
                    <a href="/xe/view-update?maXe=${xe.maXe}">View update</a>
                    <a href="/xe/xoa?maXe=${xe.maXe}">Xoa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
