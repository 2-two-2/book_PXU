<%--
  Created by IntelliJ IDEA.
  User: zhonghua
  Date: 2022/11/15
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.User.username}</span>光临教育书城</span>
    <a href="OrderServlet?action=showMyOrders">我的订单</a>
    <a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
