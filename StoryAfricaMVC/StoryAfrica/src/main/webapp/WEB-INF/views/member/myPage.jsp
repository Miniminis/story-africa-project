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
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="<c:url value='/static/default.css'/>" rel="stylesheet" type="text/css">

<style>
	.mb-auto {
		margin-bottom: 50px!important;
	}
	.table {
		width: 100%;
		max-width: 330px;
		margin: 0 auto;
		color: #fff;
	}
	.profile-img {
		width: 150px;
		height: 150px;
		margin-bottom: 50px;
		border-radius: 100px;
		border: 10px solid #FAD02C;
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
		<img src="<c:url value='/uploadedfile/userphoto/${sessionScope.LoginInfo.userphoto}'/>" class="profile-img"><br>
		<h3>내정보 보기</h3>
		<table class="table">
		    <tr>
		      <th scope="col">아이디</th>
		      <td>${sessionScope.LoginInfo.userid}</td>
		    </tr>
		    <tr>
		      <th scope="col">아이디</th>
		      <td>${sessionScope.LoginInfo.userid}</td>
		    </tr>
		    <tr>
		      <th scope="row">이름</th>
		      <td>${sessionScope.LoginInfo.username}</td>
		    </tr>
		    <tr>
		      <th scope="row">가입일</th>
		      <td>${sessionScope.LoginInfo.regdate}</td>
		    </tr>	 
		</table>		
		</div>
	</div>
</body>

