<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입결과</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="static/login.css" rel="stylesheet" type="text/css">
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
	.form-signin input[type="button"] {
	  margin-bottom: 5px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	.profile-img {
		width: 150px;
		height: 150px;
		margin-bottom: 50px;
		border-radius: 100px;
		border: 10px solid #FAD02C;
	}
</style>
</head>

<body class="text-center">
	<!-- content start -->
	<form class="form-signin">	
		<img class="profile-img" src="${member.userphoto}">
		<h4 class="mb-3 font-weight-normal">${resultCnt}명의 회원님이 회원가입을 완료하였습니다.</h4>
		
		<label for="inputEmail" class="sr-only">이메일 주소(아이디)</label>
		<input type="email" value="${member.userid}" class="form-control" disabled>
		
		<label for="inputPassword" class="sr-only">비밀번호</label>
		<input type="password" value="${member.userpw}" class="form-control" disabled>
		
		<label for="inputUsername" class="sr-only">이름</label>
		<input type="text" value="${member.username}" class="form-control" disabled>
		
	   	<a href="<c:url value='loginForm.do'/>"><input type="button" value="로그인하기 " class="btn btn-lg btn-primary btn-block" ></a>
 		<a href="<c:url value='/*.do'/>"><input type="button" value="홈으로 " class="btn btn-lg btn-primary btn-block" ></a>
 		
 		<p class="mt-5 mb-3 text-muted">&copy; 2019</p>	
	</form>
	<!-- content end -->		
</body>
</html>