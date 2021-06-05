<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<html>
<head>
		<meta charset="UTF-8">
		<link href="<%=request.getContextPath()%>/css/before/first2.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath()%>/css/before/cart.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"></link>
<script>
function setTotal(){
	var  xiaoji = document.querySelectorAll(".xiaoji");//每个订单的多个小计
	var orderid = document.querySelectorAll(".orderid");//每个订单的订单号
	var orderidlist = [];
	var s = [];
	orderidlist[0] = orderid[0].innerHTML;
	sum = parseFloat(xiaoji[0].innerHTML);
	for(var i=1;i<orderid.length;i++){
		if(orderid[i].innerHTML!=orderid[i-1].innerHTML){
			s.push(sum);
			orderidlist.push(orderid[i].innerHTML);
			sum = 0;
		}
		sum+= parseFloat(xiaoji[i].innerHTML);
		if( i==orderid.length-1){
			s.push(sum);
		}
		//console.log("i="+i+"时"+sum);
	}
	for(var i=0;i<s.length;i++){
		document.querySelectorAll(".totalprice")[i].innerHTML = s[i].toFixed(1);
	}
	for(var i=0;i<orderidlist.length;i++){
		console.log(orderidlist[i]);
		document.querySelectorAll(".subordid")[i].value = orderidlist[i];
	}
}
</script>	
</head>
<body onload="setTotal();">
	<!-- 头部信息 -->
	<div class="header_con">
		<div class="header">
			<div class="welcome"><a href="${pageContext.request.contextPath}/before/first" target="_blank"></a><a href="${pageContext.request.contextPath}/before/first"><img class="logo" alt="" src="<%=request.getContextPath() %>/images/logo.jpg"></a></div>
			<div class="user_login">
            <a href="<?php echo $url_userinfo;?>"><strong><i>${username}</i></strong></a>,欢迎来到桃子商城！
            <span>|</span>
				<a href="${pageContext.request.contextPath}/before/logout">退出登录</a>
				<span>|</span>
                <a href="${pageContext.request.contextPath}/before/myorders">我的订单</a>
				<span>|</span>
				<a href="${pageContext.request.contextPath}/before/shoppingcart">购物车</a>
			</div>
		</div>
	</div>
	<div class="navbar_con">
		<div class="navbar clearfix" style="margin-top: 60px;">
			<div class="subnav_con fl">
				<h1>我的订单</h1>
			</div>
		</div>
	</div>
	<div class="car" style="margin-top: 2px;">
		<div class="good">
					<table>
					<tr>
						<td width=10% style="font-size:17px;">订单号</td>
						<td width=55% style="font-size:17px;">商品</td>
						<td width=12% style="font-size:17px;">单价</td>
						<td width=8% style="font-size:17px;">数量</td>
						<td width=9% style="font-size:17px;">小计</td>
						<td width=7% style="font-size:17px;">订单状态</td>
						<td width=2% style="font-size:17px;">&nbsp;</td>
					</tr>
					</table>
				</div>
				<div class="goods" style="height:auto;">
					<table id="tab">
					 <c:forEach var="product" items="${productlist}" varStatus="pro">		
					<tr>
						<td width=10%><h2 class="orderid">${product.orderid}</h2></td>
						<td width=55% class="td_probox" style="padding-top:30px;"><image id="proimg" src="${product.imgpath}"/><a href="${pageContext.request.contextPath}/before/product?product_id=${product.product_id}"><em style="font-size:15px;">${product.product_name}</em></a></td>
						<td width=12%><h2 class="price">${product.price}</h2></td>
						<td width=8%><h2 class="price">${product.count}</h2></td>
						<td width=9%><h2 class="xiaoji inout_product_infos" type="number"><fmt:formatNumber type="number" value="${product.price*product.count}" pattern="0.0" /></h2></td>
						<c:choose>
							<c:when test="${product.status ==1}">
								<td width=7% style="font-size:17px;">已支付</td>
							</c:when>
							<c:when test="${product.status ==0}">
								<td width=7% style="font-size:17px;">未支付</td>
							</c:when>
						</c:choose>
						<td width=2% style="font-size:17px;">&nbsp;</td>
					</tr>
					<c:if test="${productlist[pro.index].orderid != productlist[pro.index+1].orderid}">
						<tr>
						<td width=10% style="font-size:17px;">&nbsp;</td>
						<td width=55% style="font-size:17px;">&nbsp;</td>
						<td width=12% style="font-size:17px;">&nbsp;</td>
						<td width=8% style="font-size:17px;">&nbsp;</td>
						<td width=9% style="font-size:17px;">总金额：<em class="totalprice" style="font-size:18px;color:red;">0.00</em></td>
						<form action="${pageContext.request.contextPath}/before/pay" method="post">
								<input type="hidden" class="subordid" name="subordid" value="" />
							<c:choose>
							<c:when test="${product.status ==0}">
								<td width=7% style="font-size:17px;"><button type="submit" class="btn2">支付订单</button></td>	
							</c:when>
							<c:when test="${product.status ==1}">
							<td width=7% style="font-size:17px;">&nbsp;</td>
							</c:when>
						</c:choose>
						</form>
						<td width=2% style="font-size:17px;">&nbsp;</td>
					</tr>
					</c:if>
				
						<input type="hidden" value="<fmt:formatNumber type="number" value="" pattern="0.0" />" />
						</c:forEach>					
					</table>
				</div>
	</body>
</html>