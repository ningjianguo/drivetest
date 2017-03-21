<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DRIVE TEST</title>
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
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand fa fa-taxi" href="index.html">&nbsp;DRIVER
					TEST</a>
			</div>

			<div class="header-right">

				<a href="message-task.html" class="btn btn-info" title="New Message"><i
					class="fa fa-envelope-o fa-2x"></i>&nbsp;邮件列表</a> <a href="login.html"
					class="btn btn-danger" title="Logout"><i
					class="fa  fa-sign-out fa-2x"></i>&nbsp;退出系统</a>

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
								欢迎你，小明 <br /> <small><div id="current-time"></div> </small>
							</div>
						</div>
					</li>
					<li><a class="active-menu" href="index.html"><i
							class="fa fa-dashboard "></i>主页</a>
					</li>

					<li><a href="drivertest1.html"><i
							class="fa fa-pencil-square-o "></i>科一模拟 </a>
					</li>
					<li><a href="drivertest4.html"><i
							class="fa fa-pencil-square-o "></i>科四模拟</a>
					</li>
					<li><a href="analogtest.html"><i
							class="fa fa-pencil-square "></i>模拟练习</a>
					</li>
					<li><a href="testreview.html"><i class="fa fa-book "></i>试题复习</a>
					</li>
					<li><a href="mygrade.html"><i
							class="fa fa-graduation-cap "></i>我的成绩</a>
					</li>
					<li><a href="personsetting.html"><i class="fa fa-cogs "></i>个人设置</a>
					</li>
					<li><a href="javascript:void(0)"><i
							class="fa fa-sign-out "></i>退出系统</a>
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
						<i class="fa fa-arrow-circle-o-right fa-4x"
							style="color: gray;margin-top: 3px;">&nbsp;个人中心</i>
						<h5 class="page-subhead-line"></h5>
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-4">
						<div class="main-box mb-green">
							<a href="drivertest1.html"> <i
								class="fa fa-pencil-square-o fa-5x"></i>
								<h5>科一模拟</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-orange">
							<a href="analogtest.html"> <i
								class="fa fa-pencil-square fa-5x"></i>
								<h5>模拟练习</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-yellow">
							<a href="mygrade.html"> <i class="fa fa-graduation-cap fa-5x"></i>
								<h5>我的成绩</h5> </a>
						</div>
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-4">
						<div class="main-box mb-litte-green">
							<a href="drivertest4.html"> <i
								class="fa fa-pencil-square-o fa-5x"></i>
								<h5>科四模拟</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-zi">
							<a href="testreview.html"> <i class="fa fa-book fa-5x"></i>
								<h5>试题复习</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-blue">
							<a href="personsetting.html"> <i class="fa fa-cogs fa-5x"></i>
								<h5>个人设置</h5> </a>
						</div>
					</div>
				</div>
				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->

	<div id="footer-sec" align="center">Copyright &copy; 2017 Hunan
		University Of Humanities,Science And Technology. All Rights Reserved.
	</div>
	<!-- 登录模态框 -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">登录&nbsp;|&nbsp;<a onclick="registeUser()">注册</a></h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="userName"
									placeholder="用户名">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="userPassword"
									placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">身&nbsp;&nbsp;&nbsp;份:</label>
							<div class="col-sm-10">
								<label class="radio-inline">
								  <input type="radio" name="inlineRadioOptions"  checked="checked" id="inlineRadio1" value="option1">普通用户
								</label>
								<label class="radio-inline">
								  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">管理员
								</label>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-info">登录</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 注册模态框 -->
	<div class="modal fade" id="registeModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"><a onclick="loginUser()">登录</a>&nbsp;|&nbsp;注册</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="userName"
									placeholder="用户名">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="userPassword"
									placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;名:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="userPassword"
									placeholder="姓名">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;箱:</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="userPassword"
									placeholder="邮箱">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-info">注册</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /. FOOTER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>
</body>
<script>
	$(function() {
		//实时显示时间
		setInterval(function() {
			var now = (new Date()).toLocaleString();
			$('#current-time').text(now);
		}, 1000);
		isUserLogin();
	})
	//判断用户是否登录
	function isUserLogin() {
		var info = ${loginerr};
		if (info == 0) {
			$('#loginModal').modal('show');
		}
	}
	//切换到注册界面
	function registeUser(){
		$('#loginModal').modal('toggle');
		$('#registeModal').modal('show');
	}
	//切换到登录界面
	function loginUser(){
		$('#registeModal').modal('toggle');
		$('#loginModal').modal('show');
	}
</script>
</html>
