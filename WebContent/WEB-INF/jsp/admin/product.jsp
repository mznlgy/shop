<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/before/product.css"/>
<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"></link>
<script>
function check(){
	if(sub.productname.value=="" && sub.price2.value==""){
		alert("无需修改");
		return false;
	}else{
		if(sub.productname.value=="" && sub.price2.value!=""){
			sub.price.value = sub.price2.value;
			return true;
		}else if(sub.productname.value!="" && sub.price2.value==""){
			sub.product_name.value = sub.productname.value;
			return true;
		}else{
			sub.product_name.value = sub.productname.value;
			sub.price.value = sub.price2.value;
			return true;
		}
	}
}
</script>
</head>
<body>
		<!-- 头部信息 -->
	<div class="header_con">
		<div class="header">
			<div class="welcome"><a href="${pageContext.request.contextPath}/admin/first"><img class="logo" alt="" src="<%=request.getContextPath()%>/images/logo.jpg"></a></div>
			<div class="user_login">
            <a href="../user/userinfo.php?username=<?php echo $username;?>"><strong><i>${username}</i></strong></a>,欢迎来到桃子商城！
            <span>|</span>
				<a href="#">退出登录</a>
			</div>
		</div>
	</div>
	<div class="search_bar clearfix">
		<div class="search_con fl" style="border:none;">
		</div>
	</div>
	<!-- 商品信息栏 -->
	<div class="navbar_con">
		<div class="navbar clearfix">
			<div class="subnav_con fl">
				<h1>商品详情 <i></i></h1>
			</div>
		</div>
	</div>
	<div class="submena clearfix">
	</div>
	<div class="center_con clearfix">
		<div class="main_menu fl"><img class="showimg" src="${product.imgpath}"/></div>
		<div class="goods_detail_list fr">
			<p><h1 id="prodname">${product.product_name}</h1></p>
			<div class="prize_bar">
				<div class="show_prize fl">￥<em id="aprice">${product.price}</em></div>
			</div>
			<form action="${pageContext.request.contextPath}/admin/updateproduct" method="post" id="sub"> 
			<div class="goods_num clearfix">
			<div class="num_name fl" style="font-size:15px;width:auto;">修改的名称：</div>
					<input type="hidden" name="product_name" value="null">
					<input class="num_inp" type="text" name="productname" value="">
			</div>
			<div class="goods_num clearfix">
				<div class="num_name fl" style="font-size:15px;width:auto;">修改的价格：</div>
					<input  type="hidden" id="price" name="price" value="null">
					<input class="num_inp" type="text" id="price2" name="price2" value="">
			</div>
					<input type="hidden" id="product_id" name="product_id" value="${product.product_id}">
				<div class="operate_btn">
						<button type="submit" class="add_cart" onClick="return check()">确认修改</button>
					</div>
				
			</form>
		</div>
	</div>
</body>
</html>