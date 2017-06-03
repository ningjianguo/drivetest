<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>manageuser</title>
	<%@include file="../common.jsp" %>
	<link rel="stylesheet" href="assets/easyui/thems/bootstrap/easyui.css" />
	<link rel="stylesheet" href="assets/easyui/css/icon.css" />
	<link rel="stylesheet" href="assets/easyui/css/color.css" />
	<link rel="stylesheet" href="assets/easyui/css/user_defined.css" />
	<script type="text/javascript" src="assets/easyui/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="assets/easyui/js/easyui-lang-zh_CN.js"></script>
  </head>
  <script>
   $(function(){
			loadTable();
			//-------------------------------查询控件添加-------------------------------
			$('#queryBut').linkbutton({
				iconCls:'icon-search',
				height:24
			});
			$('#deleteBut').linkbutton({
				iconCls:'icon-remove',
				height:24
			});
			$('#resetBut').linkbutton({
				iconCls:'icon-resetpsw',
				height:24
			});
	 });
		//加载表格数据
		function loadTable(){
			$('#dg').datagrid({
			        url : 'loadAllStuInfos',
			        toolbar : '#search',
			        loadMsg : '考生信息正在加载中...',
			        pageSize : 5,//默认选择的分页是每页5行数据  
					pageList : [ 5,7,9],//可以选择的分页集合  
					nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
					pagination : true,
					height : 510,
					striped : true,
					queryParams : {
						userAccountName : $('#userAccountName').val(),
						userName : $('#userName').val()
					},
			        columns:[[
			        	{field:'userId',checkbox:true},
			    		{field:'userFilePath',title:'考生头像',width:80,align:'center',formatter:formatImg},
			    		{field:'userAccountName',title:'考生账号',width:200,align:'center'},
			    		{field:'userAccountPassword',title:'考生密码(已加密)',width:200,align:'center'},
			    		{field:'userName',title:'考生姓名',width:200,align:'center'},
			    		{field:'userEmail',title:'考生邮箱',width:200,align:'center'},
			        ]] 
			    });
		} 
		
	function formatImg(val,row){
		return "<img alt='用户头像' width='80px' height='80px' src='../images/"+val+"'>";
	}
	
	//重置考生密码
	function resetStuPsw(){
		var ids = [];
		var rows = $('#dg').datagrid('getSelections');
		for(var i=0; i<rows.length; i++){
			ids.push(rows[i].userId);
		}
		$.ajax({
			type : 'POST',
			url : 'resetStuPsw',
			data : {resItems:ids.join(';')},
			success : function(data){ 
			if(data == 'ok'){
			$('#dg').datagrid('reload');
			$.messager.show({
					title:'成功',
					msg:'密码已重置为000000',
					showType:'show'
					});
			}else{
					$.messager.show({
					title:'错误',
					msg:'密码重置失败',
					showType:'show'
					});
				}
			}
		});
	}	
	
	function deleteRow(){
	var ids = [];
	var rows = $('#dg').datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		ids.push(rows[i].userId);
	}
	$.messager.confirm('警告', '你确定要删除吗?', function(r){
				if (r){
					$.ajax({
					    type : 'POST',
						url : 'deleteUser',
						data : {delItems:ids.join(';')},
						success : function(data){ 
							if(data == 'ok'){
								$('#dg').datagrid('reload');
								$.messager.show({
									title:'成功',
									msg:'删除数据成功',
									showType:'show'
								});
							}else{
								$.messager.show({
									title:'错误',
									msg:'删除数据失败',
									showType:'show'
								});
							}
						}
					});
				}
			});
}
  </script>
  <body>
    <table id="dg"></table>
    <div id="search">
			<table>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;用户账号:</td>
					<td>
						<input type="text" class="easyui-textbox" id="userAccountName" name="userAccountName" value=""/>
					</td>
					<td>&nbsp;&nbsp;&nbsp;真实姓名:</td>
					<td>
						<input type="text" class="easyui-textbox" id="userName"  name="userName" value=""/>
					</td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="queryBut" onclick="loadTable()">查询</a></td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="deleteBut" onclick="deleteRow()">删除考生</a></td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="resetBut" onclick="resetStuPsw()">重置考生密码</a></td>
				</tr>
			</table>
		</div>
  </body>
</html>
