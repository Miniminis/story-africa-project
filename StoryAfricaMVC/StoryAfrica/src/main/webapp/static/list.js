
$(document).ready(function(){
	
	/*멤버수정 modal + 기존정보 띄우기*/
	$('#editModal').on('show.bs.modal', function(e){
		var button = $(e.relatedTarget) // model 이벤트를 만드는 요소 
		
		var midx = button.data('idx');   
		var oldPhoto = button.data('userphoto');
		var userid = button.data('userid');
		var username = button.data('username');
			
		var modal = $(this); 

		modal.find('.modal-title').text(midx+'번 회원 수정');
		modal.find('#memidx').val(midx);
		modal.find('#oldPhoto').val(oldPhoto);
		modal.find('#userid').val(userid);
		modal.find('#username').val(username);

	});
});


/*멤버삭제*/
function deleteMember(idx) {
	
	if(confirm('삭제 된 정보는 복구가 불가능합니다. 정말 삭제하시겠습니까? ')) {
		location.href='http://15.164.99.110:8080/storyafrica/member/deleteProcess/'+idx; 
							//href 경로 : 현재 위치에서 찾는다! - REST
	}
};

function submitEditMember() {
	alert('뿅');
	
	var idx = $('#memidx').val();
	//폼 데이타 얻어오기
	var editFormData = $('#memEditForm')[0];
	alert(editFormData);
	//form data object 생성 
	var data = new FormData(editFormData);
	alert(data);
	
	$.ajax({
		//url: 'http://localhost:8080/sa/api/members/'+idx, 
		url: 'member/editMember', 
		type: 'put',
		enctype: 'multipart/form-data',
		data: data,
		processData: false,
		//dataType: 'json',
		contentType:'application/json;charset=UTF-8',
		/*contentType: false,*/
        cache: false,
        success : function(data) {
        	alert(data);
        },
        error: function (e) {
        	alert(e);
        }
	})
};