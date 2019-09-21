# [Story-africa-project](http://15.164.99.110:8080/storyafrica/)
> 아프리카를 사랑하는 모든 사람들을 위한 콘텐츠 플랫폼

## 흐름도
<img src="/main.png">

## 기술 

## 버전
* v1
  * Basic Dynamic Web Project 
  * 기본기능 : 회원가입, 로그인, 회원수정, 회원탈퇴 구현 
  * 페이지 간 연결
  * View Page : `표현식` 사용
* v2 
  * `usebean action` 이용해서 Error page 추가 
* v3
  * 쿠키 이용해서 사용자 데이터 저장
  * 세션 이용해서 사용자 데이터 저장 
* v4 
  * `Bootstrap4`, `HTML5`, `CSS3` 이용해서 스타일 적용 
  * View Page : `표현식` --> 표현언어 `EL` + `JSTL` 로 변경
* v5 
  * `JDBC` Driver 이용하여 데이터 베이스 연결
    * 회원 정보 DB에 저장 
  * Connection Pool
  * 로그인 유효성 검사 추가
* v6
  * MVC Pattern 적용 
    * Model : 비즈니스 로직처리
    * View : JSP - 사용자 페이지 표현
    * Controller : Servlet - 사용자의 입력/흐름 제어 
  * 필터 적용 : Login, Character Encoding
* v7
  * Spring Legacy Project
* v8
