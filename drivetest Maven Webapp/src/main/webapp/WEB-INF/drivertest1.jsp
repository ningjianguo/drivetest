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
    <link href='assets/css/bootstrap-custom.css' rel='stylesheet' type='text/css' />
     <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
</head>
<body>
    <div id="wrapper">
       <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand fa fa-taxi" href="index">&nbsp;DRIVER TEST</a>
            </div>

            <div class="header-right">
				<span id="current-time" style="float: left;font-weight: bolder;margin-right: 15px;margin-top: 10px;"></span>
                <a href="message-task.html" class="btn btn-info" title="New Message"><i class="fa fa-envelope-o fa-2x"></i>&nbsp;邮件列表</a>
                <a href="login.html" class="btn btn-danger" title="Logout"><i class="fa  fa-sign-out fa-2x"></i>&nbsp;退出系统</a>

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
                                	欢迎你，${user.userName}
                            <br />
                            </div>
                        </div>

                    </li>
                    <li>
                        <a href="index"><i class="fa fa-dashboard "></i>主页</a>
                    </li>
                    
                    <li>
                        <a class="active-menu" href="javascript:createPaperOne()"><i class="fa fa-pencil-square-o "></i>科一模拟 </a>
                        
                    </li>
                    <li>
                        <a href="drivertest4.html"><i class="fa fa-pencil-square-o "></i>科四模拟</a>
                    </li>
                    <li>
                        <a href="analogtest.html"><i class="fa fa-pencil-square "></i>模拟练习</a>
                    </li>
                     <li>
                        <a href="testreview.html"><i class="fa fa-book "></i>试题复习</a>
                    </li>
                    <li>
                        <a href="mygrade.html"><i class="fa fa-graduation-cap "></i>我的成绩</a>
                    </li>
                    <li>
                        <a href="personsetting.html"><i class="fa fa-cogs "></i>个人设置</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)"><i class="fa fa-sign-out "></i>退出系统</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <i class="fa fa-arrow-circle-o-right fa-4x" style="color: gray;margin-top: 3px;">&nbsp;科目一模拟</i>
                        <h5 class="page-subhead-line"></h5>
                    </div>
                </div>
                <!-- /. ROW  -->
              <div class="row">
              	<div class="col-md-3">
              		<fieldset style="height: 350px;">
					    <legend>考生信息</legend>
					    <table style="text-align: center;" align="center">
					    <tr>
					    	<td colspan="2">
					    	 <img src="assets/img/user.png" class="img-thumbnail" /><br/>
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
					    <div align="center" style="font-size: x-large;font-weight: bolder;margin-bottom: 5px;" id="currentTime"></div>
					</fieldset>
              	</div>
              	<div class="col-md-9">
              		<fieldset style="height: 350px;">
					    <legend>考试题目</legend>
					    <div class="col-md-6" id="title"></div>
					    <div class="col-md-6" id="image"></div>
					</fieldset>
					<fieldset>
						  <legend>题目选项</legend>
						  <div align="left" id="option"></div>
					</fieldset>
              	</div>
              	
              </div>
                <!-- /. ROW  -->
                <div class="row">
                	<div class="col-md-12">
              		<fieldset>
					    <legend>答题信息</legend>
					    <div align="center" id="number"></div>
					</fieldset>
              	</div>
                </div>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

    <div id="footer-sec" align="center">
	Copyright &copy; 2017 Hunan University Of Humanities,Science And Technology. All Rights Reserved.
    </div>
    
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
		setInterval(function() {
	    var now = (new Date()).toLocaleString();
		    $('#current-time').text(now);
		}, 1000);
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
		var button = "";
		for(var i = 1;i <= 100;i++){
			if(i<10){
				i = "0"+i;
			}
			button+="<button type='button' class='btn btn-default btn-sm' style='margin: 2px;'>"+i+"</button>";
		}
		$('#number').html(button);
	}
	//选择一项答案
	function selectAnswer(answer,paper1Number,paper1Qid,chooseItem){
		$.ajax({
			type:"post",
			url:"chooseOneAnswer",
			data:{"paper1Number":paper1Number,"paper1Qid":paper1Qid,"paper1Choice":chooseItem},
			success:function(data){
				if(answer == chooseItem){
					$('#number').find('button').eq(paper1Qid-1).attr("class","btn btn-success btn-sm");
				}else{
					if(++errorItem > 10){
						preSubmitPaper1("您已答错了11题，成绩不合格。请交卷!");
					}
					$('#number').find('button').eq(paper1Qid-1).attr("class","btn btn-danger btn-sm");
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
		var title = "<h3>"+dataObj[0].paper1Qid+"、"+dataObj[0].examQuestion1.question1Question+"</h3>";
				title += "<h4 style='margin-left: 20px;'>A、"+dataObj[0].examQuestion1.question1Item1+"</h4>";
				title += "<h4 style='margin-left: 20px;'>B、"+dataObj[0].examQuestion1.question1Item2+"</h4>";
				if(dataObj[0].examQuestion1.question1Item3 != ""){
					title += "<h4 style='margin-left: 20px;'>C、"+dataObj[0].examQuestion1.question1Item3+"</h4>";
					title += "<h4 style='margin-left: 20px;'>D、"+dataObj[0].examQuestion1.question1Item4+"</h4>";
				}
				$('#title').html(title);
				//加载图片信息
				if(dataObj[0].examQuestion1.question1Url != ""){
					var img = "<a href=\"javascript:biggerImage(\'../question1/"+dataObj[0].examQuestion1.question1Url+"\')\" title='点击放大效果图'><img src='../question1/"+dataObj[0].examQuestion1.question1Url+"' class='img-thumbnail'></a>"
					$('#image').html(img);
				}else{
					$('#image').html("");
				}
				//加载选项信息
				var option = "<button type='button' onclick=\"selectAnswer(\'"+dataObj[0].question1Answer+"\',\'"+dataObj[0].paper1Number+"\',\'"+dataObj[0].paper1Qid+"\',1)\" class='btn btn-default btn-lg' style='margin-right: 20px;margin-left: 50px;'>A</button>";
				option+="<button type='button' onclick=\"selectAnswer(\'"+dataObj[0].question1Answer+"\',\'"+dataObj[0].paper1Number+"\',\'"+dataObj[0].paper1Qid+"\',2)\" class='btn btn-default btn-lg' style='margin-right: 20px;'>B</button>";
				if(dataObj[0].examQuestion1.question1Item3 != ""){
					option+="<button type='button' onclick=\"selectAnswer(\'"+dataObj[0].question1Answer+"\',\'"+dataObj[0].paper1Number+"\',\'"+dataObj[0].paper1Qid+"\',3)\" class='btn btn-default btn-lg' style='margin-right: 20px;'>C</button>";
					option+="<button type='button' onclick=\"selectAnswer(\'"+dataObj[0].question1Answer+"\',\'"+dataObj[0].paper1Number+"\',\'"+dataObj[0].paper1Qid+"\',4)\" class='btn btn-default btn-lg' style='margin-right: 20px;'>D</button>";
				}
				option+="<button type='button' class='btn btn-primary btn-lg' style='margin-left: 20px;' onclick='preSubmitPaper1()'>交卷</button>";
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
