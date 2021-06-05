<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta chatset="UTF-8">
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/before/index.css"/>
<script type="text/javascript">
function check(){
	if(form_info.username.value==""){
		alert("用户名不能为空");
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body>
    <form action="${pageContext.request.contextPath }/before/chklogin" method="post" id="form_info">
    <h2>
    <img class="welcome" src="<%=request.getContextPath()%>/images/welcome.png"/>
    	欢迎来到桃子商城，请先登录</h2>
        <div class="login-box">
            <h3>${msg}</h3>
            <h1>登录</h1> 
            <div class="form">
                <div class="item"> 
                    <input type="text" placeholder="输入用户名" name="username">
                </div>
                <div class="item">
                 <i class="fa fa-key"></i>
                    <input type="password" placeholder="输入密码" name="password">
                </div>
            </div>
            <input type="submit" value="登录" class="submit" onClick="return check()"/> 
            <button type="button" onClick="window.location='${pageContext.request.contextPath }/before/register'">注册</button>
            <a class="findpwd" href="${pageContext.request.contextPath }/before/findpwd">找回密码</a>
        </div>
    </form>
</body>
</html>