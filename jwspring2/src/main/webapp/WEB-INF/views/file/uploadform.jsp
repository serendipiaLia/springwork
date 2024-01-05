<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File upload</title>
</head>
<body>
	<form action="/file/upload" method="post" enctype="multipart/form-data">
		<h2>Add File</h2>
		<div>
			<p>
				<input type="file" name="filename">
			</p>
			<p>
				<input type="submit" value="send">
			</p>
		</div>
	</form>
	<p>저장된 파일 : ${filename }</p>
</body>
</html>