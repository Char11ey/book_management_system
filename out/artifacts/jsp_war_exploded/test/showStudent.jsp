<%@ page import="java.util.List" %>
<%@ page import="pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sakura
  Date: 2021/6/1
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            width: 600px;
            border: 1px black solid;
            border-collapse: collapse;
        }
        td,th{
            border: 1px black solid;
        }
    </style>
</head>
<body>
    <%
        List<Student> stuList = (List<Student>) request.getAttribute("StuList");
    %>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>手机号</td>
            <td>操作</td>
        </tr>
    <% for(Student student : stuList) {%>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>
            <td><%= student.getPhoneNumber() %></td>
            <td> 删除、修改 </td>
        </tr>
    <% } %>
    </table>
</body>
</html>
