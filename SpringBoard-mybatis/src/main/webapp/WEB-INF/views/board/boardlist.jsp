<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<link rel="stylesheet" href="../resources/css/style.css"> 
</head>
<body>
	<jsp:include page="../layout/header.jsp"/>
	<div id="content">
		<h2>Posts..</h2>
		<table class="boardlist">
			<thead>
				<tr class="boardlist_title">
					<td>No.</td>
					<td>Title</td>
					<td>Writer</td>
					<td>Hit</td>
					<td>Upload date</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList }" var="board">
				<tr class="boardlist_content">
					<td>${board.id }</td>				
					<td><a href="/board?id=${board.id }" style="color:sandybrown;"> ${board.boardTitle } </a></td>				
					<td>${board.userId }</td>				
					<td>${board.hit }</td>				
					<td>
						<!-- 수정일이 있는 경우 수정일 표시, 없는 경우 작성일만 표시 -->
						<c:choose > 
							<c:when test="${not empty board.updatedTime }"> <!-- 수정일이ㅣ 있으면  -->
							 	<fmt:formatDate value="${board.updatedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</c:when>
							<c:otherwise>
								<fmt:formatDate value="${board.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</c:otherwise>
						</c:choose>
					</td>				
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 글쓰기 버튼 -->
		<div>
			<a href="/board/write"><button>New post</button></a>
		</div>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>