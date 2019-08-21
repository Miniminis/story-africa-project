<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${resultCnt == 1}">
	<script>
		alert('이메일 확인 후, 회원가입을 완료하여주세요!');
		location.href="<c:url value='/'/>";
	</script>
</c:if>

<c:if test="${resultCnt == 0}">
	<script>
		alert('회원가입에 실패하였습니다. 다시 시도해주세요!');
		location.href="<c:url value='/'/>";
	</script>
</c:if>

<c:if test="${rscnt == 1}">
	<script>
		alert('인증번호 확인을 통한 회원가입이 확인되었습니다! ');
		location.href="<c:url value='/'/>";
	</script>
</c:if>

<c:if test="${rscnt == 0}">
	<script>
		alert('인증번호 확인에 실패하였습니다 ㅠㅠㅠ  다시 시도해주세요! ');
		location.href="<c:url value='/'/>";
	</script>
</c:if>
