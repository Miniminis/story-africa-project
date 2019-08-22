<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>스토리 아프리카</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="<c:url value="/static/default.js" />" text="text/javascript"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="static/default.css" rel="stylesheet" type="text/css">
<style>
</style>
</head>
<body>
	<!-- NAVBAR start -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
	  <a class="navbar-brand" href="<c:url value='/'/>">
	    <img src="/docs/4.3/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
	    Story Africa
	  </a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="<c:url value='/'/>">여행<span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/'/>">이벤트/축제</a>
	      </li>
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
	              <input type="text" class="form-control" name="userid" id="inputEmail" placeholder="아이디" required autofocus>
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
		              <input type="text" class="form-control" id="inputEmail" name="userid"  placeholder="아이디" required autofocus>
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
		
	<!-- NAVBAR  end -->

	<!--index01-->
    <section class="jumbotron text-center index_section overflow-hidden">
    <div class="container">
      <h1 class="jumbotron-heading">당신의 아프리카를 들려주세요</h1>
      <p class="lead text-muted">여행가고싶다 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ 아프리카 배낭여행ㅠㅠㅠㅠㅠㅠ</p>
      <p>
        <a href="#" class="btn btn-secondary my-2">더 알아보기</a>
      </p>
    </div>
  </section>

    <!--index02-->
    <div class="container">
        <div class="card-deck mr_tobo">
          <div class="card">
            <div class="card_img_h">
               <img src="https://images.unsplash.com/photo-1522441815192-d9f04eb0615c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=282&q=80" class="card-img-top w-100 h-100 d-inline-block" alt="...">
            </div>
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
            <div class="card-footer">
              <small class="text-muted">Last updated 3 mins ago</small>
            </div> 
          </div>
          <div class="card">
            <div class="card_img_h">
                <img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUPDxAVFRUVFRUVFRUVFRUVFRUVFRUXFxUVFRUYHSggGBolHRUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDQ0NFQ8PFSsZFR0rLSsrLSstKy03LSsrLSstLS0tLS0tLS0rLSstLSstLS0tKystNy0rLS0tLSs3NystLf/AABEIAKIBNwMBIgACEQEDEQH/xAAYAAEBAQEBAAAAAAAAAAAAAAAAAQIDBv/EACMQAQEBAAAEBwEBAAAAAAAAAAABEQJBgcEhMVFxsdHwEgP/xAAYAQEBAQEBAAAAAAAAAAAAAAAAAQIHBf/EABgRAQEBAQEAAAAAAAAAAAAAAAABQREx/9oADAMBAAIRAxEAPwDwAg8Z0NV1lYKJVqCEXEiaKuiLBCKlA9U1AVZU0BV0QBdNQBTRAUQBZVtZKKurKyoiiALqagDWlQAQAUEBRABAEUIAtSiCAAAAAAoqKAAKAAAAKgC6IoIoQCAgqmoCKgAuoAAQBUAAUBmEFGSCAoAAqAgqAKAKBAAFFQAAAAFBAAUQAWJAAFAEUVBQRFEFUICAoHWIqAkBQEBREAFBQRFoCgAAAoKgAACoAAAAAuAgqgABQAAAIALEtBAKAyqLREAAAggAKsRUAABQAABQgAAAAABAAABaiihDAFSqIIRQEBcVEFiUChgCACAAIKgCkAAAQUBFACACgQAIAAAAAAoAAKsMCIFKAAaAmqi0QSqii6JRBAFQAARUBSQIAigAAAAAABAFFRQQFARaAAooBUCkKgLAQFEAUQoLiAoaAIgAgigAAgQIKAUUAggBAABVTFNBBagKBAKCwACooCAtgAAaUAQ0ANFAAAAEBRlABAAVdQWAgqACgomN8PDpxCM4VbTQRFQAFFAMAARVRUUVAwAAAoAAAAAQVABZARBcMEQWQoIi4YCKYCgYAC4YBFnokazw/c0RmljWknqDOJY3/KU6sZFwiiYtCoECrRURcARcXCglDAAVMBFAAooMjUhYCC4CLw8/buyoJo1YAM0gCr6/ubIBFWfYCl8lz4oIjK+vtOwKNcE8L7d0/wBPr4BNReLn0SoCwn18Ioqutng5XzBmEWreXsgorIChyARq+U6/KXsAJFnn1AVFiAjVn7ozy6gA3xdkBD0QEpX/2Q==" class="card-img-top w-100 h-100 d-inline-block" alt="...">
            </div>
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            </div>
            <div class="card-footer">
              <small class="text-muted">Last updated 3 mins ago</small>
            </div>
          </div>
          <div class="card">
            <div class="card_img_h">
                <img src="https://media.istockphoto.com/vectors/yellow-halftone-spotted-background-vector-id945172204?k=6&m=945172204&s=612x612&w=0&h=bP4XReoPy2UHtFXhwslYALrY4P0wNpWUas4tc_3zhaU=" class="card-img-top w-100 h-100 d-inline-block" alt="...">
            </div>
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
            </div>
            <div class="card-footer">
              <small class="text-muted">Last updated 3 mins ago</small>
            </div>
          </div>
        </div>
    </div>
    
    
    <!--index03-->
     <div class="bd-example">
      <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active index_carousel_h">
            <img src="https://images.unsplash.com/photo-1522441815192-d9f04eb0615c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=282&q=80" class="w-100 h-100 d-inline-block" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>First slide label</h5>
              <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
            </div>
          </div>
          <div class="carousel-item index_carousel_h">
            <img src="https://media.istockphoto.com/vectors/yellow-halftone-spotted-background-vector-id945172204?k=6&m=945172204&s=612x612&w=0&h=bP4XReoPy2UHtFXhwslYALrY4P0wNpWUas4tc_3zhaU=" class="w-100 h-100 d-inline-block" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Second slide label</h5>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </div>
          </div>
          <div class="carousel-item index_carousel_h">
            <img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUPDxAVFRUVFRUVFRUVFRUVFRUVFRUXFxUVFRUYHSggGBolHRUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDQ0NFQ8PFSsZFR0rLSsrLSstKy03LSsrLSstLS0tLS0tLS0rLSstLSstLS0tKystNy0rLS0tLSs3NystLf/AABEIAKIBNwMBIgACEQEDEQH/xAAYAAEBAQEBAAAAAAAAAAAAAAAAAQIDBv/EACMQAQEBAAAEBwEBAAAAAAAAAAABEQJBgcEhMVFxsdHwEgP/xAAYAQEBAQEBAAAAAAAAAAAAAAAAAQIHBf/EABgRAQEBAQEAAAAAAAAAAAAAAAABQREx/9oADAMBAAIRAxEAPwDwAg8Z0NV1lYKJVqCEXEiaKuiLBCKlA9U1AVZU0BV0QBdNQBTRAUQBZVtZKKurKyoiiALqagDWlQAQAUEBRABAEUIAtSiCAAAAAAoqKAAKAAAAKgC6IoIoQCAgqmoCKgAuoAAQBUAAUBmEFGSCAoAAqAgqAKAKBAAFFQAAAAFBAAUQAWJAAFAEUVBQRFEFUICAoHWIqAkBQEBREAFBQRFoCgAAAoKgAACoAAAAAuAgqgABQAAAIALEtBAKAyqLREAAAggAKsRUAABQAABQgAAAAABAAABaiihDAFSqIIRQEBcVEFiUChgCACAAIKgCkAAAQUBFACACgQAIAAAAAAoAAKsMCIFKAAaAmqi0QSqii6JRBAFQAARUBSQIAigAAAAAABAFFRQQFARaAAooBUCkKgLAQFEAUQoLiAoaAIgAgigAAgQIKAUUAggBAABVTFNBBagKBAKCwACooCAtgAAaUAQ0ANFAAAAEBRlABAAVdQWAgqACgomN8PDpxCM4VbTQRFQAFFAMAARVRUUVAwAAAoAAAAAQVABZARBcMEQWQoIi4YCKYCgYAC4YBFnokazw/c0RmljWknqDOJY3/KU6sZFwiiYtCoECrRURcARcXCglDAAVMBFAAooMjUhYCC4CLw8/buyoJo1YAM0gCr6/ubIBFWfYCl8lz4oIjK+vtOwKNcE8L7d0/wBPr4BNReLn0SoCwn18Ioqutng5XzBmEWreXsgorIChyARq+U6/KXsAJFnn1AVFiAjVn7ozy6gA3xdkBD0QEpX/2Q==" class="w-100 h-100 d-inline-block" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Third slide label</h5>
              <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
    
    <!--카드형 리스트 케러셀 실험 ING....-->
     <div class="bd-example">
      <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active index_carousel_h">
            <div class="card">
            <div class="card_img_h">
               <img src="https://images.unsplash.com/photo-1522441815192-d9f04eb0615c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=282&q=80" class="card-img-top w-100 h-100 d-inline-block" alt="...">
            </div>
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
            <div class="card-footer">
              <small class="text-muted">Last updated 3 mins ago</small>
            </div> 
          </div>
          </div>
          <div class="carousel-item index_carousel_h">
            <img src="https://media.istockphoto.com/vectors/yellow-halftone-spotted-background-vector-id945172204?k=6&m=945172204&s=612x612&w=0&h=bP4XReoPy2UHtFXhwslYALrY4P0wNpWUas4tc_3zhaU=" class="w-100 h-100 d-inline-block" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Second slide label</h5>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </div>
          </div>
          <div class="carousel-item index_carousel_h">
            <img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUPDxAVFRUVFRUVFRUVFRUVFRUVFRUXFxUVFRUYHSggGBolHRUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDQ0NFQ8PFSsZFR0rLSsrLSstKy03LSsrLSstLS0tLS0tLS0rLSstLSstLS0tKystNy0rLS0tLSs3NystLf/AABEIAKIBNwMBIgACEQEDEQH/xAAYAAEBAQEBAAAAAAAAAAAAAAAAAQIDBv/EACMQAQEBAAAEBwEBAAAAAAAAAAABEQJBgcEhMVFxsdHwEgP/xAAYAQEBAQEBAAAAAAAAAAAAAAAAAQIHBf/EABgRAQEBAQEAAAAAAAAAAAAAAAABQREx/9oADAMBAAIRAxEAPwDwAg8Z0NV1lYKJVqCEXEiaKuiLBCKlA9U1AVZU0BV0QBdNQBTRAUQBZVtZKKurKyoiiALqagDWlQAQAUEBRABAEUIAtSiCAAAAAAoqKAAKAAAAKgC6IoIoQCAgqmoCKgAuoAAQBUAAUBmEFGSCAoAAqAgqAKAKBAAFFQAAAAFBAAUQAWJAAFAEUVBQRFEFUICAoHWIqAkBQEBREAFBQRFoCgAAAoKgAACoAAAAAuAgqgABQAAAIALEtBAKAyqLREAAAggAKsRUAABQAABQgAAAAABAAABaiihDAFSqIIRQEBcVEFiUChgCACAAIKgCkAAAQUBFACACgQAIAAAAAAoAAKsMCIFKAAaAmqi0QSqii6JRBAFQAARUBSQIAigAAAAAABAFFRQQFARaAAooBUCkKgLAQFEAUQoLiAoaAIgAgigAAgQIKAUUAggBAABVTFNBBagKBAKCwACooCAtgAAaUAQ0ANFAAAAEBRlABAAVdQWAgqACgomN8PDpxCM4VbTQRFQAFFAMAARVRUUVAwAAAoAAAAAQVABZARBcMEQWQoIi4YCKYCgYAC4YBFnokazw/c0RmljWknqDOJY3/KU6sZFwiiYtCoECrRURcARcXCglDAAVMBFAAooMjUhYCC4CLw8/buyoJo1YAM0gCr6/ubIBFWfYCl8lz4oIjK+vtOwKNcE8L7d0/wBPr4BNReLn0SoCwn18Ioqutng5XzBmEWreXsgorIChyARq+U6/KXsAJFnn1AVFiAjVn7ozy6gA3xdkBD0QEpX/2Q==" class="w-100 h-100 d-inline-block" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Third slide label</h5>
              <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
		
	<!-- footer start  -->
	<footer class="container py-5">
	  <div class="row">
	    <div class="col-12 col-md">
	      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24" focusable="false"><title>Product</title><circle cx="12" cy="12" r="10"></circle><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"></path></svg>
	      <small class="d-block mb-3 text-muted">minhee.son</small>
	    </div>
	    <div class="col-6 col-md">
	      <h5>Story Africa</h5>
	      <ul class="list-unstyled text-small">
	        <li><a class="text-muted" href="#">여행</a></li>
	        <li><a class="text-muted" href="#">에디터 탐색</a></li>
	        <li><a class="text-muted" href="#">지금, 여기</a></li>
	      </ul>
	    </div>
	    
	    <div class="col-6 col-md">
	      <h5>About</h5>
	      <ul class="list-unstyled text-small">
	        <li><a class="text-muted" href="#">소개</a></li>
	        <li><a class="text-muted" href="#">위치</a></li>
	        <li><a class="text-muted" href="#">저작권</a></li>
	      </ul>
	    </div>
	  </div>
	</footer>
	<!-- footer end -->
	</div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</html>