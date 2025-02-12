<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 20/1/25
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/user/update" method="post">
    <label>id</label>
    <input type="text" name="id" value="${detail.id}" readonly> <br>
    <label>ho ten</label>
    <input type="text" name="hoTen" value="${detail.hoTen}"> <br>
    <label>tuoi</label>
    <input type="number" name="tuoi" value="${detail.tuoi}"> <br>
    <label>dia chi</label>
    <input type="text" name="diaChi" value="${detail.diaChi}"> <br>
    <label>gioi tinh</label>
    <input type="radio" value="nam" name="gioiTinh" ${detail.gioiTinh == 'nam' ?'checked': ''}> Nam
    <input type="radio" value="nu" name="gioiTinh" ${detail.gioiTinh == 'nu' ?'checked': ''}> Nu <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
