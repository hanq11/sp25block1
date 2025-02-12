<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 10/1/25
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Day la trang chu</h1>
<%--Cu phap lay gia tri tu servlet--%>

<h2>Ho ten la: ${hoTen}</h2>
<%--Cach 1: lay thong tin qua getter--%>
<h2>${user.getId()}</h2>

<%--Cach 2: Lay thong tin qua thuoc tinh--%>
<h2>${user.hoTen}</h2>

<h2>Xin chao: ${email}</h2>
</body>
</html>
