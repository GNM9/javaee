<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>学生管理系统——登录界面</title>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/login.js"></script>
</head>
<body>
<form method="post" id="form" action="LoginServlet">
    <div id="container">
        <div id="titleBox">
            管理员登录
        </div>
        <div id="loginBox">
            <div id="userNameBox"><span>账号：</span><input type="text" id="admUserName" name="admusername" /></div>
            <div id="passWordBox"><span>密码：</span><input type="password" id="admPassWord" name="admpassword" /></div>
        </div>
        <div id="submitBox">
            <button id="loginSubmitButton">登录</button>
        </div>
    </div>
</form>
</body>
</html>
