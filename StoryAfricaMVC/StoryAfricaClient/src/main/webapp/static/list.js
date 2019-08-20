/*멤버삭제*/
function deleteMember(idx) {
	
	if(confirm('삭제 된 정보는 복구가 불가능합니다. 정말 삭제하시겠습니까? ')) {
		location.href='http://localhost:8080/sa/member/deleteProcess/'+idx; 
							//href 경로 : 현재 위치에서 찾는다! - REST
	}
};


/*멤버수정*/
/*function editForm(idx) {
	.ajax({
		url : 'http://localhost:8080/sa/member/',
	})
}*/
