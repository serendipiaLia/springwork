<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" href="../resources/css/style.css"> 
</head>
<body>
	<jsp:include page="../layout/header.jsp"/>
	<div id="content">
		<h2>List of Users</h2>
		<table class="userlistForm">
			<tr>
				<th>No.</th> <th>ID</th> <th>Password</th> <th>Name</th> <th>Age</th> <th>Delete</th>
			</tr>
			<c:forEach items="${userList }" var="user">
				<tr>
					<td>${user.id }</td>
					<td><a href="/user?id=${user.id}"> ${user.userId }</a></td>
					<td>${user.userPasswd }</td>
					<td>${user.userName }</td>
					<td>${user.userAge }</td>
					<td>
						<a href="/user/delete?id=${user.id }" onclick="return confirm('정말 삭제하시겠습니까?')">
							<button>Delete</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>