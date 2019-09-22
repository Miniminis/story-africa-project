<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--1순위 에러 페이지 지정  -->
<%@ page errorPage="errorPage/defaultErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>스토리 아프리카</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="static/default.css" rel="stylesheet" type="text/css">
<style>
</style>
</head>
<body>
	<!-- header start -->
	<%@ include file="/WEB-INF/views/frame/navbar.jsp"%>
	<!-- header end -->

	<!--index01 : jumbotron -->
    <section class="jumbotron text-center index_section overflow-hidden">
    <div class="container">
      <h1 class="jumbotron-heading">당신의 아프리카를 들려주세요</h1>
      <p class="lead text-muted">
      	전쟁, 가난, 기아 등 부정적인 이미지로만 아프리카가 기억되지 않도록, 
      	당신이 보고, 느끼고, 겪은 아프리카의 이야기를 들려주세요. 
      	에디터 한 명 한 명이 만들어 나가는 아프리카 이야기, 스토리 아프리카 입니다!
      </p>
      <p>
        <a href="#" class="btn btn-secondary my-2">지금 새로운 글 확인하기</a>
      </p>
    </div>
  </section>

    <!--index02 : card list -->
    <!-- <div class="container">
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
    </div> -->
    
    
    <!--index03 : slide-->
     <!-- <div class="bd-example">
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
    </div> -->
    	
	<!-- footer start  -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	<!-- footer end -->
	</div>
</body>
</html>