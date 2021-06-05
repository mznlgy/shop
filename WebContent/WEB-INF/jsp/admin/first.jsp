<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<link href="<%=request.getContextPath()%>/css/admin/first.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- 头部信息 -->
	<div class="header_con">
		<div class="header">
			<div class="welcome"><a href="${pageContext.request.contextPath}/admin/first"><img class="logo" alt="" src="<%=request.getContextPath()%>/images/logo.jpg"></a></div>
			<div class="user_login">
            <a href="first.php"><strong><i>${admin}</i></strong></a>,欢迎来到后台管理系统！
            <span>|</span>
				<a href="${pageContext.request.contextPath}/admin/logout">退出登录</a>
			</div>
		</div>
	</div>
 <div class="rg_layout">
     <div class = "rg_center">
          <div class="rg_form">
         <table id="table">
          <tr>
          <td class="td_do1"><a class="td_do" href="${pageContext.request.contextPath}/admin/admproduct?adminid=1">商品管理</a></td>
          <tr>
           <td class="td_do1"><a class="td_do" href="${pageContext.request.contextPath}/admin/admuser">用户管理</a></td>
           </tr>
           <tr>
           <td class="td_do1"><a class="td_do" href="${pageContext.request.contextPath}/admin/admorder">订单管理</a></td>
           </tr>
          </table>
            </div>
        </div>
    </div>
</body>
</html>