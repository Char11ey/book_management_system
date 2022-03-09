<%--
  Created by IntelliJ IDEA.
  User: Sakura
  Date: 2021/6/1
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 650px;
            border: 1px red solid;
            border-collapse: collapse;
        }
        tr,td{
            border: 1px red solid;
        }
    </style>
</head>
<body>
<h1 align="center">9 X 9乘法表</h1>
<table align="center">
    <% for (int i = 1; i <= 9; i++){ %>
        <tr>
            <%for(int j = 1;  j <= i; j++){%>
                <td><%=i + "*" + j + "=" + (i*j)%></td>
            <% } %>
        </tr>
        <% } %>
</table>
</body>
</html>
