<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세보기</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"/>
	<div id="content">
		<h2>Our User..</h2>
		<table class="userdetail">
			<tr>
				<td>
					<label>ID</label>
					<input type="text" name="userId" value="${user.userId }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<label>Password</label>
					<input type="password" name="userPasswd" value="${user.userPasswd }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<label>Name</label>
					<input type="text" name="userName" value="${user.userName }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<label>Age</label>
					<input type="text" name="userAge" value="${user.userAge }" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="list()">List of Users</button>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
	<script>
		const list = function(){
			location.href = "/user/";
		}
	</script>
</body>
</html>