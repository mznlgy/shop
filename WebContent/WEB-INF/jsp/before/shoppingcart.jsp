<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<html>
	<head>
		<meta charset="UTF-8">
		<link href="<%=request.getContextPath()%>/css/before/first2.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath()%>/css/before/cart.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"></link>
	</head>
<script>
/*数量增加*/
function add(id){
	//id作为标识是哪个按钮，从0开始，对应取得的数量、单价数组的下标，方便操作
	var count = document.querySelectorAll(".count");//数量数组
	var price = document.querySelectorAll(".price");//单价数组
	var  xiaoji = document.querySelectorAll(".xiaoji");//小计数组
	var sum = 0;
	count[id].value++;
	sum += parseFloat(count[id].value) * parseFloat(price[id].innerHTML);
	xiaoji[id].innerHTML = sum.toFixed(2);
	setTotal();
}
/*数量减少*/
function down(id){
	var count = document.querySelectorAll(".count");
	var price = document.querySelectorAll(".price");
	var  xiaoji = document.querySelectorAll(".xiaoji");
	var sum = 0;
	count[id].value--;
	sum += parseFloat(count[id].value) * parseFloat(price[id].innerHTML);
	xiaoji[id].innerHTML = sum.toFixed(2);
	setTotal();
}
/*总价格*/
function setTotal(){
	var  xiaoji = document.querySelectorAll(".xiaoji");
	var sum = 0;
	for(var i=0;i<xiaoji.length;i++){
		sum = sum + parseFloat(xiaoji[i].innerHTML);
	}
	document.getElementById("totalprice").innerHTML = sum.toFixed(2);
}
/*提交订单*/
function suborders(){
	document.getElementById("subprice").value = parseFloat(document.getElementById("totalprice").innerHTML).toFixed(2);
}
</script>
<%int i = 0;%>
<body onload="setTotal();">
	<!-- 头部信息 -->
	<div class="header_con">
		<div class="header">
			<div class="welcome"><a href="${pageContext.request.contextPath}/before/first" target="_blank"></a><a href="${pageContext.request.contextPath}/before/first"><img class="logo" alt="" src="<%=request.getContextPath() %>/images/logo.jpg"></a></div>
			<div class="user_login">
            <a href="#"><strong><i>${username}</i></strong></a>,欢迎来到桃子商城！
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
				<h1>购物车</h1>
			</div>
		</div>
	</div>
	<div class="car" style="margin-top: 2px;">
		<div class="good">
					<table><tr><td width=70% style="font-size:17px;">商品名称</td>
						<td width=10% style="font-size:17px;">单价</td>
						<td width=10% style="font-size:17px;">数量</td>
						<td width=5% style="font-size:17px;">小计</td>
						<td width=5% style="font-size:17px;">&nbsp;&nbsp;</td>
						</tr></table>
				</div>
				
				<div class="goods" style="height:auto;">
				<table id="tab">
				<c:forEach var="product" items="${productlist}">
					<tr>
						<td width=70% class="td_probox"><image id="proimg" src="${product.imgpath}"/><em style="font-size:15px;">${product.product_name}</em></td>
						<td width=10%><h2 class="price">${product.price}</h2></td>
						<td width=10%>
							<button class="bt_down" onClick="down(<%=i%>)"><i class="fa fa-minus-square-o"></i></button>
							<input id="<%=i%>" class="count inout_product_infos" value="${product.count}"/>
							<button class="add" onClick="add(<%=i%>)"><i class="fa fa-plus-square-o "></i></button>
						</td>
						<td width=5%><h2 class="xiaoji inout_product_infos" type="number"><fmt:formatNumber type="number" value="${product.price*product.count}" pattern="0.00" /></h2></td>
						<td width=5%><a href="${pageContext.request.contextPath}/before/removeproduct?product_id=${product.product_id}">移除</a></td>
						</tr>
						<input type="hidden" value="<fmt:formatNumber type="number" value="${product.price*product.count}" pattern="0.00" />" />
						<% i++;%>
						</c:forEach>
						<form action="${pageContext.request.contextPath}/before/suborder" method="post">
						 <tr>
						 <td>总价：<em id="totalprice" style="font-size:18px;color:red;">0.00</em></td>
						 <input type="hidden" value="" id="subprice" name="subprice"/>z
						<td><button type="submit" class="btn2" onClick="suborders()">提交订单</button></td>
						</form>
						<td><a  href="${pageContext.request.contextPath}/before/clearcart" class="btn3">全部清空</a></td>
					</tr>
					</table>
				</div>
	</body>
</html>