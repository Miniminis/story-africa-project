<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>로그인 인증 해야지 ㅠㅠㅠ </h1>
	
	<a href="#" id="resendMail">다시 인증 메일 보내기 gogo</a>
	
<script>
	$(document).ready(function(){
		
		$('#resendMail').click(function(){
			$.ajax({
				url: 'reverify',
				type: 'post',
				success: function(data) {
					if(data >0) {
						alert('재인증 메일이 발송되었음! 해당 링크로 회원가입 완료해주삼33');
					}
				}
			})
			return false; //a 태그가 원래 가지고 있는 속성인 페이지 속성을 제어해줌 
		})
	})
	
</script>
</body>
</html>
