<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<c:if test="${empty sessionId }">
		<script>
			alert("로그인 후 이용 가능합니다.");
			location.href = "/user/login";
		</script>
	</c:if>
	<jsp:include page="../layout/header.jsp"/>
	<div id="content">
		<h2>New Post!</h2>
		<form action="/board/write" method="post">
		<table class="writeForm">
			<tr>
				<td>
					<input type="text" name="boardTitle" placeholder="title.." required>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="userId" value="${sessionId}" readonly required>
				</td>
			</tr>
			<tr>
				<td>
					<textarea rows="5" cols="50" name="boardContent" placeholder="write a new caption..."></textarea> 
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Upload">
					<input type="reset" value="Cancel">
				</td>
			</tr>
			
		</table>
		</form>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>