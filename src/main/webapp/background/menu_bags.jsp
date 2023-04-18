<%@ page import="java.util.Map" %>
<%@ page import="org.apache.hadoop.hbase.client.ResultScanner" %>
<%@ page import="org.apache.hadoop.hbase.client.Result" %>
<%@ page import="org.apache.hadoop.hbase.util.Bytes" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/27
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 引入JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/FashionAnalysis/" />
    <link rel="stylesheet" href="css/main.css"/>
    <script src="javascript/main.js"></script>
    <title>Menu</title>
</head>
<body>
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

    <!-- 导航栏 -->
    <ul class="nav">
        <li><a href="background/menu_accessories.jsp">Accessories</a></li>
        <li><a href="javascript:void(0)" >Bags</a></li>
        <li><a href="background/menu_beauty.jsp" >Beauty</a></li>
        <li><a href="background/menu_house.jsp" >House</a></li>
        <li><a href="background/menu_jewelry.jsp" >Jewelry</a></li>
        <li><a href="background/menu_kids.jsp" >Kids</a></li>
        <li><a href="background/menu_men.jsp" >Men</a></li>
        <li><a href="background/menu_shoes.jsp" >Shoes</a></li>
        <li><a href="background/menu_women.jsp" >Women</a></li>
        <li><a href="background/startanalysis.jsp" >Analysis</a></li>
    </ul>

    <!-- 购物车图标 -->
    <a href="#" class="cart">
        <img class="cart" src="sources/cart.jpg" alt="购物车" width="50px" height="50px"/>
    </a>

    <!-- Accessories -->
    <div class="panel" >

        <!-- 图片库创建 -->
        <%
            Map<String, ResultScanner> tableScanner =
                (Map<String, ResultScanner>) application.getAttribute("tableScanner");
        %>

        <!-- 不同库，类属性待定 -->
        <%
            for (Result rowResult : tableScanner.get("category-bags")) {
                pageContext.setAttribute("rowKey", Bytes.toString(rowResult.getRow()));
                pageContext.setAttribute("modelURL", Bytes.toString( rowResult.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("modelURL")) ));
                pageContext.setAttribute("subcategory", Bytes.toString(rowResult.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("subcategory"))));
                pageContext.setAttribute("name", Bytes.toString(rowResult.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("name"))));
                pageContext.setAttribute("currentPrice", Bytes.toString(rowResult.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("currentPrice"))));
                pageContext.setAttribute("likesCount", Bytes.toString(rowResult.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("likesCount"))));
                pageContext.setAttribute("brand", Bytes.toString(rowResult.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("brand"))));
        %>
        <div class="gallery">
            <a href="background/ExtractDetailServlet?tableName=category-bags&rowKey=${pageScope.rowKey}">
                <img src="${pageScope.modelURL}" alt="Product" width="250px" height="250px">
            </a>

            <div class="desc_subcategory"><b>SubCategory：</b>${pageScope.subcategory}</div>
            <div class="desc_name"><b>Name：</b>${pageScope.name}</div>
            <div class="desc_currentPrice"><b>Current price：</b>${pageScope.currentPrice}</div>
            <div class="desc_likesCount"><b>Like count：</b>${pageScope.likesCount}</div>
            <div class="desc_brand"><b>Brand：</b>${pageScope.brand eq " " ? "Nothing" : pageScope.brand}</div>
        </div>
        <%}%>


    </div>

</div>
</body>
</html>
