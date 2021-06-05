<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
<script>
function add(){
	if(document.getElementById('count').value==20)
	{
		alert("单次最多选择20件商品！");
		return false;
		}
	document.getElementById('count').value++;
	document.getElementById('allcount').innerHTML=(document.getElementById('aprice').innerHTML*document.getElementById('count').value).toFixed(2);
	document.getElementById('pro_count').value=document.getElementById('count').value;
	}
function down(){
	if(document.getElementById('count').value==1)
	{
		return false;
		}
	document.getElementById('count').value--;
	document.getElementById('allcount').innerHTML=(document.getElementById('aprice').innerHTML*document.getElementById('count').value).toFixed(2);
	document.getElementById('pro_count').value=document.getElementById('count').value;
	}	
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/before/product.css"/>
<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"></link>
</head>
<body>
		<!-- 头部信息 -->
	<div class="header_con">
		<div class="header">
			<div class="welcome"><a href="${pageContext.request.contextPath}/before/first"><img class="logo" alt="" src="<%=request.getContextPath()%>/images/logo.jpg"></a></div>
			<div class="user_login">
            <a href="../user/userinfo.php?username=<?php echo $username;?>"><strong><i>${username}</i></strong></a>,欢迎来到桃子商城！
            <span>|</span>
				<a href="${pageContext.request.contextPath}/before/logout">退出登录</a>
				<span>|</span>
                <a href="${pageContext.request.contextPath}/before/myorders">我的订单</a>
				<span>|</span>
				<a href="${pageContext.request.contextPath}/before/shoppingcart">购物车</a>
			</div>
		</div>
	</div>
	<div class="search_bar clearfix">
		<div class="search_con fl">
		<form action="${pageContext.request.contextPath}/before/search?requestpage=1" method="post">
			<input type="text" class="input_text fl" placeholder="搜索商品" name="product_name">
			<input type="submit" class="input_btn fr" value="搜索">
	</form>
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
			<div class="goods_num clearfix">
            	<button type="button" class="bt_cal" onClick="down()"><i class="fa fa-minus-square-o"></i></button>
				<div class="num_name fl" style="font-size:15px;">数量：</div>
					<input class="num_inp" type="text" id="count" value=1>
                	<button type="button" class="bt_cal" onClick="add()"><i class="fa fa-plus-square-o "></i></button>
				</div>
			<div class="total" style="font-size:15px;">总价：<em style="color:red;">￥</em><em id="allcount">${product.price}</em></div>
				<form action="${pageContext.request.contextPath}/before/addproduct" method="post"> 
					<input type="hidden" name="product_id" id="product_id" value="${product.product_id}">
					<input type="hidden" name="pro_count" id="pro_count" value=1>
					<div class="operate_btn">
					
						<button type="submit" class="add_cart">加入购物车</button>
					</div>
			</form>
		</div>
	</div>
</body>
</html>