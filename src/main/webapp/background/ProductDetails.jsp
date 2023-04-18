<%@ page import="pojo.ProductInformation" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/28
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/FashionAnalysis/" />
    <link rel="stylesheet" href="css/productdetails.css"/>
    <script src="javascript/productdetails.js"></script>
    <title>Product Details</title>
</head>
<body>
<div class="wrapper">
    <%-- 获取复杂Bean对象 --%>
    <%
        ProductInformation product = (ProductInformation) request.getAttribute("information");
        pageContext.setAttribute("info", product);
    %>
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

    <div class="panel">
        <!-- 图片部分 -->
        <div class="icons">
            <img src="${info.modelURL}" alt="模特试穿照" style="display: inline;"/>
            <img src="${info.colorTypeOne eq " " ? info.modelURL : info.colorTypeOne}" alt="颜色一" style="display: none;"/>
            <img src="${info.colorTypeTwo eq " " ? info.modelURL : info.colorTypeTwo}" alt="颜色二" style="display: none;"/>

        </div>

        <div id="box">
            <!-- 文字描述部分----项 -->
            <div class="items">
                <div>Category</div>
                <div>SubCategory</div>
                <div>Name</div>
                <div>Current Price</div>
                <div>Raw Price</div>
                <div>Currency</div>
                <div>Discount</div>
                <div>Likes Count</div>
<%--                <div>Is New</div>--%>
                <div>Brand</div>
                <div>Color Type</div>
            </div>

            <!-- 文字描述内容 -->
            <div class="contents">
                <div>${info.category}</div>
                <div>${info.subcategory}</div>
                <div>${info.name}</div>
                <div>${info.currentPrice}</div>
                <div>${info.rawPrice}</div>
                <div>${info.currency}</div>
                <div>${info.discount}</div>
                <div>${info.likesCount}</div>
<%--                <div>${info.new}</div>--%>
                <div>${info.brand eq " " ? "Nothing" : info.brand}</div>
                <div>${info.colorTypeOne} ${info.colorTypeTwo}</div>
            </div>
        </div>
        <div class="button">
            <button class="goBack" onclick="javascript:history.back()">点击返回</button>
        </div>
    </div>

</div>
</body>
</html>
