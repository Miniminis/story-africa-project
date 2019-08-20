<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${resultCnt>0}">
	<script>
		alert('회원정보가 정상적으로 삭제되었습니다.');
		location.href="<c:url value='/'/>";
		/* script 영역 안에서 core 태그 사용 가능!!!!!!!!!!!!!  */
	</script>
</c:if>

<c:if test="${resultCnt==0}">
	<script>
		alert('회원 삭제에 실패하셨습니다.');
		history.go(-1);
	</script>
</c:if>