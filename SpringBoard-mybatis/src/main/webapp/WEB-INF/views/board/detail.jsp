<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>

</head>
<body>
	<jsp:include page="../layout/header.jsp"/>
	<div id="content">
		<h2>POST!</h2>
		<table class="board_detail">
			<tr>
				<td>
					<input type="text" name="boardTitle" value="${board.boardTitle }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="userId" value="${board.userId }" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<textarea rows="5" cols="60" name="board" readonly>${board.boardContent }</textarea>
				</td>
			</tr>
			<tr>
				<td>Hit : ${board.hit }</td>
			</tr>
			<tr class="B_detail_date">
				<!-- 수정일이 있는 경우 수정일 표시, 없는 경우 작성일만 표시 -->
				<c:choose > 
					<c:when test="${not empty board.updatedTime }"> <!-- 수정일이ㅣ 있으면  -->
					 	Modified date : <fmt:formatDate value="${board.updatedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</c:when>
					<c:otherwise>
						Date created : <fmt:formatDate value="${board.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr class="B_detail_btn">
				<td>
					<!-- 세션 적용 : 로그인 한 사용자만 수정 및 삭제 보임! ${board.id} -->
					<c:if test="${board.userId eq sessionId}">
						<a href="/board/update?id=${board.id }"><button>Edit</button></a>
						<a href="/board/delete?id=${board.id }" onclick="return confirm('정말 삭제하시겠습니까?')"><button>Delete</button></a>
					</c:if>
						<a href="/board/paging?page=${page}"><button>Posts..</button></a>
				</td>
			</tr>
		</table>
		<!-- 댓글 목록 -->
		<c:forEach items="${replyList }" var="reply">
			<div class="reply">
				<p>${reply.replyContent }</p>
				<p>
					<b>${reply.replyer }</b> <span>(작성일 : ${reply.createdTime } )</span>
				</p>
			</div>
		</c:forEach>
		
		<c:choose>
			<c:when test="${not empty sessionId}">
				<!-- 로그인 한 사용자만 댓글 등록 -->
				<form action="/reply/insert" method="post" name="replyform">
		 			<input type="hidden" name="boardId" value="${board.id }">
					<p><input type="text" name="replyer" value="${sessionId }"></p>
					<p>
						<textarea rows="3" cols="50" name="replyContent" id="replyContent" placeholder="add your comments..."></textarea>
					</p>
					<button type="button" onclick="checkReply()">comment!</button>
					
				</form>
			</c:when>
			<c:otherwise>
				<!-- 댓글 등록 시, 로그인 화면으로 이동 -->
				<div class="replylogin">
					<a href="/user/login">
						[ 로그인한 사용자만 댓글 등록 가능합니다. ]
					</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
	
<script>
	const checkReply = () => {
// 		alert("댓글 등록");
		// 댓글 등록이 비어있으면 "댓글을 입력해주세요"
		// 댓글 내용이 있으면 서버에 전송
		let content = document.getElementById("replyContent");
		
		if(content.value == ""){
			alert("댓글을 입력해 주세요");
			content.focus();
			return false;
		}else{
			document.replyform.submit();
		}
	}
</script>
</body>
</html>