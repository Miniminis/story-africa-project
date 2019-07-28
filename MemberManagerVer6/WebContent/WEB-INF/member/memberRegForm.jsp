<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
		$(document).ready(function(){
			
			//중복 아이디 체크 
			$('#idchk').click(function(){
				//ajax 비동기 통신 id 전송 사용 유무에 대한 결과 값을 반환 
				$.ajax({
					url: 'regIdChk.do', 
					type:'get',
					data: {
						id: $('#inputEmail').val()
					},
					success : function(data){
						//alert(data);
						
						//$('#idchkmsg').html('');
						//$('#idchkmsg').removeClass('blue');
						//$('#idchkmsg').removeClass('red');
						
						if(data=='Y') {
							alert('사용가능한 아이디입니다!');
							$('#idchk').prop('checked', true);
							//$('#idchkmsg').html('사용가능한 멋진 아이디 입니다!');
							//$('#idchkmsg').addClass('blue');
						} else if(data=='N'){
							alert('사용 중인 아이디이거나 탈퇴한 아이디 입니다!');
							$('#idchk').prop('checked', false);
							//$('#idchkmsg').html('사용중인 아이디이거나  탈퇴한 아이디입니다! ');
							//$('#idchkmsg').addClass('red');
						} else {
							alert('올바른 아이디 값이 아닙니다!');
							$('#idchk').prop('checked', false);
						}
					}
				});
			});
			
			//입력사항 체크
			
			
		});
				
		
</script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="static/login.css" rel="stylesheet" type="text/css">
<style>
	.form-signin input[type="password"],
	.form-signin input[type="text"] {
	  margin-bottom: -1px;
	  border-radius: 0;
	}
	
	.form-signin input[type="file"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	
	/* #idchk {
		display: none;
	}
	
	.blue {
		color: blue;
	}
	.red {
		color: red;
	}*/
</style>
</head>

<body class="text-center">
	<!-- content start -->
	<form action="regMember.do" method="post" class="form-signin" enctype="multipart/form-data">
		<img class="profile-img" src="image/zootopia_1.jpg">
		<h1 class="h3 mb-3 font-weight-normal">회원가입</h1>

		<label for="inputEmail" class="sr-only">이메일 주소(아이디)</label>
		<input type="email" name="userid" id="inputEmail" class="form-control" placeholder="이메일 주소(아이디)" required autofocus>
		<!-- <span id="idchkmsg"></span> -->
		
		<label for="inputPassword" class="sr-only">비밀번호</label>
		<input type="password" name="userpw" id="inputPassword" class="form-control" placeholder="비밀번호" required>
		
		<label for="inputUsername" class="sr-only">이름</label>
		<input type="text" name="username" id="inputUsername" class="form-control" placeholder="이름" required>
		
		<label for ="inputUserPhoto" class="sr-only"> 프로필사진 </label>
		<input type="file" name="userphoto" id="inputUserPhoto" class="form-control">
		
	    <label class="checkbox mb-3">
	    	<input type="checkbox" id="idchk"> 아이디 중복체크
	    </label>
		
		
		<input type="submit" value="회원가입" class="btn btn-lg btn-primary btn-block" >
	   	<a href="<c:url value="/*.do"/>" class="btn btn-lg btn-primary btn-block" >홈으로</a>
 		<p class="mt-5 mb-3 text-muted">&copy; 2019</p>					
		
	</form>
	<!-- content end -->
</body>
</html>