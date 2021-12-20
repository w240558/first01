<%--
  Created by IntelliJ IDEA.
  User: Vae——许嵩
  Date: 2021-12-08
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
登录成功，欢迎：${msg}
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <h2>文件上传</h2>
    文件:<input type="file" name="uploadFile"/><br/><br/>
    <input type="submit" value="点击上传"/>
</form>

<h2>文件下载</h2>
<a href="${pageContext.request.contextPath}/down?fileName=lhs私密档案.txt"
   download="${pageContext.request.contextPath}/down?fileName=lhs私密档案.txt">
    下载文件
</a>
<br>
<!--向服务器发起请求获取文件-->
<a href="${pageContext.request.contextPath}/down?fileName=image1.jpg"
   download="${pageContext.request.contextPath}/down?fileName=image1.jpg">
    点击下载aaa.jpg
</a>


</body>
</html>
