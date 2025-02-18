<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/13/2025
  Time: 8:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Form sua thong tin</h2>
    <form action="/xe/update" method="post">
        maXe: <input type="text" name="maXe" value=${xe.maXe}> <br>
        tenXe: <input type="text" name="tenXe" value=${xe.tenXe}> <br>
        hangSanXuat: <input type="text" name="hangSanXuat" value=${xe.hangSanXuat}> <br>
        gia: <input type="text" name="gia" value=${xe.gia}> <br>
        soLuong: <input type="text" name="soLuong" value=${xe.soLuong}> <br>
        mauSac: <input type="text" name="mauSac" value=${xe.mauSac}> <br>
        ngayNhap: <input type="text" name="ngayNhap" value=${xe.ngayNhap}> <br>
        isNew: Moi <input type="radio" name="isNew" value="true" ${xe.isNew ? "checked" : ""}>
        Cu <input type="radio" name="isNew" value="false" ${!xe.isNew ? "checked" : ""}>
        <br>
        <button>Submit</button>
    </form>
</body>
</html>
