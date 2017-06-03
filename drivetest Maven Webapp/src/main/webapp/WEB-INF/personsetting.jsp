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
<link href='assets/css/fileinput.min.css' rel='stylesheet' type='text/css' />
</head>
<body>
	<%@include file="toppage.jsp" %>
	<div id="wrapper" style="margin-top: 50px;">
		<!-- /. NAV TOP  -->
		<jsp:include page="leftmenu.jsp">
			<jsp:param value="personSetting" name="menuactive"/>
		</jsp:include>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<i class="fa fa-arrow-circle-o-right fa-2x"
							style="color: gray;margin-top: 3px;">&nbsp;个人设置</i>
							 <div id="myAlert" style="display: none" class="alert alert-success">
									<a href="#" class="close" data-dismiss="alert">&times;</a>
									<strong>成功！</strong>结果保存成功。
								</div>
						<h5 class="page-subhead-line"></h5>
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-12">
						<form class="form-horizontal" align="center" id="userForm">
						  <div class="form-group">
						    <label for="userAccountName" class="col-sm-3 control-label">账号:</label>
						    <div class="col-sm-3">
						      <input type="text" class="form-control" name="userAccountName" id="userAccountName" value="${user.userAccountName}" readonly>
						    </div>
						     <label for="userName" class="col-sm-1 control-label">姓名:</label>
						    <div class="col-sm-3">
						      <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="userAccountPassword" class="col-sm-3 control-label">密码:</label>
						    <div class="col-sm-3">
						      <input type="password" class="form-control" id="userAccountPassword" name="userAccountPassword" value="${user.userAccountPassword}">
						    </div>
						    <label for="userEmail" class="col-sm-1 control-label">邮箱:</label>
						    <div class="col-sm-3">
						      <input type="text" class="form-control" id="userEmail" name="userEmail" value="${user.userEmail}">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="file" class="col-sm-3 control-label">头像:</label>
						    <div class="col-sm-3">
							    <input id="file" type="file" name="file" multiple>
								<p class="help-block">只允许上传后缀为.png、.jpg格式的照片</p>
						    </div>
						    <div class="col-sm-6" align="center" style="margin-top: 100px;">
						      <button type="button" onclick="submitForm()" class="btn btn-info">保存</button>
						      &nbsp;
						      <button type="button" onclick="toIndex()" class="btn btn-default">取消</button>
						    </div>
						  </div>
						</form>
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
	<script type="text/javascript" src="assets/js/fileinput.min.js"></script>
	<script type="text/javascript" src="assets/js/zh.js"></script>
	<script type="text/javascript" src="assets/js/ajaxfileupload.js"></script>
</body>
<script type="text/javascript">
	$(function(){
		//初始化提示信息
		$("#myAlert").hide();
		//初始化上传文件控件
		$('#file').fileinput({
			    language: 'zh', //设置语言
                allowedFileExtensions : ['jpg', 'png'],//接收的文件后缀,
                maxFileCount: 1,
                enctype: 'multipart/form-data',
                showUpload: false, //是否显示上传按钮
                showCaption: true,//是否显示标题
                browseClass: "btn btn-primary", //按钮样式             
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
                maxFileSize : 1048576,//单位为kb，如果为0表示不限制文件大小
		});
		$(".close").click(function(){
				$("#myAlert").alert();
			});
	});
	
	//文件表单上传
	function submitForm(){
		$.ajaxFileUpload( {  
		    	type:'POST',
		        url : 'updUserInfo',		//用于文件上传的服务器端请求地址  
		        secureuri : false,          //一般设置为false  
		        fileElementId : 'file',     //文件上传空间的id属性  <input type="file" id="file" name="file" />必须为file  
		        data : $('#userForm').serializeArray(),
		        dataType : 'text',          
		        success : function(data) {
		        	data = data.substring(data.indexOf(">")+1,data.lastIndexOf("<"));  
		        	if(data == 'ok'){
		        		$("#myAlert").show();
		        	}
		        }  
		    }) ; 
	}
	
	//前往首页
	function toIndex(){
		$('#showReturnPaper').modal('toggle');
		window.location.href="<%=basePath%>index";
	}
</script>
</html>