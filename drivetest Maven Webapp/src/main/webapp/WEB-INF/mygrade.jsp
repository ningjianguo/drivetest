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
<link rel="stylesheet" href="assets/easyui/thems/bootstrap/easyui.css" />
<link rel="stylesheet" href="assets/easyui/css/icon.css" />
<link rel="stylesheet" href="assets/easyui/css/color.css" />
<link rel="stylesheet" href="assets/easyui/css/user_defined.css" />
</head>
<body>
	<%@include file="toppage.jsp" %>
	<div id="wrapper" style="margin-top: 50px;">
		<!-- /. NAV TOP  -->
		<jsp:include page="leftmenu.jsp">
			<jsp:param value="mygrade" name="menuactive"/>
		</jsp:include>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<i class="fa fa-arrow-circle-o-right fa-2x"
							style="color: gray;margin-top: 3px;">&nbsp;我的成绩</i>
						<h5 class="page-subhead-line"></h5>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<table id="dg"></table>
					</div>
				</div>
				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
		<%@include file="copyrightpage.jsp" %>
		<!-- 表格插件 -->
		<div id="search">
			<table>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;考试类型:</td>
					<td>
						<select id="papertype" name="papertype">
							<option value="-1">全部</option>
							<option value="1">科目一</option>
							<option value="4">科目四</option>
						</select>
					</td>
					<td>&nbsp;&nbsp;&nbsp;考试状态:</td>
					<td>
						<select id="statu" name="statu">
							<option value="-1">全部</option>
							<option value="1">已结卷</option>
							<option value="0">未结卷</option>
						</select>
					</td>
					<td>&nbsp;&nbsp;&nbsp;结束时间:</td>
					<td><input id="time1" type="text" name="time1">~</td>
					<td><input id="time2" type="text" name="time2"></td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="queryBut" onclick="loadTable()">查询</a></td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="deleteBut" onclick="deleteRow()">删除</a></td>
				</tr>
			</table>
		</div>
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
	<script type="text/javascript" src="assets/easyui/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="assets/easyui/js/easyui-lang-zh_CN.js"></script>
</body>
<script type="text/javascript">
	//--------------------------------初始化参数--------------------------------
	$(function(){
	//--------------------------------初始化表格开始-----------------------------
		loadTable();
	 //-------------------------------初始化表格结束-----------------------------
	 
	 //-------------------------------查询控件添加-------------------------------
	 $('#papertype,#statu').combobox({
	 	height:25,
	 	width:150,
	 	editable:false,
	 	panelHeight:'auto'
	 });  
	 $('#time1,#time2').datetimebox({
	 		height:25,
	 		width:150,
	 		editable:false,
		    formatter:function(date){
		    	var y = date.getFullYear();
				var m = date.getMonth()+1;
				var d = date.getDate();
				if(m<10){m = "0"+m;}
				if(d<10){d = "0"+d;}
				return y+'-'+m+'-'+d;
		    }
	});
	$('#queryBut').linkbutton({
		iconCls:'icon-search',
		height:24
	});
	$('#deleteBut').linkbutton({
		iconCls:'icon-remove',
		height:24
	});
});

//加载表格数据
function loadTable(){
	$('#dg').datagrid({
	        url : 'loadAllGrade',
	        toolbar : '#search',
	        loadMsg : '成绩正在加载中...',
	        pageSize : 15,//默认选择的分页是每页5行数据  
			pageList : [ 5, 15],//可以选择的分页集合  
			nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
			pagination : true,
			height : 470,
			striped : true,
			queryParams : {
				papertype : $('#papertype').val(),
			    statu : $('#statu').val(),
			    time1 : $('#time1').val(),
			    time2 : $('#time2').val()
			},
	        columns:[[
	    		{field:'paperNum',checkbox:true},
	    		{field:'paperTempNum',title:'试卷编号',width:160,align:'left'},
	    		{field:'paperType',title:'试卷类型',width:90,align:'center',formatter:formatPaperType},
	    		{field:'selectedCount',title:'答题数(道)',width:90,align:'center'},
	    		{field:'paperScore',title:'试卷分数(分)',width:90,align:'center'},
	    		{field:'trueRate',title:'正确率',width:90,align:'center'},
	    		{field:'selectedRate',title:'完成率',width:90,align:'center'},
	    		{field:'endTime',title:'结束时间',width:130,align:'center'},
	    		{field:'totalTime',title:'总用时',width:100,align:'center'},
	    		{field:'grade',title:'成绩评定',width:90,align:'center',formatter:formatGrade},
	    		{field:'testStatu',title:'考试状态',width:120,align:'left',formatter:formatTestStatu}
	        ]]
	    });
}

function formatPaperType(val,row){
	if(val==1){
		return "科目一";
	}else{
		return "科目四";
	}
}

function formatGrade(val,row){
	if(val==1){
		return "成绩合格";
	}else{
		return "未及格";
	}
}

function formatTestStatu(val,row){
	if(val==1){
		return "已结卷";
	}else{
		return "未结卷&nbsp;(<a href=\"againTest?paper1Number="+row.paperNum+"\">再考一次</a>)";
	}
}

function deleteRow(){
	var ids = [];
	var rows = $('#dg').datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		ids.push(rows[i].paperNum);
	}
	$.messager.confirm('警告', '你确定要删除吗?', function(r){
				if (r){
					$.ajax({
					    type : 'POST',
						url : 'deleteGrade',
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
</html>
