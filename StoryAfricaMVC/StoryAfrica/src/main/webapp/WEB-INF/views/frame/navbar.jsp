<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" rel="stylesheet">
<script src="<c:url value="/static/default.js" />" text="text/javascript"></script>

<!--navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <a class="navbar-brand" href="<c:url value='/'/>">
<!--     <img src="/docs/4.3/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
 -->    Story Africa
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value='/'/>">여행<span class="sr-only">(current)</span></a>
      </li>
      <%-- <li class="nav-item">
        <a class="nav-link" href="<c:url value='/'/>">이벤트/축제</a>
      </li> --%>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/member/memberlist'/>">에디터 탐색</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/guestbook'/>">지금, 여기!</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">커밍순</a>
      </li>
    </ul>
    <ul class="navbar-nav">
    
    <!-- 회원가입 DROP DOWN-->
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          회원가입
        </a>
        <div class="dropdown-menu dropdown-menu-lg-right" aria-labelledby="navbarDropdown">
          <form action="member/regMember" method="post" enctype="multipart/form-data" class="px-4 py-3">
            <div class="form-group">
              <label for="inputEmail">아이디</label>
              <input type="checkbox" id="idchk">
              <input type="email" class="form-control" name="userid" id="inputEmail" placeholder="아이디" required autofocus>
            </div>
            <div class="form-group">
              <label for="inputPassword">비밀번호</label>
              <input type="password" class="form-control" name="userpw" id="inputPassword" placeholder="비밀번호" required>
            </div>
            <div class="form-group">
              <label for="inputUsername">이름</label>
              <input type="text" class="form-control" name="username" id="inputUsername" placeholder="이름" required>
            </div>
            <div class="form-group">
              <label for="inputProfile">프로필 사진</label>
              <div class="custom-file">
                <input type="file" class="custom-file-input form-control" name="userphoto" id="inputProfile" aria-describedby="inputGroupFileAddon01">
                <label class="custom-file-label" for="inputGroupFile01">탐색</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-check">
                <input type="checkbox" class="form-check-input" id="dropdownCheck">
                <label class="form-check-label" for="dropdownCheck">
                  개인정보수집동의
                </label>
              </div>
            </div>
            <button type="submit" class="btn btn-primary">회원가입</button>
          </form>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">이미 우리 식구여? 어서 로그인 ㄲ</a>
        </div>
    </li>
    
    <c:if test="${sessionScope.LoginInfo == null}">
    	<!-- 로그인 DROP DOWN-->
	    <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          로그인
	        </a>
	        <div class="dropdown-menu dropdown-menu-lg-right" aria-labelledby="navbarDropdown">
	          <form action="member/loginProcess" method="post" class="px-4 py-3">
	            <div class="form-group">
	              <label for="inputEmail">아이디</label>
	              <input type="email" class="form-control" id="inputEmail" name="userid"  placeholder="아이디" required autofocus>
	            </div>
	            <div class="form-group">
	              <label for="inputPassword">비밀번호</label>
	              <input type="password" class="form-control" id="inputPassword" name="userpw" placeholder="비밀번호" required>
	            </div>
	            <div class="form-group">
	              <div class="form-check">
	                <input type="checkbox" class="form-check-input" id="rememberMe" name="autologin" value="saveID">
	                <label class="form-check-label" for="rememberMe">
	                  자동로그인
	                </label>
	              </div>
	            </div>
	            <button type="submit" class="btn btn-primary">로그인</button>
	          </form>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#">너, 나의 동료가 되어라!</a>
	          <a class="dropdown-item" href="member/forgotPw">비밀번호를 잊어버리셨어요?</a>
	        </div>
	    </li>
    </c:if> 
    
   <c:if test="${sessionScope.LoginInfo != null }">
    	<!-- 마이페이지 DROP DOWN-->
	    <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          마이페이지
	        </a>
	        <div class="dropdown-menu dropdown-menu-lg-right" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="<c:url value='/member/mypage/filteredMypage'/>">내정보보기</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="<c:url value='/member/logout'/>">로그아웃</a>
	        </div>
	      </li>
    </c:if>
    
    </ul>
  </div>
</nav>

<!-- 네비게이션 바를 include 를 통해서 불러올때에는 
절대경로를 사용해야 각각의 페이지의 서로 다른 위치에서도 올바른 주소로 
접근할 수 있다.  -->
<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

