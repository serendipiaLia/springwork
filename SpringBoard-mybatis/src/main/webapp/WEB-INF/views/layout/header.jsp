<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../resources/css/style.css"> 
<header>
	<div id="logo">
		<h1><a href="/">KH-IT</a></h1>
	</div>
	
	<nav class="header_menu">
		<c:choose>
			<c:when test="${empty sessionId }">
				<ul>
					<li><a href="/user/login">[ Login ]</a></li>
					<li><a href="/user/join">[ Join ]</a></li>
					<li><a href="/user/">[ Users ]</a></li>
					<li><a href="/board/write">[ New Post ]</a></li> <!-- 로그인한 사람만 작성가능하게 바꾸기(alert).. -->
					<li><a href="/board/paging">[ Posts ]</a></li>
				</ul>		
			</c:when>
			<c:otherwise>
				<ul>
					<li><a href="/user/logout">${sessionId } [ Logout ]</a></li>
					<li><a href="/user/update">[ MyPage ]</a></li>
					<li><a href="/user/">[ Users ]</a></li>
					<li><a href="/board/write">[ New Post ]</a></li>
					<li><a href="/board/paging">[ Posts ]</a></li>
				</ul>		
			</c:otherwise>
		</c:choose>
	</nav>
</header>