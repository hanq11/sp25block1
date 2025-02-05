<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/5/2025
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua dieu hoa:
    <form action="/dieu-hoa/add" method="post">
        Ten: <input type="text" name="ten" value="${dieuHoa.ten}"> <br>
        Gia: <input type="text" name="gia" value="${dieuHoa.gia}"> <br>
        So luong: <input type="text" name="soLuong" value="${dieuHoa.soLuong}"> <br>
        Loai dieu hoa: <select name="idLoaiDieuHoa">
        <c:forEach items="${listLoaiDieuHoa}" var="ldh">
            <option value="${ldh.id}" label="${ldh.ten}" ${dieuHoa.loaiDieuHoa.id == ldh.id ? "selected" : ""}></option>
        </c:forEach>
    </select> <br>
        <button>Submit</button>
    </form>
</body>
</html>
