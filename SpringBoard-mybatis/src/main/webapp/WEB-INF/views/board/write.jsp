<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div id="content">
		<h2>New Post!</h2>
		<form action="/board/write" method="post">
		<table class="writeForm">
			<tr>
				<td>
					<input type="text" name="boardTitle" placeholder="title..">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="boardWriter" value="${sessionId}" readonly>
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
</body>
</html>