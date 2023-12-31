<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 폼</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h2>Write a new caption..</h2>
		<form action="/board/write" method="post">
		<table class="writeForm">
			<tr>
				<td>
					<label>글 제목</label>
					<input type="text" name="boardTitle">
				</td>
			</tr>
			<tr>
				<td>
					<label>글쓴이</label>
					<input type="text" name="boardWriter" value="${sessionId }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<label>글 내용</label>
					<textarea rows="5" cols="50" name="boardContent"></textarea> <!-- 5행 50자 -->
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		
		</table>
		</form>
		
	</div>
</body>
</html>