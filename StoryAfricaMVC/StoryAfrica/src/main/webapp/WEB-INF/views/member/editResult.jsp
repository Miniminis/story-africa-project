<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	var msg;
	
	<c:if test="${rscnt>0}">
		msg = '회원정보가 성공적으로 수정되었습니다.';
	</c:if>
	
	<c:if test="${rscnt==0}">
		msg='회원 수정에 실패하였습니다! ';
	</c:if>
	
	alert(msg);
	location.href="<c:url value='/'/>";
</script>