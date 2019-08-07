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

<link href="<c:url value='/static/login.css'/>" rel="stylesheet" type="text/css">
<style>
	.form-signin input[type="password"] {
	  margin-bottom: -1px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	.form-signin input[type="text"] {
	  margin-bottom: -1px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	.form-signin input[type="button"] {
	  margin-bottom: 5px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
</style>
</head>

<body class="text-center">
	<!-- content start -->
	<c:if test="${resultCnt == 1}">
		<form class="form-signin">
			<img class="profile-img" src="<c:url value='/uploadedfile/userphoto/${member.userphoto}'/>" alt="" width="72" height="72">
			<h4 class="mb-3 font-weight-normal">${resultCnt}명의 회원님이 회원가입을 완료하였습니다.</h4>
			
			<label for="inputEmail" class="sr-only">이메일 주소(아이디)</label>
			<input type="text" value="${member.userid}" class="form-control" disabled>
			
			<label for="inputPassword" class="sr-only">비밀번호</label>
			<input type="password" value="${member.userpw}" class="form-control" disabled>
			
			<label for="inputUsername" class="sr-only">이름</label>
			<input type="text" value="${member.username}" class="form-control" disabled>
			
			<label>
				<input type="file" name="uphoto" class="form-control" placeholder="">
			</label>
			
		   	<a href="<c:url value='/member/loginform'/>"><input type="button" value="로그인하기 " class="btn btn-lg btn-primary btn-block" ></a>
	 		<a href="<c:url value='/'/>"><input type="button" value="홈으로 " class="btn btn-lg btn-primary btn-block" ></a>
	 		
	 		<p class="mt-5 mb-3 text-muted">&copy; 2019</p>	
		</form>
	</c:if>
	
	<c:if test="${resultCnt!= 1}">
		<script>
			alert('회원가입에 실패하였습니다. 다시 시도해주세요!');
			location.href="<c:url value='/'/>";
		</script>
	</c:if>
	
	<!-- content end -->		
</body>
</html>