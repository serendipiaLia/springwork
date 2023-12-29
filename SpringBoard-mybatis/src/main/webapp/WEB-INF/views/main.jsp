<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH-IT Main</title>
<link rel="stylesheet" href="../resources/css/style.css"> 
</head>
<!-- 로그인 성공시 접속되는 화면!  -->
<body>
	<h1 id="main_h1">Welcome! <span>${sessionId }</span> :D</h1>
	<h3 id="main_h3">
		<button onclick = "update()">My info.Edit</button>
		<button onclick = "logout()">Logout</button>
		<button onclick = "goindex()">Main</button>
	</h3>
	
	<script>
		const logout = () => {
			location.href = "/user/logout";
		}
		const update = () => {
			location.href = "/user/update";
		}
		const goindex = () => {
			location.href = "/";
		}
	</script>
</body>
</html>