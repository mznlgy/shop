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
			if(sub.orderid.value==""){
				alert("请输入订单id");
				return false;
			}else{
				return true;
			}
		}
		function check2(){
			if(sub2.userid.value==""){
				alert("请输入用户id");
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
				<a class="adminnproduct" href="${pageContext.request.contextPath}/admin/admproduct?adminid=1"><h1>订单管理</h1></a>
			</div>
		</div>
	</div>
	<form action="${pageContext.request.contextPath}/admin/searchorbyid" method="post" id="sub">
		<input type="text" value="" placeholder="按订单id查询" name="orderid"/><input type="submit" value="查询" onClick="return check()"/>
	</form>
	<form action="${pageContext.request.contextPath}/admin/searchbyserid" method="post" id="sub2">
		<input type="text" value="" placeholder="按用户id查询" name="userid"/><input type="submit" value="查询" onClick="return check2()"/>
	</form>
	
		<div class="car" style="margin-top: 2px;">
		<div class="good">
		<c:choose>
		 <c:when test="${type==2}">
			 
		 <c:choose>
		 	<c:when test="${isnull!=1}">
		 		<table>
					<tr>
						<td width=10% style="font-size:17px;">订单号</td>
						<td width=10% style="font-size:17px;">用户id</td>
						<td width=10% style="font-size:17px;">订单金额</td>
						<td width=10% style="font-size:17px;">支付状态</td>
						<td width=20% style="font-size:17px;">创建时间</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
					<c:forEach var="order" items="${orderlist}">
					<tr>
						<td width=10% style="font-size:17px;">${order.orderid}</td>
						<td width=10% style="font-size:17px;">${order.user_id}</td>
						<td width=10% style="font-size:17px;">${order.amount}</td>
						<c:choose>
							<c:when test="${order.status==1}">
								<td width=10% style="font-size:17px;">已支付<a style="font-size:17px;color:red;" href="${pageContext.request.contextPath}/admin/updateorder?orderid=${order.orderid}&status=${order.status}">&nbsp;&nbsp;修改</a></td>
							</c:when>
							<c:when test="${order.status==0}">
								<td width=10% style="font-size:17px;">未支付<a style="font-size:17px;color:red;" href="${pageContext.request.contextPath}/admin/updateorder?orderid=${order.orderid}&status=${order.status}">&nbsp;&nbsp;修改</a></td>
							</c:when>
							<c:otherwise>
								<td width=10% style="font-size:17px;">&nbsp;</td>
							</c:otherwise>
						</c:choose>
						<td width=20% style="font-size:17px;">${order.time}</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
					<tr>
					<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=20% style="font-size:17px;"></td>
						<c:choose>
							<c:when test="${isnull!=1}">
								<td width=20% style="font-size:17px;"><a href="${pageContext.request.contextPath}/admin/deleteorder?orderid=${order.orderid}">删除</a></td>
							</c:when>
							<c:otherwise>
								<td width=20% style="font-size:17px;"></td>
							</c:otherwise>
						</c:choose>
						
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
					</c:forEach>
					</table>
		 	</c:when>
		 	<c:otherwise>
		 		没有该用户或该用户没有订单
		 	</c:otherwise>
		 </c:choose>
		 </c:when>
		 <c:otherwise>
		 	<c:choose>
	<c:when test="${isnull!=1 }">
					<table>
					<tr>
						<td width=10% style="font-size:17px;">订单号</td>
						<td width=10% style="font-size:17px;">用户id</td>
						<td width=10% style="font-size:17px;">订单金额</td>
						<td width=10% style="font-size:17px;">支付状态</td>
						<td width=20% style="font-size:17px;">创建时间</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
	
					<tr>
						<td width=10% style="font-size:17px;">${order.orderid}</td>
						<td width=10% style="font-size:17px;">${order.user_id}</td>
						<td width=10% style="font-size:17px;">${order.amount}</td>
						<c:choose>
							<c:when test="${order.status==1}">
								<td width=10% style="font-size:17px;">已支付<a style="font-size:17px;color:red;" href="${pageContext.request.contextPath}/admin/updateorder?orderid=${order.orderid}&status=${order.status}">&nbsp;&nbsp;修改</a></td>
							</c:when>
							<c:when test="${order.status==0}">
								<td width=10% style="font-size:17px;">未支付<a style="font-size:17px;color:red;" href="${pageContext.request.contextPath}/admin/updateorder?orderid=${order.orderid}&status=${order.status}">&nbsp;&nbsp;修改</a></td>
							</c:when>
							<c:otherwise>
								<td width=10% style="font-size:17px;">&nbsp;</td>
							</c:otherwise>
						</c:choose>
						<td width=20% style="font-size:17px;">${order.time}</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
					<tr>
					<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=10% style="font-size:17px;"></td>
						<td width=20% style="font-size:17px;"></td>
						<c:choose>
							<c:when test="${isnull!=1}">
								<td width=20% style="font-size:17px;"><a href="${pageContext.request.contextPath}/admin/deleteorder?orderid=${order.orderid}">删除</a></td>
							</c:when>
							<c:otherwise>
								<td width=20% style="font-size:17px;"></td>
							</c:otherwise>
						</c:choose>
						
						<td width=20% style="font-size:17px;">&nbsp;</td>
					</tr>
					</table>
				</c:when>
			<c:otherwise>
			<h3>没有该订单</h3>
		</c:otherwise>
		</c:choose>
		 </c:otherwise>
		</c:choose>
				</div>
		</div>

	</body>
</html>
