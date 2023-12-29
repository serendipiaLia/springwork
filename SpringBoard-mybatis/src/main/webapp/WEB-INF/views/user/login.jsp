<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div id="content">
		<h2>Login</h2>
		<form action="/user/login" method="post">
		<table class="loginForm">
			<tr>
				<td>
					<label>ID</label>
					<input type="text" name="userId" placeholder="id..">
				</td>
			</tr>
			<tr>
				<td>
					<label>Password</label>
					<input type="password" name="userPasswd" placeholder="password..">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Login">
					<input type="reset" value="Cancel">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>