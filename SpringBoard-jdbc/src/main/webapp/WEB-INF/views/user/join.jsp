<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h2>Join us! :D</h2>
		<form action="/user/join" method="post">
		<table class="joinForm">
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
				<td>
					<label>Name</label>
					<input type="text" name="userName" placeholder="name...">
				</td>
			</tr>
			<tr>
				<td>
					<label>Age</label>
					<input type="text" name="userAge" placeholder="age..">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		
		</table>
		</form>
		
	</div>
</body>
</html>