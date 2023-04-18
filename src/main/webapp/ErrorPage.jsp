<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/16
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://localhost:8080/FashionAnalysis/" />
    <link rel="stylesheet" href="css/ErrorStyle.css" type="text/css"/>
    <title>嘤嘤嘤，出现了Bug</title>
</head>
<body>
<div class="wrapper">
    <div class="title">那种事情不要啊！</div>
    <p id="message">很遗憾，我们的网站产生了一个错误...</p>
    <img src="sources/error.gif" alt="error.jpg" width="200px" height="350px"/>
    <div class="details">状 态 码：<%=request.getAttribute("javax.servlet.error.status_code")%></div>
    <div class="details">错误信息：<%=request.getAttribute("javax.servlet.error.message")%></div>
    <div class="details">请点击下方链接进行跳转</div>
    <div class="jump">
        <a href="UserInterface.jsp">点击这里</a>
    </div>
</div>
</body>
</html>
