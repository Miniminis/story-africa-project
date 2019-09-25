<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="<c:url value='/static/default.css'/>" rel="stylesheet" type="text/css">
<style></style>
</head>
<body>
	<!-- header start -->
	<%@ include file="/WEB-INF/views/frame/navbar.jsp"%>
	<!-- header end -->

	<!--mypage-->
    <div class="container marketing h-myInfo p-top-my02">

    <!-- Three columns of text below the carousel -->
      <div class="col-md-6 my-center text-center">
		<img src="<c:url value='/uploadedfile/userphoto/${sessionScope.LoginInfo.userphoto}'/>" class="listImg"><br>
        <!-- <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" 
        	preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
        	<title>Placeholder</title>
        	<rect width="100%" height="100%" fill="#777"></rect>
        	<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text>
        </svg> -->
        <h3 class="p-top-my">내 정보</h3>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">아이디</th>
              <th>${sessionScope.LoginInfo.userid}</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">이름</th>
              <td>${sessionScope.LoginInfo.username}</td>
            </tr>
            <tr>
              <th scope="row">가입일</th>
              <td>${sessionScope.LoginInfo.regdate}</td>
            </tr>
            <tr>
              <th scope="row">소개</th>
              <td>안녕하세요! 반가반가워요~!~!~!!!!</td>
            </tr>
          </tbody>
        </table>
      </div><!-- /.col-lg-4 -->
    </div>
    </div>
    
    <!--my writing list-->
    <!-- <div class="album py-5 bg-light">
        <div class="container">
          <div class="row">
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                <div class="card-body">
                  <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                    </div>
                    <small class="text-muted">9 mins</small>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                <div class="card-body">
                  <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                    </div>
                    <small class="text-muted">9 mins</small>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                <div class="card-body">
                  <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                    </div>
                    <small class="text-muted">9 mins</small>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div> -->
     <!-- footer start  -->
	<%-- <%@ include file="/WEB-INF/views/frame/footer.jsp"%> --%>
	<!-- footer end -->
	</div>
</body>
</html>