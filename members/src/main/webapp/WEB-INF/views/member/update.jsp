<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
	.content{margin-left:30px;}
</style>
</head>
<body>
	<div class="content">
		<h2>User Info.</h2>
		<form action="/member/update" method="post" name="updateform">
			<p>
				<label>번호</label>
				<input type="text" name="id" value="${member.id } " readonly >
			</p>
			<p>
				<label>이메일</label>
				<input type="text" name="email" value="${member.email }" >
			</p>
			<p>
				<label>비밀번호</label>
				<input type="text" name="password" value="${member.password }" >
			</p>
			<p>
				<label>이름</label>
				<input type="text" name="name" value="${member.name }" >
			</p>
			<p>
				<label>나이</label>
				<input type="text" name="age" value="${member.age }" >
			</p>
			
			<p><button type="button" onclick="update()">Save</button> <!-- save하고 회원 목록으로.. -->
				<button type="button" onclick="back()">Back</button>
			</p>
		</form>
	</div>
<script>
	// 수정 처리
	const update = function(){
		document.updateform.submit();
	}
	// 이전 Back 버튼
	const back = function(){
		location.href="/main";
	}
	
	
</script>	
</body>
</html>