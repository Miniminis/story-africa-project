<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style></style>
<body class="text-center">
	<div class="container">
		<!-- content start -->
		<div id="content" class="inner">
			<img src="/image/zootopia_2.jpg"> 
			<h3>404 에러 발생</h3>
			<a href="<c:url value='/*.do'/>" class="btn btn-warning btn-lg">홈으로 가기</a>
		</div> 
		<!-- content end -->
	</div>
</body>
</html>