<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>java 学习登陆</title>
</head>
<body>
<h1 align="center">租车系统登陆</h1>
<div style="width:100%;text-align:center">
    <form action="LoginCheck" method="post">
        <font size=5>用户名</font> <input type="text" name="username"><br>
        <font size=5>密　码</font>  <input type="password" name="password" placeholder="四位数字"><br>
        <p><input type = "submit" style="width:80px; height:30px; background:#F001; font-size:18px" name="submit"></p>
    </form>
</div>
</body>
</html>
