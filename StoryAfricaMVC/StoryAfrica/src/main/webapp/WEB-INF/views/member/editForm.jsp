<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="<c:url value='/static/default.css'/>" rel="stylesheet" type="text/css">
<style>
	.form-signin input[type="password"] {
	  margin-bottom: -1px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	.form-signin input[type="text"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	#idchk {
		display: none;
	}
	
	.blue {
		color: blue;
	}
	.red {
		color: red;
	}
</style>
</head>

<body class="text-center">
	<!-- content start -->
	<div id="editForm">
		<div class="container">
			<form id="edit" action="editMember" method="post" class="form-signin" 
				enctype="multipart/form-data">
				<img class="profile-img" src="<c:url value='/uploadedfile/userphoto/${member.userphoto}'/>" alt="" width="72" height="72">
				<h1 class="h3 mb-3 font-weight-normal">회원수정</h1>
		
				<input type="hidden" name="idx" value="${member.idx}"> <!-- 회원 고유번호-->
				
				<label for="inputEmail" class="sr-only">아이디</label>
				<input type="text" name="userid" id="inputEmail" class="form-control" 
					value="${member.userid}" readonly>
				
				<label for="inputPassword" class="sr-only">비밀번호</label>
				<input type="password" name="userpw" id="inputPassword" 
					class="form-control" placeholder="비밀번호" required>
					
				<!-- <label for="inputPassword" class="sr-only">비밀번호확인</label>
				<input type="password" name="userpw" id="inputPassword" 
					class="form-control" placeholder="비밀번호확인" required> -->
				
				<label for="inputUsername" class="sr-only">이름</label>
				<input type="text" name="username" id="inputUsername" 
					class="form-control" value="${member.username}" required>
				
				<input type="file" name="userphoto" class="form-control">
				<input type="hidden" name="oldPhoto" value="${member.userphoto}">
				
				<input type="submit" value="회원수정" class="btn btn-lg btn-primary btn-block" >
			   	<a href="<c:url value="/"/>" class="btn btn-lg btn-primary btn-block" >
			   		홈으로
			   	</a>
		 		<p class="mt-5 mb-3 text-muted">&copy; 2019</p>					
				
			</form>
		</div>
	</div>
	<!-- content end -->
</body>
</html>