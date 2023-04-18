<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/29
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/FashionAnalysis/" />
    <link rel="stylesheet" href="css/startanalysis.css"/>
    <title>Choose The Plan</title>
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
    <div class="panel">
        <div class="tip">选择你的分析方案</div>

        <div class="choice">
            <div class="item">
                <a href="javascript:void(0)">每个大类商品每个小类别折扣最大的商品的受喜爱度平均值</a>
            </div>
            <div class="item">
                <a href="javascript:void(0)">每个大类商品每个小类别折扣最大的商品的前三名</a>
            </div>
            <div class="item">
                <a href="javascript:void(0)">每个大类商品每个小类别折扣最大的商品的前三名</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
