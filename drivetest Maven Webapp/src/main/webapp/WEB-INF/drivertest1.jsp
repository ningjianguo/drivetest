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
    <title>老司机驾考系统</title>
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
        	<jsp:param value="drivetest1" name="menuactive"/>
        </jsp:include>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <i class="fa fa-arrow-circle-o-right fa-2x" style="color: gray;margin-top: 3px;">&nbsp;科目一模拟</i>
                        <h5 class="page-subhead-line"></h5>
                    </div>
                </div>
                <!-- /. ROW  -->
              <div class="row">
              	<div class="col-md-3">
              		<fieldset style="height: 300px;">
					    <legend>考生信息</legend>
					    <table style="text-align: center;" align="center">
					    <tr>
					    	<td colspan="2">
					    	 <img src="../images/${user.userFilepath}" class="img-thumbnail" style="width:128px;height:128px;"/><br/>
					    	</td>
					    </tr>
					    <tr>
					    	<td>考生姓名:</td>
					    	<td>${user.userName}</td>
					    </tr>
					    <tr>
					    	<td>考试题数:</td>
					    	<td>100题</td>
					    </tr>
					    <tr>
					    	<td>考试时间:</td>
					    	<td>45分钟</td>
					    </tr>
					    <tr>
					    	<td>合格标准:</td>
					    	<td>满分100分</td>
					    </tr>
					    <tr>
					    	<td></td>
					    	<td>90分及格</td>
					    </tr>
					    </table>
					</fieldset>
					<fieldset>
					    <legend>剩余时间</legend>
					    <div align="center" style="font-size: x-large;font-weight: bolder;height: 20px;" id="currentTime"></div>
					</fieldset>
              	</div>
              	<div class="col-md-9">
              		<fieldset style="height: 300px;">
					    <legend>考试题目</legend>
					    <div class="col-md-6" id="title"></div>
					    <div class="col-md-6" id="image" align="right"></div>
					</fieldset>
					<fieldset>
						  <legend>题目选项(单选)</legend>
						  <div align="left" id="option" style="height: 20px;"></div>
					</fieldset>
              	</div>
              	
              </div>
                <!-- /. ROW  -->
                <div class="row">
                	<div class="col-md-12">
              		<fieldset>
					    <legend>答题信息</legend>
					    <div id="number" style="text-align: center; max-height: 100px;" class="row pre-scrollable"></div>
					</fieldset>
              	</div>
                </div>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    <%@include file="copyrightpage.jsp" %>
    </div>
    <!-- /. WRAPPER  -->

    
    <!-- 放大图片模态框 -->
    ﻿<div id="showImage" class="modal">         
         <div class="modal-body">
             <button data-dismiss="modal" class="close" type="button"><span class="glyphicon glyphicon-remove"></span></button>
            <div id="img_show"></div>
         </div>
    </div>
    <!-- 进入考试提示模态框 -->
    <div class="modal fade bs-example-modal-lg" id="showWarning" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div align="center">
						<h3>温馨提示</h3>
						<h5>按交管部门通知，科目一考试系统全面更新。全真模拟考试下不能修改答案，每做一题，系统自动计算错误题数，及格标准为90分。</h5>
						 <button type="button" class="btn btn-info" data-dismiss="modal">确定</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 试卷生成提示模态框 -->
	﻿<div id="showPaperTikit" class="modal" data-backdrop="static" data-keyboard="false">         
         <div class="modal-body">
			<div align="center" style="margin-top: 200px;"><img alt="" src="assets/img/load.gif"><div style="color: #fff;"><h3>小编正在为您疯狂出题中,请稍候......</h3></div></div>
         </div>
    </div>
    <!-- 提交试卷确认模态框 -->
    <div class="modal fade bs-example-modal-sm" id="showSubmitPaper" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div align="center">
						<h5 id="submitTip"></h5>
						 <button type="button" class="btn btn-info" data-dismiss="modal" onclick="submitPaper1()">交卷</button>
					</div>
				</div>
			</div>
		</div>
	</div>
    <!-- 试卷反馈模态框 -->
    <div class="modal fade bs-example-modal-sm" id="showReturnPaper" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div align="center">
						<img class="img-responsive img-rounded" id="img1">
						<table style="border: 0px;cellpadding:10px;" >
							<tr>
								<td>错题:</td><td id="errorNum"></td><td>&nbsp;</td><td>未做题:</td><td id="noSelectedNum"></td>
							</tr>
							<tr>
								<td>总成绩:</td><td id="totalScore"></td><td>&nbsp;</td><td>成绩评定:</td><td id="grade"></td>
							</tr>
							<tr>
								<td><button type="button" class="btn btn-info" data-dismiss="modal" onclick="againTest()">再考一次</button></td>
								<td></td>
								<td></td>
								<td></td>
								<td><button type="button" class="btn btn-default" data-dismiss="modal" onclick="toIndex()">取消</button></td>
							</tr>
						</table>
					</div>
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
	var errorItem = 0;//被选错答案个数
	var paperNumber = "";//试卷编号
	$(function(){
		$('#showWarning').on('hidden.bs.modal', function (e) {
		  testTimeDown();
		}); 
		createPaperOne();
	})
	//考试计时器
	function testTimeDown(){
		var minute = 44;
		var second = 60;
		var ms = "";
		var num = setInterval(function() {
			if(--second <= 9){
				if(second < 0){
					minute--;
					second = 59;
				}
				if(second != 59){
					ms = minute+":0"+second;
				}else{
					ms = minute+":"+second;
				}
			}else{
				ms = minute+":"+second;
			}
			if(minute<10){
				ms = "0"+ms;
				if(minute==0&&second==0){
					clearInterval(num);
					//发送请求
					preSubmitPaper1("答题时间已到，请交卷!");
				}
			}
			$('#currentTime').text(ms);
		}, 1000)
	}
	//放大效果图
	function biggerImage(imgUrl){
		$("#showImage").find("#img_show").html("<a href='javascript:smallImage()' title='点击缩小效果图'><img src='"+imgUrl+"' class='carousel-inner img-responsive img-rounded' />");//
        $("#showImage").modal();
	}
	//缩小效果图
	function smallImage(){
		$("#showImage").modal('toggle');
	}
	//进入页面时弹出警告框
	function showWarning(){
		$("#showWarning").modal('show');
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
			url:"createPaperOne",
			data:null,
			success:function(data){
				var dataObj=eval("("+data+")");
				paperNumber = dataObj[0].paper1Number;
				//加载题目信息
				showAnswerItem(dataObj);
				showQuestionItem();
				waitPaper("toggle");
				showWarning();
			}
		});
	}
	//题目序号展示
	function showQuestionItem(){
		var button = "<table align='center'><tr>";
		for(var i = 1;i <= 100;i++){
			button+="<td><button type='button' class='btn btn-default btn-sm' style='margin: 2px; width:43px;height:30px;'>"+i+"</button><td>";
			if(i % 22 == 0){
				i++;
				if(i <= 100){
					button+="</tr><tr><td><button type='button' class='btn btn-default btn-sm' style='margin: 2px;width:43px;height:30px;'>"+i+"</button><td>";
				}
			}
		}
		button+="</tr></table>"
		$('#number').html(button);
	}
	//选择一项答案
	function selectAnswer(answer,paper1Number,paper1No,chooseItem){
		$.ajax({
			type:"post",
			url:"chooseOneAnswer",
			data:{"paper1Number":paper1Number,"paper1No":paper1No,"paper1Choice":chooseItem},
			success:function(data){
				if(answer == chooseItem){
					$('#number').find('button').eq(paper1No-1).attr("class","btn btn-success btn-sm");
				}else{
					if(++errorItem > 10){
						preSubmitPaper1("您已答错了11题，成绩不合格。请交卷!");
					}
					$('#number').find('button').eq(paper1No-1).attr("class","btn btn-danger btn-sm");
				}
				
				//加载题目信息
				var dataObj=eval("("+data+")");
				paperNumber = dataObj[0].paper1Number;
				showAnswerItem(dataObj);
			}
		});
	}
	//提交试卷
	function preSubmitPaper1(warningInfo){
		if(warningInfo != undefined){
			$('#submitTip').text(warningInfo);
			$('#showSubmitPaper').modal('show');
		}else{
			submitPaper1();
		}
	}
	function submitPaper1(){
		$.ajax({
			type:"post",
			url:"submitPaper1",
			data:{"paper1Number":paperNumber},
			success:function(data){
				var dataObj=eval("("+data+")");
				$('#errorNum').text(dataObj[0]+"道");
				$('#noSelectedNum').text(dataObj[1]+"道");
				$('#totalScore').text(dataObj[2]+"分");
				if(dataObj[2] < 90){
					$('#img1').attr("src","assets/img/malushashou.png");
					$('#grade').text("不合格");
				}else{
					$('#grade').text("合格");
				}
				errorItem = 0;//被选错答案个数
				paperNumber = "";//试卷编号
				$('#showReturnPaper').modal('show');
			}
		});
	}
	//展示答案选项
	function showAnswerItem(dataObj){
		var title = "<h4 style='font-weight: bolder;'>"+dataObj[0].paper1No+"、"+dataObj[0].examQuestion1.question1Question+"</h4>";
				title += "<h4 style='margin-left: 20px;'>A、"+dataObj[0].examQuestion1.question1Item1+"</h4>";
				title += "<h4 style='margin-left: 20px;'>B、"+dataObj[0].examQuestion1.question1Item2+"</h4>";
				if(dataObj[0].examQuestion1.question1Item3 != ""){
					title += "<h4 style='margin-left: 20px;'>C、"+dataObj[0].examQuestion1.question1Item3+"</h4>";
					title += "<h4 style='margin-left: 20px;'>D、"+dataObj[0].examQuestion1.question1Item4+"</h4>";
				}
				$('#title').html(title);
				//加载图片信息
				if(dataObj[0].examQuestion1.question1Url != ""){
					var img = "<a href=\"javascript:biggerImage(\'../question1/"+dataObj[0].examQuestion1.question1Url+"\')\" title='点击放大效果图'><img src='../question1/"+dataObj[0].examQuestion1.question1Url+"' class='img-thumbnail' style='width:250px;max-height:265px;'></a>"
					$('#image').html(img);
				}else{
					$('#image').html("");
				}
				//加载选项信息
				var option = "<button type='button' onclick=\"selectAnswer(\'"+dataObj[0].question1Answer+"\',\'"+dataObj[0].paper1Number+"\',\'"+dataObj[0].paper1No+"\',1)\" class='btn btn-default btn-sm' style='margin-right: 20px;margin-left: 50px;'>A</button>";
				option+="<button type='button' onclick=\"selectAnswer(\'"+dataObj[0].question1Answer+"\',\'"+dataObj[0].paper1Number+"\',\'"+dataObj[0].paper1No+"\',2)\" class='btn btn-default btn-sm' style='margin-right: 20px;'>B</button>";
				if(dataObj[0].examQuestion1.question1Item3 != ""){
					option+="<button type='button' onclick=\"selectAnswer(\'"+dataObj[0].question1Answer+"\',\'"+dataObj[0].paper1Number+"\',\'"+dataObj[0].paper1No+"\',3)\" class='btn btn-default btn-sm' style='margin-right: 20px;'>C</button>";
					option+="<button type='button' onclick=\"selectAnswer(\'"+dataObj[0].question1Answer+"\',\'"+dataObj[0].paper1Number+"\',\'"+dataObj[0].paper1No+"\',4)\" class='btn btn-default btn-sm' style='margin-right: 20px;'>D</button>";
				}
				option+="<button type='button' class='btn btn-primary btn-sm' style='margin-left: 20px;' onclick='preSubmitPaper1()'>交卷</button>";
				$('#option').html(option);
	}
	//重考一次
	function againTest(){
		$('#showReturnPaper').modal('toggle');
		createPaperOne();
	}
	//前往首页
	function toIndex(){
		$('#showReturnPaper').modal('toggle');
		window.location.href="<%=basePath%>index";
	}
</script>
</html>
