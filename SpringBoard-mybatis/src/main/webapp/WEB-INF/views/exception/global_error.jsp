<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<link rel="stylesheet" href="../resources/css/style.css"> 
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
	<h2>Error page..</h2>
	<h4>${exception.getMessage() }</h4>
<jsp:include page="../layout/footer.jsp"/>
</body>
</html>