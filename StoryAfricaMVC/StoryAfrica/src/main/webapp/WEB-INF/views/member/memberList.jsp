<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>회원 목록</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="<c:url value='/static/default.css'/>" rel="stylesheet" type="text/css">
<script src="<c:url value='/static/list.js' />" text="text/javascript"></script>
</head>
<body>	
	<!-- header start -->
	<%@ include file="/WEB-INF/views/frame/navbar.jsp"%>
	<!-- header end -->

	<!--list-->
    <div class="container marketing">
    <div class="row p-top">
	    <c:if test="${list.totalMemNum >0}">
		 	 <!-- 회원리스트 반복의 시작 -->	
		  	 <c:forEach var="member" items="${list.memberList}" varStatus="stat">
			  <div class="col-md-3">
			  	<img src='<c:url value="/uploadedfile/userphoto/${member.userphoto}"/>' id="listImg">
		        <!-- <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"></rect><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg> -->
		        <h5>${member.userid}</h5>
		        <table class="table">
		        	<tr><td>이름 : ${member.username}</td></tr>
		        	<%-- <tr><td>${member.userpw}</td></tr> --%>
		        	<tr><td>가입날짜 : ${member.regdate}</td></tr>
		        	<tr><td>
		        		<!-- 수정 modal  -->
		        		<%-- <button data-toggle="modal" 
		        				data-target="#editModal" 
		        				data-idx="${member.idx}"
		        				data-userphoto="${member.userphoto}"
		        				data-userid="${member.userid}" 
		        				data-username="${member.username}"
		        				data-keyboard="true" 
		        				class="btn btn-light">
		        				수정modal
		        		</button> --%>
		        		<a href="<c:url value='editForm?memberIdx=${member.idx}'/>" class="btn btn-secondary">수정</a>    
			      	  	<a href='#' onclick="deleteMember(${member.idx})" class="btn btn-secondary">삭제</a>
		        	</td></tr>
		        </table>
		      </div><!-- /.col-lg-4 -->  
			  </c:forEach>
			  <!-- 회원리스트 반복의 끝 -->
		</c:if>
    </div><!-- /.row -->
    
    <div class ="text-center">
    	<!-- 검색 결과와 일치하는 리스트가 없을떄  -->
		<c:if test="${list.totalMemNum ==0 || list.totalMemNum <0}">
		  <h4 class="noSearchResult"> 검색 결과가 없습니다! </h4>
		</c:if>
		 
		<!-- 페이지 넘버링  -->  
		<h6>현재 회원님은  ${list.curPageNum}번 페이지에 있습니다.</h6>
		<c:if test="${list.totalMemNum>0 }">
			<c:forEach begin="1" end="${list.totalPageNum}" step="1" var="i">
				<%-- <a href='<c:url value="/member/memberlist?page=${i}"/>'>[${i}]</a> --%>
				<a href='<c:url value="/member/memberlist?
					page=${i}
					&searchType=${param.searchType}
					&keyword=${param.keyword}
					&searchPeriod=${param.searchPeriod}"/>'>[${i}]</a>
			</c:forEach>
		</c:if>
	
		
		<!-- 회원검색기능  -->
		<form id="memberSearch" class="form-inline" method="get">
			<select class="browser-default custom-select" name="searchPeriod">
			  <option value="AllPeriod" selected>전체기간</option>
			  <option value="day">1일</option>
			  <option value="week">1주</option>
			  <option value="month">1개월</option>
			  <option value="year">1년</option>
			</select>	
			
			<select class="browser-default custom-select" name="searchType">
			  <option value="idPlusName" selected>아이디+이름</option>
			  <option value="id">아이디</option>
			  <option value="name">이름</option>
			</select>
			
	      <input class="form-control" type="search" name="keyword" placeholder="회원검색" aria-label="Search">
	      <button class="btn btn-outline-warning my-2 my-sm-0" type="submit">검색하기</button>
	    </form>	
    </div><!--text-center end -->
    </div><!-- container end  -->
    
    <!-- 수정 폼 Modal -->
	<!-- <div id="editModal" class="modal fade" tabindex='-1' role="dialog">
	  <div class="modal-dialog">
	  
	    Modal content
	    <div class="modal-content">
	      <div class="modal-header">
	      
	      	<h4 class="modal-title">회원정보 수정</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      
	      <div class="modal-body">
	        <form id="memEditForm" method="post" enctype="multipart/form-data">
	          <div class="form-group">
				<img src='' id="listImg"><br>
				
				회원 고유번호
				<input type="hidden" name="memidx" id="memidx" value=""> 
				
				<label for="inputEmail">아이디</label>
				<input type="text" name="userid" id="userid" class="form-control" 
					value="" readonly>
				
				<label for="inputPassword">비밀번호</label>
				<input type="password" name="userpw" id="userpw" 
					class="form-control" placeholder="비밀번호" required>
					
				<label for="inputPassword" class="sr-only">비밀번호확인</label>
				<input type="password" name="userpw" id="inputPassword" 
					class="form-control" placeholder="비밀번호확인" required>
				
				<label for="inputUsername">이름</label>
				<input type="text" name="username" id="username" 
					class="form-control" value="" required>
				
				새로운 사진
				<div class="form-group">
	              <label for="userphoto">프로필 사진</label>
	              <div class="custom-file">
	                <input type="file" class="custom-file-input form-control" name="userphoto" id="userphoto" aria-describedby="inputGroupFileAddon01">
	                <label class="custom-file-label" for="userphoto">탐색</label>
	                기존사진파일
	                <input type="hidden" id="oldPhoto" name="oldPhoto">
	              </div>
	            </div>
				
	          </div>
	        </form>
	      </div>modal-body end
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
	        <button type="button" onclick="submitEditMember()" class="btn btn-light">수정</button>
	      </div>modal-footer end
	      
	      </div>modal-content end
	    </div>modal-dialog	    
	 </div>modal END 
	 -->
	<!-- footer start  -->
	<%-- <%@ include file="/WEB-INF/views/frame/footer.jsp"%> --%>
	<!-- footer end -->	
</body>
</html>