<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h2>Edit..</h2>
		<form action="/board/update" method="post">
		<input type="hidden" name="id" value="${board.id }"> <!-- 안보이게 전달  -->
			<table class="writeForm">
				<tr>
					<td>
						<input type="text" name="boardTitle" value="${board.boardTitle }" >
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="boardWriter" value="${board.boardWriter }" readonly>
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="5" cols="50" name="boardContent" >${board.boardContent }</textarea> <!-- 5행 50자 -->
					</td>
				</tr>
				<tr>
					<td>
						<button type="submit">Save</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>