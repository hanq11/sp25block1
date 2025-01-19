<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/14/2025
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them phong kham
    <form action="/phong-kham/add" method="post">
        Id: <input type="text" name="id"> <br>
        Ten: <input type="text" name="ten"> <br>
        Dia chi: <input type="text" name="diaChi"> <br>
        So nha: <input type="text" name="soNha"> <br>
        <button>Submit</button>
    </form>

    <h2>Bang thong tin</h2>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Dia chi</th>
                <th>So nha</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="pk">
                <tr>
                    <td>${pk.id}</td>
                    <td>${pk.ten}</td>
                    <td>${pk.diaChi}</td>
                    <td>${pk.soNha}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
