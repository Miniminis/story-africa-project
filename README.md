# Story-africa-project
> 아프리카를 사랑하는 모든 사람들을 위한 콘텐츠 플랫폼  [Site Link](http://15.164.99.110:8080/storyafrica/)

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

## 버전
* 자세한 버전관리는 커밋 내역을 참고 
* v7 ~ : 
  * [소스코드+커밋내역](https://github.com/Miniminis/Story-africa-project)
* v6 : 
  * [소스코드](https://github.com/Miniminis/JSP-study-note/tree/master/MemberManagerVer6)
  * [커밋내역](https://github.com/Miniminis/JSP-study-note/commits/master)
* v1 ~ v5 : 
  * [소스코드](https://github.com/Miniminis/JSP-study-note/tree/master/MemberManager) 
  * [커밋내역](https://github.com/Miniminis/JSP-study-note/commits/master)

<hr>

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
  
  ## 테스트 안내 
  * 모든 서비스는 로그인 상태에서 이용 가능 : 회원가입(이메일 이용) - 인증매일 발송 - 계정인증 - 로그인 
  * 에디터 리스트는 수정, 삭제 기능이 있기 때문에 관리자만 접근 가능 
    * 관리자 계정 아이디 : admin@admin 
    * 관리자 계정 비밀번호 : admin