<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Driver Test</title>
    <link rel="icon" href="assets/img/car.ico" type="image/x-icon">
    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
       <!--CUSTOM BASIC STYLES-->
    <link href="assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='assets/css/openSans.css' rel='stylesheet' type='text/css' />
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand fa fa-taxi" href="index.html">&nbsp;DRIVER TEST</a>
            </div>

            <div class="header-right">
				<span id="current-time" style="float: left;font-weight: bolder;margin-right: 15px;margin-top: 10px;"></span>
                <a href="message-task.html" class="btn btn-info" title="New Message"><i class="fa fa-envelope-o fa-2x"></i>&nbsp;邮件列表</a>
                <a href="login.html" class="btn btn-danger" title="Logout"><i class="fa  fa-sign-out fa-2x"></i>&nbsp;退出系统</a>

            </div>
        </nav>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src="assets/img/user.png" class="img-thumbnail" />
                            <div class="inner-text">
                                	欢迎你，${user.userName}
                            <br />
                            </div>
                        </div>

                    </li>
                    <li>
                        <a class="active-menu" href="index.html"><i class="fa fa-dashboard "></i>主页</a>
                    </li>
                    
                    <li>
                        <a href="drivertest1.html"><i class="fa fa-pencil-square-o "></i>科一模拟 </a>
                        
                    </li>
                    <li>
                        <a href="drivertest4.html"><i class="fa fa-pencil-square-o "></i>科四模拟</a>
                    </li>
                    <li>
                        <a href="analogtest.html"><i class="fa fa-pencil-square "></i>模拟练习</a>
                    </li>
                     <li>
                        <a href="testreview.html"><i class="fa fa-book "></i>试题复习</a>
                    </li>
                    <li>
                        <a href="mygrade.html"><i class="fa fa-graduation-cap "></i>我的成绩</a>
                    </li>
                    <li>
                        <a href="personsetting.html"><i class="fa fa-cogs "></i>个人设置</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)"><i class="fa fa-sign-out "></i>退出系统</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                       <!-- <h1 class="page-head-line">DASHBOARD</h1>-->
                        <i class="fa fa-arrow-circle-o-right fa-4x" style="color: gray;margin-top: 3px;">&nbsp;我的成绩</i>
                        <h5 class="page-subhead-line"></h5>
                    </div>
                </div>
                <!-- /. ROW  -->
              
                <!-- /. ROW  -->
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

    <div id="footer-sec" align="center">
	Copyright &copy; 2017 Hunan University Of Humanities,Science And Technology. All Rights Reserved.
    </div>
    <!-- /. FOOTER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
       <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
</body>
<script>
	$(function(){
		setInterval(function() {
	    var now = (new Date()).toLocaleString();
		    $('#current-time').text(now);
		}, 1000);
	})
		
</script>
</html>
