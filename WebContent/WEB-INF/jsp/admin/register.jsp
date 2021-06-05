<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/before/register.css" />
<script type="text/javascript">
function check(){
	if(form_info.username.value==""){
			alert("请输入用户名");
			return false;
		}else if(form_info.password.value==""){
			alert("请输入密码");
			return false;
		}else if(form_info.email.value==""){
			alert("请输入邮箱");
			return false;
		}else if(form_info.answer.value.length>10){
			alert("用户名不能超过5位");
			return false;
		}else if(form_info.password.value.length>20 || form_info.password.value.length<8){
			alert("密码应为8到20位");
			return false;
		}else if(form_info.question.value.length>8){
			alert("问题字数不超过8位");
			return false;
			}
		else if(form_info.answer.value.length>8){
			alert("答案字数不超过8位");
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
            <p>新用户注册</p>
        </div>
     <div class = "rg_center">

          <div class="rg_form">
         <form action="${pageContext.request.contextPath}/admin/chkregister" method="post" id="form_info">
         <table>
         <tr>
         <td class="td_left">&nbsp;</td>
         <td class="td_right"> <h3>${message}<h3/></td>
         </tr>
          <tr>
          <td class="td_left"><label for="usename"></label> 用户名</td>
         <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名（不超过5位）"></td>
          </tr>
          <tr>
           <td class="td_left"><label for="password"></label> 密码</td>
           <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码（8到20位）"></td>
          </tr>
          <tr>
           <td class="td_left"><label for="email"></label> 邮箱</td>
           <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入你的邮箱"></td>
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