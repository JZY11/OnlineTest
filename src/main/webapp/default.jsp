<%--
  Created by IntelliJ IDEA.
  User: Tony.Jaa
  Date: 2017/6/17
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<form action="student" method="post">
    <input type="hidden" name="action" value="login">
    <input type="text" name="username" placeholder="用户名"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="submit" value="登录">
</form>
<p>
    ${requestScope.message}
</p>
<a href="signup.jsp">注册</a>
</body>
</html>
