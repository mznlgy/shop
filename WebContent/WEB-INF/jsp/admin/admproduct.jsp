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
	<script type="text/javascript">
	function check(){
		if(sub.productname.value!="" && sub.price.value!="" && sub.imgpath.value.length!=0){
			return true;
		}else{
			alert("请完善商品信息");
			return false;
		}
	}
	function setimg(){
		var reads=new FileReader();
		f=document.getElementById('imgpath').files[0];
		reads.readAsDataURL(f);
		reads.onload=function(e){
			document.getElementById('proimg').src=this.result;
		};
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
				<a class="adminnproduct" href="${pageContext.request.contextPath}/admin/admproduct?adminid=1"><h1>添加商品</h1></a>
			</div>
			<div class="subnav_con fl">
				<a class="adminnproduct" href="${pageContext.request.contextPath}/admin/admproduct?adminid=2"><h1>查询/修改商品</h1></a>
			</div>
		</div>
	</div>
	<c:choose>
	<c:when test="${admin==2}">
	<form action="${pageContext.request.contextPath}/admin/search" method="post">
		<input type="hidden" value=1 name="requestpage"/>
		<input type="hidden" value="" name="productname"/>
		<input type="text" value="" placeholder="按商品号查询" name="productid"/><input type="submit" value="查询"/>
	</form>
	<form action="${pageContext.request.contextPath}/admin/search" method="post">
		<input type="hidden" value=1 name="requestpage"/>
		<input type="hidden" value=0 name="productid"/>
		<input type="text" value="" placeholder="按商品名称查询" name="productname"/><input type="submit" value="查询"/>
	</form>
		<div class="car" style="margin-top: 2px;">
		<div class="good">
					<table>
					<tr><td width=10% style="font-size:17px;">商品号</td>
						<td width=70% style="font-size:17px;">商品名称</td>
						<td width=10% style="font-size:17px;">单价</td>
						<td width=5% style="font-size:17px;">操作</td>
						<td width=5% style="font-size:17px;">&nbsp;&nbsp;</td>
						</tr>
						</table>
				</div>
				<c:choose>
				 <c:when test="${isnull==0 }">
				 	<div class="goods" style="height:auto;">
				<table id="tab">
				<c:forEach var="product" items="${searchlist}">
					<tr>
						<td width=10% class="td_probox">${product.product_id}</td>
						<td width=70% class="td_probox"><image id="proimg" src="${product.imgpath}"/><em style="font-size:15px;">${product.product_name}</em></td>
						<td width=10%>${product.price}</td>
						<td width=5%><a href="${pageContext.request.contextPath}/admin/deleteproduct?product_id=${product.product_id}">删除&nbsp;</a><a href="${pageContext.request.contextPath}/admin/product?product_id=${product.product_id}">&nbsp;修改</a></td>
						<td width=5%></td>
						</tr>
				</c:forEach>
					</table>
				</div>
				 </c:when>
				<c:otherwise>
					<h3>查无此物！！！</h3>
				</c:otherwise>

		</c:choose>
		</div>
	</c:when>
	<c:otherwise>
		<div class="car" style="margin-top: 2px;">
		<div class="good">
					<table>
					<tr><td width=10% style="font-size:17px;">商品名称</td>
						<td width=10% style="font-size:17px;">商品单价</td>
						<td width=10% style="font-size:17px;">商品图片</td>
						<td width=35% style="font-size:17px;">&nbsp;&nbsp;</td>
						<td width=35% style="font-size:17px;">&nbsp;&nbsp;</td>
					</tr>
					<tr>
					<form action="${pageContext.request.contextPath}/admin/addproduct" method="post" enctype="multipart/form-data" id="sub">
						<td width=10% style="font-size:17px;"><input name="productname" value="" /></td>
						<td width=10% style="font-size:17px;"><input name="price" value="" /></td>
						<td width=10% style="font-size:17px;"><input id="imgpath" name="imgpath" type="file" value="" onChange="setimg(this)"/><image id="proimg" src="" style="height:60px;width:auto;"/></td>
						<td width=35% style="font-size:17px;">&nbsp;&nbsp;</td>
						<td width=35% style="font-size:17px;">&nbsp;&nbsp;</td>
					
					</tr>
					<tr><td width=10% style="font-size:17px;"><input type="submit" value="添加" onClick="return check()"/></td>
						<td width=10% style="font-size:17px;">&nbsp;&nbsp;</td>
						<td width=10% style="font-size:17px;">&nbsp;&nbsp;</td>
						<td width=35% style="font-size:17px;">&nbsp;&nbsp;</td>
						<td width=35% style="font-size:17px;">&nbsp;&nbsp;</td>
					</tr>
					</form>
					</table>
				</div>
				
		</div>
	</c:otherwise>
	
		</c:choose>
	</body>
</html>
