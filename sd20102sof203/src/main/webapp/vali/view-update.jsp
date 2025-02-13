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
    <form action="/vali/update" method="post">
        Ma: <input type="text" name="ma" value="${vali.ma}"> <br>
        Ten: <input type="text" name="ten" value="${vali.ten}"> <br>
        Gia: <input type="text" name="gia" value="${vali.gia}"> <br>
        <button>Submit</button>
    </form>
</body>
</html>
