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
<%@include file="../common.jsp" %>
</head>
<link href="assets/easyui/thems/bootstrap/easyui.css" rel="stylesheet" />
<body class="easyui-layout">
	<%@include file="../toppage.jsp" %>
	<div id="wrapper" style="margin-top: 50px;">
		<table id="dg"></table>
	<%@include file="../copyrightpage.jsp" %>
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
	<script type="text/javascript" src="assets/easyui/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="assets/easyui/js/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
		function addTab(title, url){
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:95%;"></iframe>';
				$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}
	</script>
	<div data-options="region:'north',border:false" style="height:50px;background:#B3DFDA;padding:10px"></div>
	<div data-options="region:'west',split:true,title:'系统导航'" style="width:200px;padding:10px;">
		<br/><button type="button" onclick="addTab('主页', '')" class="btn btn-success btn-lg btn-block">系统主页</button>
		<br/><button type="button" onclick="addTab('考生管理','manageuser')" class="btn btn-success btn-lg btn-block">考生管理</button>
		<br/><button type="button" onclick="addTab('科目一题库管理','managequestion1')" class="btn btn-success btn-lg btn-block">科目一题库管理</button>
		<br/><button type="button" onclick="addTab('科目四题库管理','managequestion4')" class="btn btn-success btn-lg btn-block">科目四题库管理</button>
	</div>
	<div data-options="region:'center',title:'老司机驾考系统后台管理'">
		<div id="tt" class="easyui-tabs" style="width:100%;height:100%;">
			<div title="主页" style="padding:20px;display:none;">
				<div class="row">
					<div class="col-md-4">
						<div class="main-box mb-green" align="center">
							<a href="javascript:addTab('考生管理','manageuser')"> <i
								class="fa fa-users fa-5x"></i>
								<h5>考生管理</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-orange" align="center">
							<a href="javascript:addTab('科目一题库管理','managequestion1')"> <i
								class="fa fa-database fa-5x"></i>
								<h5>科目一题库管理</h5> </a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="main-box mb-yellow" align="center">
							<a href="javascript:addTab('科目四题库管理','managequestion4')"> <i class="fa fa-database fa-5x"></i>
								<h5>科目四题库管理</h5> </a>
						</div>
					</div>
				</div>
	  		</div>
		</div>
	</div>
</body>
</html>
