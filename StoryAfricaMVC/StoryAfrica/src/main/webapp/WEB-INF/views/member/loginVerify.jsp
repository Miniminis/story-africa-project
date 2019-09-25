<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
#emailVerifySection {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>
	<section id="emailVerifySection">
		<h2>이메일 인증을 완료한 후, 로그인 할 수 있습니다! </h2>
		<a href="#" id="resendMail">재 인증 메일 보내기</a>
	</section>
	
<script>
	$(document).ready(function(){
		
		$('#resendMail').click(function(){
			$.ajax({
				url: 'reverify',
				type: 'post',
				success: function(data) {
					if(data >0) {
						alert('재인증 메일이 발송되었습니다. 메일의 링크를 통해 인증을 완료해주세요!');
					}
				}
			})
			return false; //a 태그가 원래 가지고 있는 속성인 페이지 속성을 제어해줌 
		})
	})
	
</script>
</body>
</html>
