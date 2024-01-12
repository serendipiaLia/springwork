<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	.content{margin-left:30px;}
</style>
</head>
<body>
	<div class="content">
		<h2>Login..</h2>
		<form action="/member/login" method="post">
			<p><input type="text" name="email" placeholder="Email.."></p>
			<p><input type="password" name="password" placeholder="Password.."></p>
			
			<p><input type="submit" value="Login">
				<input type="reset" value="Cancel">
				<!-- main으로 가는 버튼 만들기!! -->
			</p>
		</form>
	</div>
</body>
</html>