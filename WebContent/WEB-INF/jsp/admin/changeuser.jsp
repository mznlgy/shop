<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/chkupdateuser" method="post">
<input value="${userid}" name="user_id" type="hidden"/>
修改的用户名<input value="" name="username"/>
修改的密码<input value="" name="password"/>
修改的问题<input value="" name="question"/>
修改的答案<input value="" name="answer"/>
修改的邮箱<input value="" name="email"/>
<input type="submit" value="确认修改">
</form>
</body>
</html>