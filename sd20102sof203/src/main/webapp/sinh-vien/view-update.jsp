<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/6/2025
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua thong tin: <br>
    <form action="/sinh-vien/update" method="post">
        Id: <input type="text" name="id" value="${sinhVien.id}"> <br>
        Ten: <input type="text" name="ten" value="${sinhVien.ten}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${sinhVien.tuoi}"> <br>
        Gioi tinh:
        Nam <input type="radio" name="gioiTinh" value="true" ${sinhVien.gioiTinh ? "checked" : ""}>
        Nu <input type="radio" name="gioiTinh" value="false" ${sinhVien.gioiTinh ? "" : "checked"}> <br>
        <button>Submit</button>
    </form>
</body>
</html>
