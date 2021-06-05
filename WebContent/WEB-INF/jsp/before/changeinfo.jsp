<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
	<link href="<%=request.getContextPath()%>/css/before/findpwd.css" rel="stylesheet" type="text/css">
<script>
function check(){
	if(form_ans.password.value==""){
			alert("请填写密码！");
			return false;
			}else if(form_ans.password.value.length<8 || form_ans.password.value.length>20){
				alert("密码为8-20位");
				return false;
			}else{
		return true;
		}
}
</script>
</head>
<body>
    <div class="rg_layout">
        <div class = "rg_left">
            <p>修改密码</p>
        </div>
     <div class = "rg_center">
          <div class="rg_form">
         <form action="${pageContext.request.contextPath }/before/changeinfo" method="post" id="form_ans">
         <table >
         <tr>
          <h3>${message}</h3>
         	<td class="td_left"><label for="username"></label> 密码</td>
        	<td class="td_right">
        	<input name="username" value="${username}" type="hidden" />
        	<input class="inputinfo" type="text" name="password" placeholder="请输入新密码" />
        	</td>
        	<td class="forgetpwd"></td>
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