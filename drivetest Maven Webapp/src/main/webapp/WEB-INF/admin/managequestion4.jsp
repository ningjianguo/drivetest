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
	<script type="text/javascript" src="assets/js/ajaxfileupload.js"></script>
  </head>
  <script>
   $(function(){
   			$('#dlg').dialog('close');
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
			$('#updateBut').linkbutton({
				iconCls:'icon-edit',
				height:24
			});
			$('#addBut').linkbutton({
				iconCls:'icon-add',
				height:24
			});
			$('#saveBut').linkbutton({
				iconCls:'icon-ok',
				height:24
			});
			$('#cancelBut').linkbutton({
				iconCls:'icon-no',
				height:24
			});
 });
		//加载表格数据
		function loadTable(){
			$('#dg').datagrid({
			        url : 'loadQuestion4',
			        toolbar : '#search',
			        loadMsg : '科目四题库正在加载中...',
			        pageSize : 50,//默认选择的分页是每页20行数据  
					pageList : [ 50,150,250],//可以选择的分页集合  
					nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
					pagination : true,
					height : 510,
					striped : true,
					nowrap: false,
					queryParams : {
						timu : $('#timu').val()
					},
			        columns:[[
			        	{field:'question4Id',hidden:true},
			    		{field:'question4No',title:'试题序号',width:60,align:'center'},
			    		{field:'question4Question',title:'试题题目',width:200,align:'left'},
			    		{field:'question4Answer',title:'试题答案',width:60,align:'center',formatter:formatAnswer},
			    		{field:'question4Item1',title:'试题选项1',width:90,align:'left'},
			    		{field:'question4Item2',title:'试题选项2',width:90,align:'left'},
			    		{field:'question4Item3',title:'试题选项3',width:90,align:'left'},
			    		{field:'question4Item4',title:'试题选项4',width:90,align:'left'},
			    		{field:'question4Explains',title:'试题解释',width:350,align:'left'},
			    		{field:'question4Url',title:'试题图片',width:110,align:'left',formatter:formatImg}
			        ]] 
			    });
		} 
		
	function formatImg(val,row){
		if(val=='' || val==null){
			return '';
		}else{
			return "<img alt='科目四图片' width='100px' height='100px' src='../question4/"+val+"'>";
		}
	}
	
	function formatAnswer(val,row){
		if(val.length > 1){
			var t1 = val.substring(0,1);
			var t2 = val.substring(1,2);
			return formatAnswer(t1,null)+"、"+formatAnswer(t2,null)
		}
		var args;
		switch(val){
			case '1' : args = 'A';break;
			case '2' : args = 'B';break;
			case '3' : args = 'C';break;
			case '4' : args = 'D';break;
		}
		return args;
	}
	
	function cancel(){
		$('#stform').form('reset');
		$('#dlg').dialog('close');
	}
	
	function addQuestion4(){
		if(!$('#stform').form('validate')){//表单验证
				return;
			}  
		$.ajaxFileUpload( {  
		    	type:'POST',
		        url : 'addQuestion4',		//用于文件上传的服务器端请求地址  
		        secureuri : false,          //一般设置为false  
		        fileElementId : 'file',     //文件上传空间的id属性  <input type="file" id="file" name="file" />必须为file  
		        data : $('#stform').serializeArray(),
		        dataType : 'text',          
		        success : function(data) {
		        	data = data.substring(data.indexOf(">")+1,data.lastIndexOf("<"));  
		        	if(data == 'fileerror'){
		        		bottomMessager('错误','文件格式错误');
		        	}else if(data == 'ok'){
		        		$('#dlg').dialog('close');
		        		$('#dg').datagrid('reload');
						bottomMessager('成功','试题添加成功');
		        	}else{
		        		bottomMessager('错误','试题添加失败');
		        	}
		        }  
		    }) ; 
	}
	function editeQuestion1(){
		if(!$('#stform').form('validate')){//表单验证
				return;
			}  
		$.ajaxFileUpload( {  
		    	type:'POST',
		        url : 'editeQuestion4',		//用于文件上传的服务器端请求地址  
		        secureuri : false,          //一般设置为false  
		        fileElementId : 'file',     //文件上传空间的id属性  <input type="file" id="file" name="file" />必须为file  
		        data : $('#stform').serializeArray(),
		        dataType : 'text',          
		        success : function(data) {
		        	data = data.substring(data.indexOf(">")+1,data.lastIndexOf("<"));  
		        	if(data == 'fileerror'){
		        		bottomMessager('错误','文件格式错误');
		        	}else if(data == 'ok'){
		        		$('#dlg').dialog('close');
		        		$('#dg').datagrid('reload');
						bottomMessager('成功','试题编辑成功');
		        	}else{
		        		bottomMessager('错误','试题编辑失败');
		        	}
		        }  
		    }) ; 
	}
	function deleteRow(){
	var ids = [];
	var rows = $('#dg').datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		ids.push(rows[i].question4Id);
	}
	$.messager.confirm('警告', '你确定要删除吗?', function(r){
				if (r){
					$.ajax({
					    type : 'POST',
						url : 'deleteQuestion4',
						data : {delItems:ids.join(';')},
						success : function(data){ 
							if(data == 'ok'){
								$('#dg').datagrid('reload');
								bottomMessager('错误','删除数据成功');
							}else{
								bottomMessager('错误','删除数据失败');
							}
						}
					});
				}
			});
}
	function addQuestion(){
		$('#stform').form('reset');
		$('#saveBut').bind('click', function(){
			addQuestion4();
   		 });
		$('#dlg').dialog({closed:false,title:'添加试题'});
	}
	
	function editeQuestion(){
		$('#stform').form('reset');
		$('#saveBut').bind('click', function(){
			editeQuestion1();
   		 });
		var rows = $('#dg').datagrid('getSelections');
		if(rows.length == 0){
			bottomMessager('错误','请选择需要编辑的行');
			return;
		}
		if(rows.length > 1){
			bottomMessager('错误','一次只能编辑一道试题');
			return;
		}
		$('#stform').form('load',{
				question4Question : rows[0].question4Question,
				question4Item1 : rows[0].question4Item1,
				question4Item2 : rows[0].question4Item2,
				question4Item3 : rows[0].question4Item3,
				question4Item4 : rows[0].question4Item4,
				question4Explains : rows[0].question4Explains,
				question4Answer : rows[0].question4Answer
			});
		$("input[name='question4Id']").val(rows[0].question4Id);
		$("input[name='question4No']").val(rows[0].question4No);
		$("input[name='question4Url']").val(rows[0].question4Url);
		$('#dlg').dialog({closed:false,title:'编辑试题'});
	}
	
	function bottomMessager(title,msg){
		$.messager.show({
					title:title,
					msg:msg,
					showType:'show'
		});
	}
  </script>
  <body>
    <table id="dg"></table>
    <div id="dlg" align="center" class="easyui-dialog" data-options="iconCls:'icon-save',modal:true" style="width:600px;height:500px;padding:10px;font-size: 15px;">
				<form id="stform">
					<input name="question4Id" type="hidden" />
					<input name="question4No" type="hidden" />
					<input name="question4Url" type="hidden" />
					<div>
						题&nbsp;&nbsp;&nbsp;&nbsp;目&nbsp;&nbsp;<input class="easyui-textbox" name="question4Question" data-options="prompt:'请输入题目...',multiline:true,required: true,missingMessage:'请输入题目'" style="width:85%;height:60px"/>
					</div>
					<div style="margin-top: 8px;">
						选项一&nbsp;&nbsp;<input class="easyui-textbox" name="question4Item1"  data-options="prompt:'请输入选项一内容...',required: true,missingMessage:'请输入选项一'" style="width:85%;height:28px">
					</div>
					<div style="margin-top: 8px;">
						选项二&nbsp;&nbsp;<input class="easyui-textbox" name="question4Item2"  data-options="prompt:'请输入选项二内容...',required: true,missingMessage:'请输入选项二'" style="width:85%;height:28px">
					</div>
					<div style="margin-top: 8px;">
						选项三&nbsp;&nbsp;<input class="easyui-textbox" name="question4Item3"  data-options="prompt:'请输入选项三内容...'" style="width:85%;height:28px">
					</div>
					<div style="margin-top: 8px;">
						选项四&nbsp;&nbsp;<input class="easyui-textbox" name="question4Item4"  data-options="prompt:'请输入选项四内容...'" style="width:85%;height:28px">
					</div>
					<div style="margin-top: 8px;">
						解&nbsp;&nbsp;&nbsp;&nbsp;释&nbsp;&nbsp;<input class="easyui-textbox" name="question4Explains"  data-options="prompt:'请输入试题正确解释...',multiline:true,required: true,missingMessage:'请输入正确解释'" style="width:85%;height:100px"/>
					</div>
					<div style="margin-top: 8px;">
						答&nbsp;&nbsp;&nbsp;&nbsp;案&nbsp;&nbsp;
						<select class="easyui-combobox" name="question4Answer" style="width:85%;height:28px" data-options="editable:false,panelHeight:'auto',multiple:true,separator:'、'">
							<option value="1">A</option>
							<option value="2">B</option>
							<option value="3">C</option>
							<option value="4">D</option>
						</select>
					</div>
					<div style="margin-top: 8px;">
						<span style="float: left;margin-left: 15px;">图&nbsp;&nbsp;&nbsp;&nbsp;片&nbsp;&nbsp;</span><input type="file" id="file" name="file" style="width:85%;height:28px;float: left">
					</div>
					<div>
						<span style="float: left;margin-left: 65px;">允许.jpg、.jpeg、.png为后缀的文件上传</span>
					</div>
					<div style="margin-top: 10px;">
						<a href="javascript:void(0)" id="saveBut">保存</a>
						&nbsp;&nbsp;
						<a href="javascript:void(0)" id="cancelBut" onclick="cancel()">取消</a>
					</div>
				</form>
	</div>
    <div id="search">
			<table>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;题目:</td>
					<td>
						<input type="text" class="easyui-textbox" id="timu" name="timu" value=""/>
					</td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="queryBut" onclick="loadTable()">查询</a></td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="updateBut" onclick="editeQuestion()">编辑</a></td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="addBut" onclick="addQuestion()">添加</a></td>
					<td>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="deleteBut" onclick="deleteRow()">删除</a></td>
				</tr>
			</table>
		</div>
  </body>
</html>
