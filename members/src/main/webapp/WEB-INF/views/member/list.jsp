<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
   .content{margin-left: 30px;}
   table{border: 2px solid #ccc; border-collapse:collapse;}
   table th, td{border: 1px solid #ccc; padding: 8px;}
</style>
</head>
<body>
   <div class="content">
      <h2>회원 목록</h2>
      <div>
         <table>
            <thead>
               <tr>
                  <th>No.</th>
                  <th>Email</th>
                  <th>Password</th>
                  <th>Name</th>
                  <th>Age</th>
                  <th>View</th>
                  <th>Delete</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${memberList}" var="member">
               <tr>
                  <td>${member.id}</td>   
                  <td>${member.email}</td>   
                  <td>${member.password}</td>   
                  <td>${member.name}</td>   
                  <td>${member.age}</td>
                  <td><button type="button" onclick="detail('${member.id}')">조회</button></td>
                  <td><button type="button" onclick="deleteFn('${member.id}')">삭제</button></td>
               </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </div>
<script>
 //let mid = "${member.id}";
 	// 멤버 조회
   const detail = function(mid) {
      location.href="/member?id=" + mid;
   }
   // 멤버 삭제
   const deleteFn = function(mid){ // delete만 사용하면 예약어이기 때문에 , 다른 이름(deleteFn)으로 사용
	   if(confirm("정말로 삭제하시겠습니까?")){
		   location.href="/member/delete?id=" + mid;
	   }
	  
   }
</script>
</body>
</html>