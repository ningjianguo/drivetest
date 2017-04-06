<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script src="assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript">
		$(function(){
			var menuactive = $('#menuactive').val();
			$('#'+menuactive).attr("class","active-menu");
		})
</script>
<input type="hidden" id="menuactive" value="<%=request.getParameter("menuactive")%>">
<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li>
						<div class="user-img-div">
							<img src="assets/img/user.png" class="img-thumbnail" />
							<div class="inner-text">
								欢迎你，${user.userName} <br />
							</div>
						</div>
					</li>
					<li><a href="index" id="index"><i
							class="fa fa-dashboard "></i>主页</a>
					</li>

					<li><a href="driverTest1" id="drivetest1"><i
							class="fa fa-pencil-square-o "></i>科一模拟 </a>
					</li>
					<li><a href="driverTest4" id="drivetest4"><i
							class="fa fa-pencil-square-o "></i>科四模拟</a>
					</li>
					<li><a href="analogtest.html"><i
							class="fa fa-pencil-square "></i>模拟练习</a>
					</li>
					<li><a href="testreview.html"><i class="fa fa-book "></i>试题复习</a>
					</li>
					<li><a href="mygrade.html"><i
							class="fa fa-graduation-cap "></i>我的成绩</a>
					</li>
					<li><a href="personsetting.html"><i class="fa fa-cogs "></i>个人设置</a>
					</li>
					<li><a href="javascript:void(0)"><i
							class="fa fa-sign-out "></i>退出系统</a>
					</li>
				</ul>

			</div>

</nav>