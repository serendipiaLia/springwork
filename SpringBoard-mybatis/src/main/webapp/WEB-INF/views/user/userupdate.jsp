<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"/>
	<div id="content">
		<h2>Edit</h2>
		<form action="/user/update" method="post">
		<input type="hidden" name="id" value="${user.id }"> <!-- where절에서 사용해야 하므로! -->
			<table class="userupdate">
				<tr>
					<td>
						<label>ID</label>
						<input type="text" name="userId" value="${user.userId }" readonly>
					</td>
				</tr>
				<tr>
					<td>
						<label>Password</label>
						<input type="password" name="userPasswd" value="${user.userPasswd }" >
					</td>
				</tr>
				<tr>
					<td>
						<label>Name</label>
						<input type="text" name="userName" value="${user.userName }" >
					</td>
				</tr>
				<tr>
					<td>
						<label>Age</label>
						<input type="text" name="userAge" value="${user.userAge }" >
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">Save</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
	
</body>
</html>