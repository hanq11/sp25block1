<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/6/2025
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Id: ${sinhVien.id} <br>
    Ten: ${sinhVien.ten} <br>
    Tuoi: ${sinhVien.tuoi} <br>
    GioiTinh: ${sinhVien.gioiTinh ? "Nam" : "Nu"}
</body>
</html>
