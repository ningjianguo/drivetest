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
<!-- JQUERY SCRIPTS -->
<script src="assets/js/jquery-1.10.2.js"></script>
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
				<a class="navbar-brand fa fa-taxi" href="index">&nbsp;DRIVER
					TEST</a>
			</div>

			<div class="header-right">
				<span id="current-time" style="float: left;font-weight: bolder;margin-right: 15px;margin-top: 10px;"></span>
				<a href="message-task.html" class="btn btn-info" title="New Message"><i
					class="fa fa-envelope-o fa-2x"></i>&nbsp;邮件列表</a> <a href="loginOut"
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
								欢迎你，${user.userName} <br />
							</div>
						</div>
					</li>
					<li><a class="active-menu" href="index"><i
							class="fa fa-dashboard "></i>主页</a>
					</li>

					<li><a href="driverTest1"><i
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
						<div class="main-box mb-green" align="center">
							<a href="driverTest1"> <i
								class="fa fa-pencil-square-o fa-5x"></i>
								<h5>科一模拟</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-orange" align="center">
							<a href="analogtest.html"> <i
								class="fa fa-pencil-square fa-5x"></i>
								<h5>模拟练习</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-yellow" align="center">
							<a href="mygrade.html"> <i class="fa fa-graduation-cap fa-5x"></i>
								<h5>我的成绩</h5> </a>
						</div>
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-4">
						<div class="main-box mb-litte-green" align="center">
							<a href="drivertest4.html"> <i
								class="fa fa-pencil-square-o fa-5x"></i>
								<h5>科四模拟</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-zi" align="center">
							<a href="testreview.html"> <i class="fa fa-book fa-5x"></i>
								<h5>试题复习</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-blue" align="center">
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
					<form class="form-horizontal" id="loginForm" action="login" method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="userAccountName" name="userAccountName"
									placeholder="请输入用户名">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="userAccountPassword" name="userAccountPassword"
									placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">身&nbsp;&nbsp;&nbsp;份:</label>
							<div class="col-sm-10">
								<label class="radio-inline">
								  <input type="radio" name="userRole"  checked="checked" id="inlineRadio1" value="0">普通用户
								</label>
								<label class="radio-inline">
								  <input type="radio" name="userRole" id="inlineRadio2" value="1">管理员
								</label>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<span style="font-size: large; color: red;margin-right: 100px;" id="errinfo"></span>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-info" onclick="loginFormSubmit()">登录</button>
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
					<form class="form-horizontal" id="registeForm">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="_userAccountName" name="userAccountName"
									placeholder="不少于4个字符">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="_userAccountPassword" name="userAccountPassword"
									placeholder="不少于6个字符">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;名:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="_userName" name="userName"
									placeholder="例 :张小明    (选填)">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;箱:</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="_userEmail" name="userEmail"
									placeholder="例 :1195726908@qq.com   (选填)">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<span style="font-size: large; color: red;margin-right: 100px;" id="_errinfo"></span>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-info" onclick="registeFormSubmit()">注册</button>
				</div>
			</div>
		</div>
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
	//登录表单提交
	function loginFormSubmit(){
		var userAccountName = $('#userAccountName').val().replace(/[ ]/g,"");
		var userAccountPassword = $('#userAccountPassword').val().replace(/[ ]/g,"");
		if(userAccountName==""){
			$('#errinfo').text("请输入用户名!");
		}else if(userAccountPassword==""){
			$('#errinfo').text("请输入密码!");
		}else{
			//ajax异步提交表单
			$.ajax({
				type:"post",
				url:"login",
				data:$('#loginForm').serialize(),
				success:function(data){
					if(data == "fail"){
						$('#errinfo').text("用户名或密码错误!");
					}else{
						window.location.reload();
					}
				}
			})
		}
	}
	//注册表单格式验证
	function validataRegisteForm(){
		var userAccountName = $('#_userAccountName').val().replace(/[ ]/g,"");
		var userAccountPassword = $('#_userAccountPassword').val().replace(/[ ]/g,"");
		var userEmail = $('#_userEmail').val().replace(/[ ]/g,"");
		var myreg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;  
		if(userAccountName.length < 4){
			$('#_errinfo').text("用户名不得少于4位字符!");
		}else if(userAccountPassword.length < 6){
			$('#_errinfo').text("密码不得少于6位字符!");
		}else if(userEmail !=""){
			if(!myreg.test(userEmail)){
				$('#_errinfo').text("邮箱格式有误!");
			}else{
				return true;
			}
		}else{
			return true;
		}
		
	}
	//注册表单提交
	function registeFormSubmit(){
		if(validataRegisteForm()){
			//ajax异步提交表单
			$.ajax({
				type:"post",
				url:"registe",
				data:$('#registeForm').serialize(),
				success:function(data){
					$('#_errinfo').text(data);
				}
			})
		}
	}
</script>
</html>
