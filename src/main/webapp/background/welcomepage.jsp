<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/16
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>`
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<html>
<head>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/FashionAnalysis/" />
    <link rel="stylesheet" href="css/welcomepage.css"/>
    <script src="javascript/welcome.js"></script>
    <title>Welcome ${sessionScope.userName}</title>
</head>
<body>
<!-- 外部包装 -->
<div class="wrapper">

    <!-- 页眉 -->
    <div class="header">
        <div class="logo">
            <img src="sources/logo.jpg" alt="网站Logo" width="80" height="80"/>
            <div class="tab">
            <span style="border: 1px dashed orange;border-radius: 15px;background-color: orange;color: black;">Vogue</span>
            <span> Addict</span>
            </div>
        </div>
    </div>

    <!-- 欢迎标语 -->
    <div class="slogan">
        欢迎<span class="username"> ${sessionScope.userName}</span>
        <!-- 点击跳转，加载数据 -->
        <div class="next_button">
            <a href="background/DataProcessServlet">NEXT</a>
        </div>
    </div>
</div>
</body>
</html>
