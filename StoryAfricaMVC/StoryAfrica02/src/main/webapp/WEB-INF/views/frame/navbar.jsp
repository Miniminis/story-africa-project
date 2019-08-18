<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" rel="stylesheet">

<div id="navbar" class="nav nav-masthead justify-content-center">
	<a class="nav-link active" href="<c:url value='/'/>">홈</a>
	<a class="nav-link" href="<c:url value='/'/>">여행</a>
	<a class="nav-link" href="<c:url value='/'/>">사업</a>
	<a class="nav-link" href="<c:url value='/'/>">봉사</a>
	<a class="nav-link" href="<c:url value='/member/memberlist'/>">회원리스트</a>
	<a class="nav-link" href="<c:url value='/member/regform'/>">회원가입</a>
	<a class="dropdown-toggle nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
		aria-haspopup="true" aria-expanded="false">
      	로그인
    </a>
	    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	      <a class="dropdown-item" href="<c:url value='/member/loginform'/>">로그인</a>
	      <a class="dropdown-item" href="<c:url value='/member/mypage'/>">내정보보기</a>      
	      <div class="dropdown-divider"></div>
	      <a class="dropdown-item" href="<c:url value='/member/logout'/>">로그아웃</a>
	    </div>		  
</div>


<!-- 네비게이션 바를 include 를 통해서 불러올때에는 
절대경로를 사용해야 각각의 페이지의 서로 다른 위치에서도 올바른 주소로 
접근할 수 있다.  -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

