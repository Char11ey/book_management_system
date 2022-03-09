<%--
  Created by IntelliJ IDEA.
  User: Sakura
  Date: 2021/7/15
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="loginServlet" method="get">
        用户名：<input type="text" name="username" value="${cookie.username.value}"><br>
        密码： <input type="text" name="password"><br>
        <input type="submit" value="登录">
    </form>

</body>
</html>
