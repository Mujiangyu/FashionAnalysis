<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/17
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/FashionAnalysis/" />
    <link rel="stylesheet" href="css/mainpage_common.css"/>
    <link rel="stylesheet" href="css/mainpage_login.css"/>
    <link rel="stylesheet" href="css/mainpage_regist.css"/>
    <link rel="stylesheet" href="css/mainpage_reset.css"/>
    <script src="javascript/mainpage.js"></script>
    <title>vogue-addict 欢迎</title>
</head>
<body>
<!-- 外部包装 -->
<div class="wrapper">
    <!-- 页眉 -->
    <div class="header">
        <div class="logo">
            <img src="sources/logo.jpg" alt="网站Logo" width="80px" height="80px"/>
            <div class="tab">
                <span style="border: 1px dashed orange;border-radius: 15px;background-color: orange;color: black;">Vogue</span>
                <span> Addict</span>
            </div>
        </div>
    </div>

    <div class="motion">
        <img src="sources/dance.gif" width="380px" height="380px" alt="dance">
    </div>

    <!-- 登录界面 -->
    <div id="login" style="display: block;">
        <div class="title">Login</div>
        <span class="msg">${requestScope.information}</span>

        <form action="font/UserLoginServlet" method="post">
            <div class="item">
                <label for="name_1">用户名</label>
                <input type="text" id="name_1" name="userName" placeholder="请输入用户名" required/>
            </div>

            <div class="item">
                <label for="password_1">密码</label>
                <input type="password" id="password_1" name="password" placeholder="请输入密码" required/><br/>
            </div>

            <div class="function">
                <a href="#" onclick="userRegist()">用户注册</a>
                <a href="#" onclick="userReset()">忘记密码</a>
            </div>
            <div class="button">
                <input type="submit" value="登录"/>
            </div>
        </form>
    </div>

    <!-- 注册界面 -->
    <div id="regist" style="display: none;">
        <div class="title">Regist</div>
        <span class="msg">${requestScope.information}</span>
        <form action="font/UserRegisterServlet" method="post">
            <div class="item">
                <label for="name_2">用户名</label>
                <input type="text" id="name_2" name="userName" placeholder="请输入用户名" required/>
            </div>

            <div class="item">
                <label for="password_2">密码</label>
                <input type="password" id="password_2" name="password" placeholder="请输入密码" required/>
            </div>

            <div class="item">
                <label for="birthday">生日</label>
                <input type="date" id="birthday" name="birthday" required/>
            </div>

            <div class="item">
                <label for="email">邮箱</label>
                <input type="email" id="email" name="email" placeholder="请输入正确的邮箱" required/>
            </div>

            <div class="item">
                <label for="validQuestion_2">验证问题</label>
                <select id="validQuestion_2" name="validQuestion" required>
                    <option value="母亲的姓名">母亲的姓名</option>
                    <option value="父亲的姓名">父亲的姓名</option>
                    <option value="高中班主任老师的姓名">高中班主任老师的姓名</option>
                    <option value="最喜欢的工作">最喜欢的工作</option>
                    <option value="最喜欢的食物">最喜欢的食物</option>
                </select>
            </div>

            <div class="item">
                <label for="validAnswer_2">答案</label>
                <input type="text" id="validAnswer_2" name="validAnswer" placeholder="请输入你的答案" required/>
            </div>

            <div class="function">
                <a href="#" onclick="userLogin()">用户登录</a>
                <a href="#" onclick="userReset()">忘记密码</a>
            </div>

            <div class="button">
                <input type="submit" value="注册"/>
            </div>
        </form>
    </div>

    <!-- 修改密码界面 -->
    <div id="resetpwd" style="display: none;">
        <div class="title">Reset</div>
        <span class="msg">${requestScope.information}</span>
        <form action="font/UserChangePasswordServlet" method="post">
            <div class="item">
                <label for="name_3">用户名</label>
                <input type="text" id="name_3" name="userName" placeholder="请输入用户名" required />
            </div>

            <div class="item">
                <label for="validQuestion_3">你的验证问题</label>
                <select id="validQuestion_3" name="validQuestion" required>
                    <option value="0">母亲的姓名</option>
                    <option value="1">父亲的姓名</option>
                    <option value="2">高中班主任老师的姓名</option>
                    <option value="3">最喜欢的工作</option>
                    <option value="4">最喜欢的食物</option>
                </select>
            </div>

            <div class="item">
                <label for="validAnswer_3">验证问题答案</label>
                <input type="text" id="validAnswer_3" name="validAnswer" placeholder="请输入你的验证问题答案" required/>
            </div>

            <div class="item">
                <label for="newPassword_3">新的密码</label>
                <input type="password" id="newPassword_3" name="newPassword" placeholder="请输入密码" required/><br/>
            </div>

            <div class="function">
                <a href="#" onclick="userRegist()">用户注册</a>
                <a href="#" onclick="userLogin()">用户登录</a>
            </div>

            <div class="button">
                <input type="submit" value="提交"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
