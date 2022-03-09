<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sakura
  Date: 2021/7/8
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <c:if test="${empty sessionScope.loginUser}">
        <span> 请返回登录 </span>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </c:if>
    <c:if test="${not empty sessionScope.loginUser}">
        <span>欢迎<span class="um_span">${sessionScope.loginUser.username}</span>光临尚硅谷书城</span>
        <a href="orderServlet?action=showAllOrders">我的订单</a>
        <a href="userServlet?action=logout">注销</a>
        <a href="index.jsp">返回</a>
    </c:if>
</div>