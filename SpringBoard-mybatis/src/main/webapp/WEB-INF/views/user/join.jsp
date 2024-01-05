<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="content">
		<h2>Join us!</h2>
		<form action="/user/join" method="post" name="userform">
			<table class="joinForm">
				<tr>
					<td>
						<label>ID</label> 
						<input type="text" name="userId" id="userId" placeholder="id.." onblur="checkId()">
						<p id="check-result"></p>
					</td>
				</tr>
				<tr>
					<td><label>Password</label> <input type="password"
						name="userPasswd" id="userPasswd" placeholder="password.."
						required></td>
				</tr>
				<tr>
					<td><label>Name</label> <input type="text" name="userName"
						id="userName" placeholder="name..." required></td>
				</tr>
				<tr>
					<td><label>Age</label> <input type="text" name="userAge"
						id="userAge" placeholder="age.."></td>
				</tr>
				<tr>
					<td><input type="button" value="Join" onclick="checkUser()">
						<input type="reset" value="Cancel"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../layout/footer.jsp" />
<script src="/resources/js/validation.js"></script>

</body>
</html>