<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>学生管理系统——新增学生信息</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css" type="text/css"/>
    <link href="css/insert.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="js/insert.js"></script>
</head>
<body>
    <div class="container">
        <div class="row" id="whole">
            <div class="col-md-12 col-xs-12">
                <form id="insertForm" method="post" >
                    <div class="row">
                        <div class="form-group">
                            <label for="stuNoText">学号：</label>
                            <input type="text" class="form-control" id="stuNoText" name="stuNoText" placeholder="请输入学号">
                        </div>
                        <div class="form-group">
                            <label for="stuNameText">姓名：</label>
                            <input type="text" class="form-control" id="stuNameText" name="stuNameText" placeholder="请输入姓名">
                        </div>
                        <div class="form-group">
                            <label for="stuClassText">班级：</label>
                            <input type="text" class="form-control" id="stuClassText" name="stuClassText" placeholder="请输入班级">
                        </div>
                        <div class="form-group">
                            <label>性别：</label>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="stuSexRadio" id="maleRadio" value="男" checked>
                                    男
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="stuSexRadio" id="femaleRadio" value="女">
                                    女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="stuDormText">宿舍：</label>
                            <input type="text" class="form-control" id="stuDormText" name="stuDormText" placeholder="请输入宿舍编号">
                        </div>
                        <div class="form-group">
                            <label for="stuDepartText">专业：</label>
                            <input type="text" class="form-control" id="stuDepartText" name="stuDepartText" placeholder="请输入专业">
                        </div>
                        <div class="form-group">
                            <label for="stuTelText">电话：</label>
                            <input type="text" class="form-control" id="stuTelText" name="stuTelText" placeholder="请输入电话">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 col-xs-6 text-right">
                            <button class="btn btn-info saveButton" type="button">确定</button>
                        </div>
                        <div class="col-md-6 col-xs-6 text-left">
                            <button class="btn btn-danger backButton" type="button">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>