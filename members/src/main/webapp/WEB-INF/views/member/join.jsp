<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	.content{margin-left:30px;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="content">
		<h2>Join Us!</h2>
		<form action="/member/join" method="post">
			<p>
				<input type="text" name="email" onblur="checkEmail()" placeholder="Email">
			</p>
				<p id="check-result"></p>
			<p>
				<input type="password" name="password" placeholder="Password..">
			</p>
			<p>
				<input type="text" name="name" placeholder="Name...">
			</p>
			<p><input type="text" name="age" placeholder="Age.."></p>
			
			<p>
				<input type="submit" value="Join">
				<input type="reset" value="Cancel">
			</p>
		</form>
	</div>
<script>
	// 이메일 입력값을 가져오고, 입력값을 서버(컨트롤러)로 전송>>ajax()
	// 이메일을 확인(check) 후 사용 가능 여부를 입력상자 아래에 표시
	const checkEmail = function(){
		let inputEmail = document.getElementById("email").value();
		let checkResult = document.getElementById("check-result");
		console.log("Email : " , email);
		
		$.ajax({
			// 요청 방식, url, data, 함수(성공/실패)
			type:"POST", 
			url:"/member/checkemail",
			data:{ email: inputEmail },
			success : function(res){
				console.log("성공 : ", res); 
				if(res == "OK"){
					checkResult.innerHTML = "사용가능 한 이메일 입니다.";
					checkResult.style.color = "blue";
				}else{
					checkResult.innerHTML = "이미 가입된 이메일 입니다.";
					checkResult.style.color = "red";
				}
			},
			error : function(err){
				console.log("실패 : " , err);
			}
		})
	}
</script>
</body>
</html>