<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="<%=request.getContextPath()%>/css/admin/admproduct.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath()%>/css/before/first2.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath()%>/css/before/cart.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"></link>
	<script>
		function check(){
			if(sub.userid.value==""){
				alert("请输入用户id");
				return false;
			}else{
				return true;
			}
		}
		function check2(){
			if(sub2.username.value==""){
				alert("请输入用户名");
				return false;
			}else{
				return true;
			}
		}
	</script>
	</head>
<body>
	<!-- 头部信息 -->
	<div class="header_con">
		<div class="header">
			<div class="welcome"><a href="${pageContext.request.contextPath}/admin/first"><img class="logo" alt="" src="<%=request.getContextPath() %>/images/logo.jpg"></a></div>
			<div class="user_login">
            <a href="<?php echo $url_userinfo;?>"><strong><i>${username}</i></strong></a>,欢迎来到后台管理系统！
            <span>|</span>
				<a href="../user/logou.php">退出登录</a>
			</div>
		</div>
	</div>
	<div class="navbar_con">
		<div class="navbar clearfix" style="margin-top: 60px;">
			<div class="subnav_con fl">
				<a class="adminnproduct" href="${pageContext.request.contextPath}/admin/admproduct?adminid=1"><h1>用户管理</h1></a>
			</div>
		</div>
	</div>

	<form action="${pageContext.request.contextPath}/admin/searchbyuserid" method="post" id="sub">
		<input type="text" value="" placeholder="按用户id查询" name="userid"/><input type="submit" value="查询" onClick="return check()"/>
	</form>
	<form action="${pageContext.request.contextPath}/admin/searchbyusername" method="post" id="sub2">
		<input type="text" value="" placeholder="按用户名查询" name="username"/><input type="submit" value="查询" onClick="return check2()"/>
	</form>
	
		<div class="car" style="margin-top: 2px;">
		<div class="good">
	  	<c:choose>
	<c:when test="${isnull!=1 }">
					<table>
					<tr>
						<td width=10% style="font-size:17px;">用户id</td>
						<td width=10% style="font-size:17px;">用户名</td>
						<td width=10% style="font-size:17px;">密码</td>
						<td width=10% style="font-size:17px;">邮箱</td>
						<td width=20% style="font-size:17px;">密保问题</td>
						<td width=20% style="font-size:17px;">答案</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
	
					<tr>
						<td width=10% style="font-size:17px;">${user.user_id}</td>
						<td width=10% style="font-size:17px;">${user.username}</td>
						<td width=10% style="font-size:17px;">${user.password}</td>
						<td width=10% style="font-size:17px;">${user.email}</td>
						<td width=20% style="font-size:17px;">${user.question}</td>
						<td width=20% style="font-size:17px;">${user.answer}</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
					<tr>
					<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=20% style="font-size:17px;"></td>
						<td width=20% style="font-size:17px;"><a href="${pageContext.request.contextPath}/admin/deleteuser?userid=${user.user_id}">删除</a>/<a href="${pageContext.request.contextPath}/admin/updateuser?userid=${user.user_id}">修改</a></td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
					</table>
				</c:when>
			<c:otherwise>
			<h3>没有该用户</h3>
		</c:otherwise>
		</c:choose>
			</div>
		</div>

	</body>
</html>
