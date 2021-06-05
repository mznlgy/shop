<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<html>
<head>
    <title>商品列表</title>
    <meta charset="utf-8">
	   <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"></link>
	   <link href="<%=request.getContextPath()%>/css/before/search.css" rel="stylesheet" type="text/css">

</head>
<body>
<!-- 头部信息 -->
	<div class="header_con">
		<div class="header">
			<div class="welcome"><a href="${pageContext.request.contextPath}/before/first"><img class="logo" alt="" src="<%=request.getContextPath()%>/images/logo.jpg"></a></div>
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
				<h1>"${keyword}"的搜索结果<i></i></h1>
			</div>
	
		</div>
	</div>
	<div id="main"> 
	<c:choose>
		<c:when test="${null==0}">
			没有找到相关商品
		</c:when>
	 <c:otherwise>
		 <ul>
		<c:forEach var="product" items="${searchlist}">
          <li>   
            <div class="sfz_01_34"><a href="${pageContext.request.contextPath}/before/product?product_id=${product.product_id}"><img src="${product.imgpath}" class="img_pro"></a>
            <p class="price">￥${product.price}</p>
            <p ><a class="name" href="${pageContext.request.contextPath}/before/product?product_id=${product.product_id}">${product.product_name}</a></p>
            </div>
        </li> 
	</c:forEach>
    </ul>
	 </c:otherwise>
    </c:choose>
	<table class="bottom_table" border="1" align="center" cellpadding="1" cellspacing="1"> 
		<tr>
		<td>共有${rescount}
			&nbsp;件商品&nbsp;&nbsp;&nbsp;&nbsp;
			第&nbsp;${thispage}&nbsp;页&nbsp;&nbsp;&nbsp;/共&nbsp;${pagecount}&nbsp;页
			<a class="page" href="${pageContext.request.contextPath}/before/search?requestpage=1&product_name=${keyword}"><font><i class="fa fa-fast-backward">首页</i></font></a>
			<c:choose>
				<c:when test="${thispage==1}">
					&nbsp;
				</c:when>
				<c:otherwise>
					<a class="page" href="${pageContext.request.contextPath}/before/search?requestpage=${thispage-1}&product_name=${keyword}"><font><i class="fa fa-backward">前一页</i></font></a>	
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${thispage==pagecount || pagecount==1}">
					&nbsp;
				</c:when>
				<c:otherwise>
				<a class="page" href="${pageContext.request.contextPath}/before/search?requestpage=${thispage+1}&product_name=${keyword}"><font><i class="fa fa-forward">下一页</i></font></a>
				</c:otherwise>
			</c:choose>
			<a class="page" href="${pageContext.request.contextPath}/before/search?requestpage=${pagecount}&product_name=${keyword}" title="尾页"><font><i class="fa fa-fast-forward">尾页</i></font></a>
			</td>
		</tr>
		</table>
</div>
</body>
</html>

