/**
 * 회원가입 중복 아이디 체크
 */
$(document).ready(function(){
	
	//navbar link setting 
	$('#editorlist').click(function(){
		location.href="http://localhost:8080/sa/api/members";
	})
	
	
	//중복 아이디 체크 
	$('#inputEmail').focusout(function(){
		
		//ajax 비동기 통신 id 전송 사용 유무에 대한 결과 값을 반환 
		$.ajax({
			url: 'member/regIdChk', 
			type:'get',
			data: {
				id: $(this).val()
			},
			success : function(data){
				//alert(data);
				
				$('#idchkmsg').html('');
				$('#idchkmsg').removeClass('blue');
				$('#idchkmsg').removeClass('red');
				
				//if(data == 'Y') { //idChk()
				if(data == "Y") { //idChk2 
								//data.equals("Y") 로 하니까 script 실행 안됨
					alert('사용가능한 아이디입니다!');
					$('#idchk').prop('checked', true);
					//$('#idchkmsg').html('사용가능한 멋진 아이디 입니다!');
					//$('#idchkmsg').addClass('blue');
				} else {
					alert('사용 중인 아이디이거나 탈퇴한 아이디 입니다!');
					$('#idchk').prop('checked', false);
					//$('#idchkmsg').html('사용중인 아이디이거나  탈퇴한 아이디입니다! ');
					//$('#idchkmsg').addClass('red');
				}
			}
		});
		
		
		//입력사항 체크
		
	});	
});