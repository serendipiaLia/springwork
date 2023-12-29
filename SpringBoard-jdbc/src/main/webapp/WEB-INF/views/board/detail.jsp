<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h2>글 상세보기</h2>
		<table class="writeForm">
			<tr>
				<td>
					<input type="text" name="boardTitle" value="${board.boardTitle }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="boardWriter" value="${board.boardWriter }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<textarea rows="5" cols="50" name="boardContent" readonly>${board.boardContent }</textarea> <!-- 5행 50자 -->
				</td>
			</tr>
			<tr>
				<td>
					<!-- 로그인한 사람에게 수정, 삭제 버튼 보이기  -->
					<c:if test="${board.boardWriter eq sessionId }">
						<a href="/board/update?id=${board.id }">
							<button>Edit</button>
						</a>
						<a href="/board/delete?id=${board.id }" onclick="return confirm('정말로 삭제하시겠습니까?')">
							<button>Delete</button>
						</a>
					</c:if>	
					<a href="/board/list"><button>Back</button></a>
				</td>
			</tr>
		
		</table>
		
	</div>
</body>
</html>