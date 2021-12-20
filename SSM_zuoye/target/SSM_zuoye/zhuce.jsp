<%--
  Created by IntelliJ IDEA.
  User: Vae——许嵩
  Date: 2021-12-08
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
    </style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/login.css">
</head>
<body text="blue">
<hr size="3px" color="red" width="100%"/>
<div align="center"><font size="20px">注册界面</font></div>
<hr size="3px" color="red" width="100%"/>
<br><br><br><br><br><br><br><br><br><br>
<form action="${pageContext.request.contextPath}/student/zhuce.do">
    <table align="center" width="600px" bgcolor="#7fffd4" height="320px">
        <tr><th colspan="600px" height="120px" align="center"><font size="5px" color="darkred">注册界面</font></th></tr>
        <tr><td colspan="600px" height="50px" align="center">用户名：<input type="text" name="name" placeholder="请输入账号"></td></tr>
        <tr><td colspan="600px" height="50px" align="center">密码：<input type="password" name="password" placeholder="请输入密码"></td></tr>
        <tr><th width="260px" height="40px" align="right"><input type="submit" value="注册"></th><th></th><th></th></tr>
        <tr><th height="60px"></th></tr>
    </table>
</form>
</body>
</html>
