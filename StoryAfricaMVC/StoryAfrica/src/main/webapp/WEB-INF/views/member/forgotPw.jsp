<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>비번을 잃어버렸다면, 이곳으로 오시개...왕!</h1>
	
	<form id="forgotPw">
		<div>
			아이디 : <input type="text" id="userid" name="userid">		
		</div>
		<div>
			이름 : <input type="text" id="username" name="username">		
		</div>
		<input type="submit" value="비밀번호찾기">
	</form>

<script>
	$(document).ready(function(){
		
		$('#forgotPw').submit(function(){

			$.ajax({
				url: 'findPw',
				type: 'post',
				data : {
					userid: $('#userid').val(),
					username : $('#username').val()
				},
				success : function(data){
					if(data>0) {
						alert('임시 비밀번호가 메일로 전송되었습니다!');
					} else {
						alert('개인 정보를 다시 확인해주세요! ');
					}
				}
			})
		})
		
	})
</script>
</body>
</html>