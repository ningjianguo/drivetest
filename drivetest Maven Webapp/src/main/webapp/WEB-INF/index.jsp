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
<title>老司机驾考系统</title>
<%@include file="common.jsp" %>
</head>
<body>
	<%@include file="toppage.jsp" %>
	<div id="wrapper" style="margin-top: 50px;">
		<!-- /. NAV TOP  -->
		<jsp:include page="leftmenu.jsp">
			<jsp:param value="index" name="menuactive"/>
		</jsp:include>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<i class="fa fa-arrow-circle-o-right fa-2x"
							style="color: gray;margin-top: 3px;">&nbsp;导航中心</i>
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
							<a href="test1Review"> <i
								class="fa fa-book fa-5x"></i>
								<h5>科一复习</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-yellow" align="center">
							<a href="mygrade"> <i class="fa fa-graduation-cap fa-5x"></i>
								<h5>我的成绩</h5> </a>
						</div>
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-4">
						<div class="main-box mb-litte-green" align="center">
							<a href="driverTest4"> <i
								class="fa fa-pencil-square-o fa-5x"></i>
								<h5>科四模拟</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-zi" align="center">
							<a href="test4Review"> <i class="fa fa-book fa-5x"></i>
								<h5>科四复习</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-blue" align="center">
							<a href="personSetting"> <i class="fa fa-cogs fa-5x"></i>
								<h5>个人设置</h5> </a>
						</div>
					</div>
				</div>
				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
		<%@include file="copyrightpage.jsp" %>
	</div>
	<!-- /. WRAPPER  -->
	<!-- /. FOOTER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>
</body>
</html>
