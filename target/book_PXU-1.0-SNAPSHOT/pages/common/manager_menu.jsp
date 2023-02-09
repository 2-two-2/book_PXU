<%--
  Created by IntelliJ IDEA.
  User: zhonghua
  Date: 2022/11/15
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%--给servlet传递参数--%>
    <a href="manager/BookServlet?action=page">图书管理</a>
    <a href="OrderServlet?action=showAllOrders">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
