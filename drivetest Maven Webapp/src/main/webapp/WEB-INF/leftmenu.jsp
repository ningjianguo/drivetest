<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="assets/js/jquery-1.10.2.js"></script>
<script type="text/javascript">
		$(function(){
			var menuactive = $('#menuactive').val();
			$('#'+menuactive).attr("class","active-menu");
		});
</script>
<input type="hidden" id="menuactive" value="<%=request.getParameter("menuactive")%>">
<nav class="navbar-default navbar-side" role="navigation"  style="background-color: #5BC0DE;height: 90%;">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li>
						<div class="user-img-div">
							<c:choose>
								<c:when test="${empty user.userFilepath}">
					    		 <img src="../images/user.png" class="img-thumbnail" width="128px" height="128px" /><br/>
								</c:when>
								<c:otherwise>
					    		 <img src="../images/${user.userFilepath }" class="img-thumbnail" width="128px" height="128px" /><br/>
								</c:otherwise>
							</c:choose>
							<div class="inner-text" style="margin-bottom: 5px;">
								欢迎你，${user.userName}
							</div>
						</div>
					</li>
					<li><a href="index" id="index"><i
							class="fa fa-dashboard fa-fw"></i>主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a>
					</li>

					<li><a href="driverTest1" id="drivetest1"><i
							class="fa fa-pencil-square-o fa-fw"></i>科一模拟 </a>
					</li>
					<li><a href="driverTest4" id="drivetest4"><i
							class="fa fa-pencil-square-o fa-fw"></i>科四模拟</a>
					</li>
					<li><a href="test1Review" id="test1Review"><i
							class="fa fa-book fa-fw"></i>科一复习</a>
					</li>
					<li><a href="test4Review" id="test4Review"><i class="fa fa-book fa-fw"></i>科四复习</a>
					</li>
					<li><a href="mygrade" id="mygrade"><i
							class="fa fa-graduation-cap fa-fw"></i>我的成绩</a>
					</li>
					<li><a href="personSetting" id="personSetting"><i class="fa fa-cogs fa-fw"></i>个人设置</a>
					</li>
					<li><a href="loginOut"><i
							class="fa fa-sign-out fa-fw"></i>退出系统</a>
					</li>
				</ul>
			</div>
</nav>
