$(document).ready(function(){
	
	selectMemberList();
	
	//회원등록
    $('#regform').submit(function(){
        
        var reginfo = $('#regform').serialize();
        /* var reginfo ={
        		userid : $('#userid').val(),
        		userpw : $('#userpw').val(),
        		username : $('#username').val()
        } */
        
        $.ajax({
            url: 'http://localhost:8080/sa/rest/users',
            type: 'POST',
            data: reginfo, //일반 자바 객체 타입 
            /*data: { //일반 자바 객체 타입 
        		userid : $('#userid').val(),
        		userpw : $('#userpw').val(),
        		username : $('#username').val()
        	},*/
            /*data: JSON.stringify({ //json 타입
        		userid : $('#userid').val(),
        		userpw : $('#userpw').val(),
        		username : $('#username').val()
        	}),
            contentType: 'application/json; charset=utf-8;',
            dataType: 'json',*/
            success : function(data){
            	if(data>0) {
            		alert('환영쓰><');
            	} else {
            		alert('글렀어요.... 딴데 가여...');
            	}
           }
        });	      
        /* return false; */
    });
	
	
	
 	//회원정보수정 
	$('#editformProcess').submit(function(){
					
		//var idx = $('#idx').val();
		//var editedForm = $(this).serialize();
		
		//alert(idx);
		//alert(editedForm);
		
		$.ajax({
			url: 'http://localhost:8080/sa/rest/users/'+$('#idx01').val(),
			type: 'PUT',
			data: JSON.stringify({ 
				userid : $('#userid01').val(),
				userpw : $('#userpw01').val(),
				username : $('#username01').val()
			}),
				//$(this).serialize(),
				//editedForm,
			contentType: 'application/json; charset=utf-8;',
            //dataType: 'json',  //응답 데이터 방식 
			success : function(data) {
				alert(data);
			},
			error : function (e) {
				alert('error : '+e);
			}
		})
	});
});

//회원리스트
function selectMemberList() {
	$.ajax({
		//url: 'http://localhost:8080/sa/api/users',
		//url: 'http://localhost:8080/sa/rest/users', 
		url: 'http://localhost:8080/project/list',
		type: 'GET',
		success : function(data){ 		//data로 들어오는 모든 자료는 js 객체 형태이다 
			//alert(JSON.stringify(data));
            
            var html ='';
            
            for(var i=0; i<data.length; i++) {
                html += '<tr>';
                html += '<td>idx  '+data[i].idx+'</td>';
                html += '<td>userid  '+data[i].userid+'</td>';
                html += '<td>username  '+data[i].username+'</td>';
                html += '<td>userphoto  '+data[i].userphoto+'</td>';
                html += '<td><a onclick="deleteMember('+data[i].idx+')" id="delBtn">삭제하기</a></td>';
                html += '<td><a onclick="editGetMember('+data[i].idx+')" id="editBtn">수정하기</a></td>';
                html += '</tr>';
            }
            
            $('#memberlist').html(html);
		}
	});
}
 

//회원삭제
function deleteMember(idx) {
	if(confirm('회원삭제 후 복구가 불가합니다. 정말 삭제하시겠습니까?')) {
		$.ajax({
			url: 'http://localhost:8080/sa/rest/users/'+idx,
			type: 'DELETE',
			success: function(data) {
				if(data>0) {
					alert('삭제 성공해브러쓰~!');
					selectMemberList();
				} else {
					alert('삭제 안돼버렀는디 ㅠㅠㅠㅠ 우째쓰까잉');
				}
				
			}
		})
	}
}

//회원수정 - 정보 가져오기 
function editGetMember(idx) {
	
	$.ajax ({
		url: 'http://localhost:8080/sa/rest/users/'+idx,
		type: 'GET',
		success : function(data) {
			//alert(data.idx);
			
			var html ='';

			html += '<tr>';
			html += '<td>회원번호</td>';
			html += '<td>';
			html += '<input type="text" name="idx" id="idx01" value="'+data.idx+'">';
			html += '</td>';
			html += '</tr>';
			html += '<tr>';
			html += '<td>아이디</td>';
			html += '<td>';
			html += '<input type="text" name="userid" id="userid01" value="'+data.userid+'" readonly>';
			html += '</td>';
			html += '</tr>';
			html += '<tr>';
			html += '<td>비밀번호</td>';
			html += '<td><input type="password" name="userpw" id="userpw01" value="'+data.userpw+'"></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<td>이름</td>';
			html += '<td><input type="text" name="username" id="username01" value="'+data.username+'"></td>';
			html += '</tr>';
			html += '<tr><td><input type="submit" value="수정하기"></td></tr>';
			
			$('#editform').html(html);

		}
	})
}
