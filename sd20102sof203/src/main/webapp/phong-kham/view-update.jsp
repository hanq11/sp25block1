<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 19-Jan-25
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua phong kham
    <form action="/phong-kham/update" method="post">
        Id: <input type="text" name="id" value="${phongKham.id}"> <br>
        Ten: <input type="text" name="ten" value="${phongKham.ten}"> <br>
        Dia chi: <input type="text" name="diaChi" value="${phongKham.diaChi}"> <br>
        So nha: <input type="text" name="soNha" value="${phongKham.soNha}"> <br>
        <button>Submit</button>
    </form>
</body>
</html>
