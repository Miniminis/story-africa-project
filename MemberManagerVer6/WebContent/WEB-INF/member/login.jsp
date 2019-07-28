<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/cover/">
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="static/login.css" rel="stylesheet" type="text/css">

</head>
<body class="text-center">
	<!-- content start -->
	<form action="loginProcess.do" method="post" class="form-signin">
		<img class="profile-img" src="image/zootopia_1.jpg">
		<h1 class="h3 mb-3 font-weight-normal">로그인</h1>
		
		<label for="inputEmail" class="sr-only">이메일 주소(아이디)</label>
		<input type="email" id="inputEmail" name="userid" class="form-control" placeholder="이메일 주소(아이디)" required autofocus>
		
		<label for="inputPassword" class="sr-only">비밀번호</label>
		<input type="password" id="inputPassword" name="userpw"  class="form-control" placeholder="비밀번호" required>
		
		<div class="checkbox mb-3">
		    <label>
		      <input type="checkbox" id="rememberMe" name="autologin" value="saveID"> 아이디 저장하기
		    </label>
	    </div>
	   
	   <input type="submit" value="로그인" class="btn btn-lg btn-block btn-primary" >
	   <a href="<c:url value="/*.do"/>" class="btn btn-lg btn-primary btn-block" >홈으로</a>
 		<p class="mt-5 mb-3 text-muted">&copy; 2019</p>				
	</form>
	<!-- content end -->
</body>
</html>