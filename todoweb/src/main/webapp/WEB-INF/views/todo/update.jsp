<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT</title>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../layout/header.jsp" />
		
		<!-- 등록 -->
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<div class="input-group mb-3">
							<span class="input-group-text">번호</span>
							<input type="text" name="tno" class="form-control" value="${todo.tno}" readonly>
						</div>
						
						<div class="input-group mb-3">
							<span class="input-group-text">할 일</span>
							<input type="text" name="title" class="form-control" value="${todo.title}">
						</div>
						
						<div class="input-group mb-3">
							<span class="input-group-text">작성자</span>
							<input type="text" name="writer" class="form-control" value="${todo.writer}">
						</div>
						
						<div class="my-4">
							<div class="float-end">
								<button type="submit" class="btn btn-primary">수정</button>
								<button type="button" class="btn btn-danger" onclick="return confirm('정말로  삭제하시겠습니까?')">삭제</button>
								<button type="button" class="btn btn-secondary">목록</button>
							</div>
						</div> <!-- 버튼 닫기 -->
					
					</div> <!-- card-body -->
				</div>
			</div>
		</div>
		
		<jsp:include page="../layout/footer.jsp" />
		
		<script>
		// 목록 버튼
			let listBtn = document.querySelector(".btn-secondary");
			
			listBtn.addEventListener("click", function(e){
				location.href = "/todo/list";
				
			});
		// 삭제 버튼
			let delBtn = document.querySelector(".btn-danger");
			let tno = '${todo.tno}';
			
			delBtn.addEventListener("click", function(e){
				location.href = "/todo/delete?tno=" + tno;
			})
				
			
		</script>
	</div>
</body>
</html>