<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/20/2025
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua bac si
    <form action="/bac-si/update" method="post">
        Id: <input type="text" name="id" value="${bacSi.id}"> <br>
        Ten: <input type="text" name="ten" value="${bacSi.ten}"> <br>
        Luong: <input type="text" name="luong" value="${bacSi.luong}"> <br>
        Dia chi: <input type="text" name="diaChi" value="${bacSi.diaChi}"> <br>
        Phong kham:
        <select name="phongKham">
            <c:forEach items="${listPhongKham}" var="pk">
                <option value="${pk.id}" label="${pk.ten}" ${pk.id == bacSi.phongKham.id ? "selected" : ""}></option>
            </c:forEach>
        </select> <br>
        <button>Submit</button>
    </form>
</body>
</html>
