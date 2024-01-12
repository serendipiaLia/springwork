<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<style>
	.content{margin-left:30px;}
	.content h4 a{text-decoration:none; color:sandybrown;}
</style>
</head>
<body>
	<div class="content">
		<h2>${sessionEmail }님 환영합니다.</h2>
		<h4><button type="button" onclick="update()">[ Edit My Info ]</button></h4>
		<h4><button type="button" onclick="logout()">[ Logout ]</button></h4>
		<h4><button type="button" onclick="index()">[ Home ]</button></h4>
	</div>

<script>
	let index = function(){
		location.href = "/";
	}
	
	let logout = function(){
		location.href = "/member/logout";
	}
	
	let update = function(){
		location.href = "/member/update";
	}
</script>
</body>
</html>