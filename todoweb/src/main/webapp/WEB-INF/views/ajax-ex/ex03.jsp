<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax-study</title>
<style>
	.content{margin-left:30px;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="content">
		<h2>Ajax 실습하기</h2>
		<p>3. GET 요청(데이터 전달)</p>
		<p><button type="button" onclick="myFunction()">전송</button></p>
	</div>
	
<script>
// Ajax는 Jquery 라이프러리를 import해서 사용해야 함
// ajax 함수는 객체로 구성됨 >> { "key" : value } / 객체가 여러개면 >>  { ,  ,  , }
	const myFunction = 	function(){
// 		alert("test...");
		$.ajax({
			// 요청 방식 : GET, 요청 주소 : /ex01 , (함수) - 성공/실패
			// 자바스크립트 객체 : 키 값은 문자열로 함 (""생략가능)
			type : "GET",
			url : "/ex03",
			data : {greet : "Hi~",
					num : 11	
					},
			success : function(res){
				console.log("성공", res); // res는 서버에서 보내주는 자료
				if(res == "success"){
					alert("처리완료");
				}
			}, 
			error : function(){
				console.log("실패");
			}
		});
	}
</script>
</body>
</html>