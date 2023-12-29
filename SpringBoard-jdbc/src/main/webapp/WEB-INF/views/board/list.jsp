<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<!-- 로그인 세션 처리 -->
	<c:if test="${empty sessionId }">
		<script>
			alert("로그인 후 이용가능 합니다.");
			location.href="/user/login";
		</script>
	</c:if>
	
	<div id="content">
		<h2>글 목록</h2>
		<div id="list_logout">
			Hello ! ${sessionId }&nbsp; :D &nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/user/logout">[ Logout ]</a>
		</div>
		<div id="btn_main">
			<a href="/"><button>&laquo; Main </button></a>
		</div>
		
		
		<table>
			<thead>
				<tr>
					<th>번호</th> <th>제목</th> <th>글쓴이</th> <th>작성일</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${boardList }" var="board">
					<tr>
						<td>${board.id }</td>
						<td><a href="/board?id=${board.id }">${board.boardTitle }</a> </td>
						<td>${board.boardWriter }</td>
						<td>${board.createdTime }</td>
					</tr>
				</c:forEach>
			</tbody>
			
			<tfoot>
			
			</tfoot>
		</table>
		<div id="btn_newpost">
			<a href="/board/write"><button>New post &raquo;</button></a>
		</div>		
	</div>
</body>
</html>