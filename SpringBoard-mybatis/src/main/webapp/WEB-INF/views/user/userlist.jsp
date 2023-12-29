<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<div id="content">
		<h2>List of Users</h2>
		<table class="UserlistForm">
			<tr>
				<th>No.</th> <th>ID</th> <th>Password</th> <th>Name</th> <th>Age</th>
			</tr>
			<c:forEach items="${userList }" var="user">
				<tr>
					<td>${user.id }</td>
					<td><a href="/user?id=${user.id}"> ${user.userId }</a></td>
					<td>${user.userPasswd }</td>
					<td>${user.userName }</td>
					<td>${user.userAge }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>