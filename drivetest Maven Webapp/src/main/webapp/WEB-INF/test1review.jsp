<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"><head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Driver Test</title>
    <%@include file="common.jsp" %>
</head>
<style>
	fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver}
	legend{border:0;width:auto;font-size: 16px;margin: 0px 2px 0px 5px;}
</style>
<body>
    <%@include file="toppage.jsp" %>
    <div id="wrapper" style="margin-top: 50px;">
        <!-- /. NAV TOP  -->
        <jsp:include page="leftmenu.jsp">
        	<jsp:param value="test1Review" name="menuactive"/>
        </jsp:include>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <i class="fa fa-arrow-circle-o-right fa-2x" style="color: gray;margin-top: 3px;">&nbsp;科目一复习</i>
                        <h5 class="page-subhead-line"></h5>
                    </div>
                </div>
                <!-- /. ROW  -->
              <div class="row">
              	<div class="col-md-9">
              		<fieldset style="height: 300px;">
					    <legend>考试题目</legend>
					    <div class="col-md-6" id="title"></div>
					    <div class="col-md-6" id="image" align="right"></div>
					</fieldset>
					<fieldset>
						  <legend>题目选项(单选)</legend>
						  <div align="right" id="option" style="height: 20px;"></div>
					</fieldset>
              	</div>
              	<div class="col-md-3">
              		<fieldset style="height: 360px;">
					    <legend>试题详解</legend>
					    <div style="margin-left: 5px;" id="ts">
					    </div>
					    <div style="margin-left: 5px" id="xq">
					    </div>
					</fieldset>
              	</div>
              </div>
                <!-- /. ROW  -->
                <div class="row">
                	<div class="col-md-12">
              		<fieldset>
					    <legend>答题信息</legend>
					    <div id="number" style="text-align: center; max-height: 170px;" class="row pre-scrollable"></div>
					</fieldset>
              	</div>
                </div>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    	</div>
    	<%@include file="copyrightpage.jsp" %>
    <!-- /. WRAPPER  -->

    
    <!-- 放大图片模态框 -->
    ﻿<div id="showImage" class="modal">         
         <div class="modal-body">
             <button data-dismiss="modal" class="close" type="button"><span class="glyphicon glyphicon-remove"></span></button>
            <div id="img_show"></div>
         </div>
    </div>
	<!-- 试卷生成提示模态框 -->
	﻿<div id="showPaperTikit" class="modal" data-backdrop="static" data-keyboard="false">         
         <div class="modal-body">
			<div align="center" style="margin-top: 200px;"><img alt="" src="assets/img/load.gif"><div style="color: #fff;"><h3>小编正在为您疯狂出题中,请稍候......</h3></div></div>
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
	var errorItem = 0;//被选错答案个数
	$(function(){
		setInterval(function() {
	    var now = (new Date()).toLocaleString();
		    $('#current-time').text(now);
		}, 1000);
		createPaperOne();
		showQuestionItem();
	})
	//放大效果图
	function biggerImage(imgUrl){
		$("#showImage").find("#img_show").html("<a href='javascript:smallImage()' title='点击缩小效果图'><img src='"+imgUrl+"' class='carousel-inner img-responsive img-rounded' />");//
        $("#showImage").modal();
	}
	//缩小效果图
	function smallImage(){
		$("#showImage").modal('toggle');
	}
	//出题等待提示框
	function waitPaper(args){
		$("#showPaperTikit").modal(args);
	}
	//科目一模拟模块请求
	function createPaperOne(){
	   waitPaper("show");
		$.ajax({
			type:"post",
			url:"createReviewPaper1",
			data:null,
			success:function(data){
				var dataObj=eval("("+data+")");
				//加载题目信息
				var quesTotalSize = dataObj[0].totalSize;
				showQuestionItem(quesTotalSize);
				showAnswerItem(dataObj);
				waitPaper("toggle");
			}
		});
	}
	//题目序号展示
	function showQuestionItem(totalSize){
		var button = "<table align='center'><tr>";
		for(var i = 1;i <= totalSize;i++){
			button+="<td><button type='button' class='btn btn-default btn-sm' style='margin: 2px; width:43px;height:30px;'>"+i+"</button><td>";
			if(i % 20 == 0){
				i++;
				if(i <= totalSize){
					button+="</tr><tr><td><button type='button' class='btn btn-default btn-sm' style='margin: 2px;width:43px;height:30px;'>"+i+"</button><td>";
				}
			}
		}
		button+="</tr></table>"
		$('#number').html(button);
	}
	//选择一项答案
	function selectAnswer(id,answer,chooseItem,explain){
					if(answer == chooseItem){
							$('#number').find('button').eq(id-1).attr("class","btn btn-success btn-sm");
							nextQuestion1(id+1);
					}else{
							$('#ts').html("<div style='margin-left:5px;'>提示&nbsp;:&nbsp<span style='color:red'>错误</span></div>");
							$('#xq').html("<div style='margin-left:5px;'>详情&nbsp;:&nbsp"+explain+"</div>");
							$('#option').find('button').eq(chooseItem-1).attr("class","btn btn-danger btn-sm");
							$('#number').find('button').eq(id-1).attr("class","btn btn-danger btn-sm");
							$('#option').find('button').attr("disabled",true);
							$('#option').find('button:last').attr("disabled",false);
							return;
					}
	}
	function nextQuestion1(id){
		$('#ts').html("");
		$('#xq').html("");
		$('#option').find('button').attr("disabled",false);
		$.ajax({
				type:"post",
				url:"chooseOneQuestion1",
				data:{"question1Id":id},
				success:function(data){
					//加载题目信息
					var dataObj=eval("("+data+")");
					showAnswerItem(dataObj);
				}
			});
	}
	//展示答案选项
	function showAnswerItem(dataObj){
		var title = "<h4 style='font-weight: bolder;'>"+dataObj[0].question1Id+"/"+dataObj[0].totalSize+"、"+dataObj[0].question1Question+"</h4>";
				title += "<h4 style='margin-left: 20px;'>A、"+dataObj[0].question1Item1+"</h4>";
				title += "<h4 style='margin-left: 20px;'>B、"+dataObj[0].question1Item2+"</h4>";
				if(dataObj[0].question1Item3 != ""){
					title += "<h4 style='margin-left: 20px;'>C、"+dataObj[0].question1Item3+"</h4>";
					title += "<h4 style='margin-left: 20px;'>D、"+dataObj[0].question1Item4+"</h4>";
				}
				$('#title').html(title);
				//加载图片信息
				if(dataObj[0].question1Url != ""){
					var img = "<a href=\"javascript:biggerImage(\'../question1/"+dataObj[0].question1Url+"\')\" title='点击放大效果图'><img src='../question1/"+dataObj[0].question1Url+"' class='img-thumbnail' style='width:250px;max-height:265px;'></a>"
					$('#image').html(img);
				}else{
					$('#image').html("");
				}
				//加载选项信息
				var option = "<button type='button' onclick=\"selectAnswer("+dataObj[0].question1Id+",\'"+dataObj[0].question1Answer+"\',1,\'"+dataObj[0].question1Explains+"\')\" class='btn btn-default btn-sm' style='margin-right: 20px;margin-left: 50px;'>A</button>";
				option+="<button type='button' onclick=\"selectAnswer("+dataObj[0].question1Id+",\'"+dataObj[0].question1Answer+"\',2,\'"+dataObj[0].question1Explains+"\')\" class='btn btn-default btn-sm' style='margin-right: 20px;'>B</button>";
				if(dataObj[0].question1Item3 != ""){
					option+="<button type='button' onclick=\"selectAnswer("+dataObj[0].question1Id+",\'"+dataObj[0].question1Answer+"\',3,\'"+dataObj[0].question1Explains+"\')\" class='btn btn-default btn-sm' style='margin-right: 20px;'>C</button>";
					option+="<button type='button' onclick=\"selectAnswer("+dataObj[0].question1Id+",\'"+dataObj[0].question1Answer+"\',4,\'"+dataObj[0].question1Explains+"\')\" class='btn btn-default btn-sm' style='margin-right: 20px;'>D</button>";
				}
				option+="<button type='button' class='btn btn-primary btn-sm' style='margin-left: 20px;' onclick=\"nextQuestion1("+(dataObj[0].question1Id+1)+")\">下一题</button>";
				option+="&nbsp;<a href='javascript:void(0)' onclick=\"collect(this,"+dataObj[0].question1Id+")\" class='btn btn-default btn-sm' title='收藏'><i class='fa fa-star-o'>&nbsp;收藏</i></a>";
				$('#option').html(option);
	}
	
	//收藏
	function collect(obj,id){
		var temp = $(obj).find("i").attr("class");
		if(temp == 'fa fa-star-o'){
			$(obj).find("i").attr("class","fa fa-star");
			$(obj).find("i").html("");
			$(obj).find("i").html("&nbsp;取消收藏");
		}else{
			$(obj).find("i").attr("class","fa fa-star-o");
			$(obj).find("i").html("");
			$(obj).find("i").html("&nbsp;收藏");
			$.ajax({
				type : 'POST',
				url : 'collectQuestion',
				data : {qid:id,type:1},
				success : function(data){
					
				}
			});
		}
	}
</script>
</html>
