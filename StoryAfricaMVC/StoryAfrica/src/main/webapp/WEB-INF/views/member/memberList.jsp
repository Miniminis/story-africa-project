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
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="<c:url value='/static/default.css'/>" rel="stylesheet" type="text/css">
<style>
	.mb-auto {
		margin-bottom: 50px!important;
	}
	.table {
		margin-top: 50px;
		color: #fff;
	}
	#listImg {
		width: 50px; 
		height: 50px;
		border-radius: 20px;
	}
	.form-inline {
		display: block;
		margin: 10px;
	}
</style>
</head>
<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<!-- header start -->
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		<!-- header end -->

		<!-- content start -->
		<div id="content" role="main" class="inner cover">
			<h3>회원 목록</h3>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">아이디(이메일)</th>
			      <th scope="col">이름</th>
			      <th scope="col">비밀번호</th>
			      <th scope="col">이미지</th>
			      <th scope="col">가입일</th> 
			      <th scope="col">관리</th>
			    </tr>
			  </thead>
			  <tbody>
			  <!-- 회원리스트 반복의 시작 -->
			  <c:forEach var="member" items="${list.memberList}" varStatus="stat">
			    <tr>
			      <th scope="row">${list.startRow - stat.index}</th>
			      <td>${member.userid}</td>
			      <td>${member.username}</td>
			      <td>${member.userpw}</td>
			      <td><img src='<c:url value="/uploadedfile/userphoto/${member.userphoto}"/>' id="listImg"></td>
			      <td>${member.regdate}</td>
			      <td><a href="#">수정</a>    <a href="<c:url value="deleteForm?memberIdx=${member.idx}"/>">삭제</a></td> 
			    </tr>
			   </c:forEach>
			   <!-- 회원리스트 반복의 끝 -->
			  </tbody>
			  
			</table>
			
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
			<form class="form-inline my-2 my-lg-0" method="get">
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
			
		</div>
		<!-- content end -->
		
		<!-- footer start  -->
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<!-- footer end -->
	</div>	
</body>
</html>