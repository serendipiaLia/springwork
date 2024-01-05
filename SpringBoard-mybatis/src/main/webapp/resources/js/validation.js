// join.jsp 와 연결

let checkUser = function(){
		/*	alert("Welcome ! :D")  */
		// 아이디는 4자 이상 15자 까지 입력하세요
		// 비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상 입력하세요
		// 이름은 한글로 입력하세요
		// 나이는 숫자로 입력하세요
		
		let form = document.userform;
		let userId = document.getElementById("userId").value; // 아이디
		let userPw = document.getElementById("userPasswd").value; // 비밀번호
		let userName = document.getElementById("userName").value; // 이름
		let userAge = document.getElementById("userAge").value; // 나이
		
		//정규표현식
		  let regPw1 = /[0-9]+/     //숫자
		  let regPw2 = /[a-zA-Z]+/  //영문자
		  let regPw3 = /[~!@#$%^&*()\-=]+/ //특수문자
		  let regName = /^[가-힣 ]+$/  //한글만
		
		if(userId.length < 4 || userId.length > 15){
		  alert("아이디는 4자 이상 15자까지 입력해주세요");
		  document.getElementById("userId").select();
		  return false;
		}else if(userPw.length < 8 || !regPw1.test(userPw) || !regPw2.test(userPw) || !regPw3.test(userPw)){
		 	alert("비밀번호는 영문자, 숫자, \n특수문자 포함 8자 이상 입력해주세요");
		 	document.getElementById("userPasswd").select();
			return false;
		}else if(!regName.test(userName)){ // 이름이 정규식에 일치하지 않으면,
			alert("이름은 한글로 입력하세요")
			document.getElementById("userName").select();
			return false;
		}else if(isNaN(userAge) || userAge == ""){ // 숫자가 아니거나 || 문자인 경우
			alert("나이는 숫자로 입력하세요")
			document.getElementById("userAge").select();
			return false;
			
		}else{
			form.submit(); // 유효하면 폼에 전송
		}
	} //checkUser  
	
	/* ID 중복검사 순서
		1. 아이디의 입력값 가져오기
		2. 입력값을 서버에 전송하고 중복된 아이디가 있는지 확인
		
	*/
	let checkId = function(){
// 		alert("ID중복검사를 해주세요!")
		let userId = document.getElementById("userId"). value;
		let checkResult = document.getElementById("check-result");
		console.log(userId);
		
		if(userId != ""){
		$.ajax({
			// 요청 방식 : post | url : /user/checkuserid | 데이터 : userId
			type : "post", url : "/user/checkuserid", data : {"userId" : userId},
			// 서버에서의 응답이 성공과 실패로 나뉨
			success : function(response){
				console.log(response);
				if(response == "usable"){
					checkResult.innerHTML = "사용가능한 아이디 입니다.";
					checkResult.style.color = "blue";
				}else{
					checkResult.innerHTML = "이미 사용중인 아이디 입니다.";
					checkResult.style.color = "red";
				}
			},
			error : function(error){
				console.log("Error!", error);
			}
		});
		}
	} // checkId