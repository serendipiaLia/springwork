<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join form</title>
</head>
<body>
	<h2>Join</h2>
	<form action="/user/join" method="post">
		<p>
			<label>Name</label>
			<input type="text" name="name" placeholder="name..">
		</p>
		<p>
			<label>Age</label>
			<input type="text" name="age" placeholder="age..">
		</p>
		<p>
			<input type="submit" value="Join us">
		</p>
	</form>
</body>
</html>