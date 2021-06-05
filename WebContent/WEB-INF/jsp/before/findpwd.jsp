<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
	<link href="<%=request.getContextPath()%>/css/before/findpwd.css" rel="stylesheet" type="text/css">
<script>
function check(){
	if(form_ans.username.value==""){
			alert("请填写用户名！");
			return false;
			}
		else{
		return true;
		}
}
</script>
</head>
<body>
    <div class="rg_layout">
        <div class = "rg_left">
            <p>找回密码</p>
        </div>
     <div class = "rg_center">
          <div class="rg_form">
         <form action="${pageContext.request.contextPath }/before/chkfindpwd" method="post" id="form_ans">
         <table >
         <tr>
          <h3>${message}</h3>
         	<td class="td_left"><label for="username"></label> 用户名</td>
        	<td class="td_right"><input class="inputinfo" type="text" name="username" placeholder="请输入用户名"><td class="forgetpwd"></td>
         </tr>
         <tr>
         	<td class="td_left"><label for="username"></label>电子邮箱</td>
        	<td class="td_right"><input class="inputinfo" type="email" name="email" placeholder="请输入电子邮箱"><td class="forgetpwd"></td>
        </tr>     
                        <tr>
  <td colspan="2" align="center"><input type="submit" class = "reg" value="提交" onClick="return check()"></td> 
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>