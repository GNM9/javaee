<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>学生管理系统</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css" type="text/css"/>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-xs-12 text-center">
                <h2>学生管理系统</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-xs-12 text-center">
                <form id="searchForm" method="post" class="form-inline search_area">
                    <div class="form-group">
                        <label class="sr-only" for="searchTextID">搜索</label>
                        <input class="form-control" id="searchTextID" type="text" name="searchText" placeholder="请输入信息并点击搜索按钮"/>
                        <button class="btn btn-default" id="searchButtonID" type="button" name="searchButton">搜索</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-xs-12 text-center table-responsive">
                <table class="table table-bordered" id="showTable">
                    <tr class="active" id="table_title">
                        <td>学号</td>
                        <td>姓名</td>
                        <td>班级</td>
                        <td>性别</td>
                        <td>宿舍</td>
                        <td>专业</td>
                        <td>电话</td>
                        <td>照片</td>
                        <td>操作</td>
                    </tr>
                    <%--<tr class="displayRow">
                        <td class="stuNo">180804122</td>
                        <td class="stuName">王腾蛟</td>
                        <td class="stuClass">1808041</td>
                        <td class="stuSex">男</td>
                        <td class="stuDorm">10407</td>
                        <td class="stuDepart">软件工程</td>
                        <td class="stuTel">13813894793</td>
                        <td>
                            <img src="images/boy.jpg" />
                        </td>
                        <td>
                            <div class="row">
                                <button class="btn btn-default updateButton" type="button">修改</button>
                            </div>
                            <div class="row">
                                <button class="btn btn-default deleteButton" type="button">删除</button>
                            </div>
                        </td>
                    </tr>--%>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-xs-4 text-right">
                    <button class="btn btn-default" id="preButtonID" type="button">上一页</button>
            </div>
            <div class="col-md-4 col-xs-4 text-center">
                    <button class="btn btn-default" id="insertButtonID" type="button">新增</button>
            </div>
            <div class="col-md-4 col-xs-4 text-left">
                    <button class="btn btn-default" id="nextButtonID" type="button">下一页</button>
            </div>
        </div>
    </div>
</body>
</html>
