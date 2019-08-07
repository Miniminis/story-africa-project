<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>회원삭제</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/cover/">
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="<c:url value='/static/login.css'/>" rel="stylesheet" type="text/css">

</head>
<body class="text-center">
	<!-- content start -->
	<c:if test="${sessionScope.LoginInfo ne null}">
		<form action="deleteProcess" method="post" class="form-signin">
			<img class="profile-img" src="<c:url value='/image/zootopia_1.jpg'/>">
			<h1 class="h3 mb-3 font-weight-normal">회원삭제</h1>
			
			<label for="inputPassword" class="sr-only">삭제하려면 비번 ㄱㄱ</label>
			<input type="password" id="inputPassword" name="userpwcheck" class="form-control" placeholder="비밀번호" required>
			
			<input type="hidden" name="memberIdx" value="${memberIdx}">
				   
		   <input type="submit" value="회원삭제" class="btn btn-lg btn-block btn-primary" >
		   <a href="<c:url value='/member/memberlist'/>" class="btn btn-lg btn-primary btn-block" >이전으로</a>
		   <a href="<c:url value='/'/>" class="btn btn-lg btn-primary btn-block" >홈으로</a>
	 		<p class="mt-5 mb-3 text-muted">&copy; 2019</p>				
		</form>
	</c:if>
	
	<c:if test="${sessionScope.LoginInfo eq null }">
		<script>
			alert('관리자의 로그인이 필요합니다!');
		</script>
	</c:if>
	
	
	<!-- content end -->
</body>
</html>
