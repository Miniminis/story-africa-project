# [Story-africa-project](http://15.164.99.110:8080/storyafrica/)
> 아프리카를 사랑하는 모든 사람들을 위한 콘텐츠 플랫폼

## 흐름도
<img src="/main.png">

## 기술/구조 
* 웹표준
  * `HTML5`
  * `CSS3`
  * `JavaScript`
  * `jQuery`
  * `Bootstrap4`
* TOMCAT 컨테이너 사용
* DBMS
  * v7 ~ : `MySQL`
  * v1 ~ v6 : `Oracle`
* Spring Framework
* `MyBatis`
* RESTful Api 이용
  * 서버와 클라이언트 완전 분리 구조 
  * `Ajax` 이용 : 서버 <--> 클라이언트 비동기통신
  
## 버전
* v8
  * `mybatis` 이용하여 DAO 수정 및 검색기능 동적 쿼리문 재구성 
  * `RESTful Api` 구조로 변경 
    * 서버-클라이언트 분리구조
    * REST api 우회서버 구축 
    * 에디터 리스트부분 싱글페이지로 구성
  * `Bootstrap4`, `HTML5`, `CSS5` 이용해서 전체 스타일 변경 
* v7
  * Spring Project로 변경, MVC 패턴으로 구조 변경
  * 에디터 리스트 페이징 처리
  * 에디터 키워드 검색, 기간 검색 기능 추가 
  * JDBC template 이용해서 DB연결 및 DAO 간략히 수정
* v6
  * MVC Pattern 적용 
    * Model : 비즈니스 로직처리
    * View : JSP - 사용자 페이지 표현
    * Controller : Servlet - 사용자의 입력/흐름 제어 
  * 필터 적용 : Login, Character Encoding  
* v5 
  * `JDBC` Driver 이용하여 데이터 베이스 연결
    * 회원 정보 DB에 저장 
  * Connection Pool
  * 로그인 유효성 검사 추가
* v4 
  * `Bootstrap4`, `HTML5`, `CSS3` 이용해서 스타일 적용 
  * View Page : `표현식` --> 표현언어 `EL` + `JSTL` 로 변경
* v3
  * 쿠키 이용해서 사용자 데이터 저장
  * 세션 이용해서 사용자 데이터 저장 
* v2 
  * `usebean action` 이용해서 Error page 추가 
* v1
  * Basic Dynamic Web Project 
  * 기본기능 : 회원가입, 로그인, 회원수정, 회원탈퇴 구현 
  * 페이지 간 연결
  * View Page : `표현식` 사용
