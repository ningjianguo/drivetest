<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-cls-top navbar-fixed-top" role="navigation"
			style="margin: 0 auto;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand fa fa-taxi" href="index">&nbsp;DRIVER
					TEST</a>
			</div>

			<div class="header-right">
				<span id="current-time" style="float: left;font-weight: bolder;margin-right: 15px;margin-top: 5px;"></span>
				<a href="message-task.html" class="btn btn-info btn-xs" title="邮件列表"><i
					class="fa fa-envelope-o fa-2x"></i>&nbsp;<span id="fmessage">邮件列表&nbsp;</span><span id="ftask" class="badge">59</span></a> <a href="loginOut"
					class="btn btn-danger btn-xs" title="退出系统"><i
					class="fa  fa-sign-out fa-2x"></i>&nbsp;退出系统</a>

			</div>
</nav>

<script>
	var blinkBool = false;//进入邮件列表后设为true
	$(function(){
		Setlinkblink();
	});
	//消息闪烁
		function Setlinkblink() {
			var val = $("#ftask").text();
			var message = document.getElementById('fmessage');
			if (val> 0&& blinkBool == false) {
				if (!message.style.color) {
					message.style.color = "white"
				}
				if (message.style.color == "red") {
					message.style.color = "white"
				} else {
					message.style.color = "red"
				}
				setTimeout("Setlinkblink()", 800);
			}else{
				$(".badge").css('display','none');
			}
		}
</script>