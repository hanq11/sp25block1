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
    <form action="/vali/add" method="post">
        Ma: <input type="text" name="ma"> <br>
        Ten: <input type="text" name="ten"> <br>
        Gia: <input type="text" name="gia"> <br>
        <button>Submit</button>
    </form>

    <h2>Bang thong tin</h2>
    <table>
        <thead>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Gia</th>
            <th>Hanh dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSach}" var="vali">
            <tr>
                <td>${vali.ma}</td>
                <td>${vali.ten}</td>
                <td>${vali.gia}</td>
                <td>
                    <a href="/vali/view-update?ma=${vali.ma}">View update</a>
                    <a href="/vali/xoa?ma=${vali.ma}">Xoa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
