<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--ver 1.0 ~ ver3.0 -->
<!-- 
0. 회원 정보를 저장하기위한 MemberInfo class 생성 
- 저장할 정보의 name값과 일치!!!!하는 private 변수 
- default 생성자 
- 매개변수 받는 생성자 
- 각 변수들을 호출할 수 있도록 해주는 getter와 setter 
- 확인용 toString 매서드 오버라이딩 
- 나중에 로그인 시 필요한 정보를 쉽게 확인할 수 있도록 해주는 toLogin 매서드 정의 -> 매개변수 id, name, photo 3가지만! 

1. 회원가입 폼 regForm.jsp 
- 사용자로부터 정보 입력받기 
2. regProcess.jsp 
- utf-8로 인코딩 해주기  
- 폼으로부터 전달받은 정보 name 값 통해서 받아오기 request.getParameter('name');
	혹은 jsp:bean 액션 토애해서 정보 한	번에 받아오기 
- 사진값을 못받았을 경우, noimg 표시 해주기 
- 받아온 정보를 application 객체에 저장 
application.setAttribute(userid, regData)
- 페이지: 회원가입이 완료되었습니다. 표시 
- 링크 버튼: 1. 로그인하기 2. 홈으로 

3-0. LoginInfo.java 
- 로그인 정보만을 비교하기 위해서 만든 클래스 
- setter는 사용불가 -> 사용자입력값과 비교만 할 목적이기 때문에 데이터를 바꿀 수 있는 setter는 사용하지 않는다. 
3. loginForm.jsp 
- 로그인 폼에서 사용자 입력값 받기 
- 각 input 속의 name 값은 멤버객체에 저장된 private 변수들과 같은 이름으로! 

4. loginProcess.jsp 
- 받기 전에 utf-8 인코딩! 
- 로그인 폼에서 전달받은 값을 request.getParameter('name') 통해서 받기 
- 입력받은 정보와 application 객체에 저장된 사용자 정보 대조하여 로그인 처리하기 위해서 
	getAttribute(name) 을 통해서 받아오기 (object 타입이므로 MemberInfo type으로 변형필요!) 

- 만약 아이디가 존재하고, 비밀번호가 일치하면 세션에 로그인 정보 저장하기
-  만약 아이디가 존재하지 않거나 비밀번호가 불일치한다면, 오류메시지 띄워주고 한단계 전 페이지로 이동! 

5. mypage.jsp 
- session에 저장된 로그인 정보(이미지, 아이디, 이름)를 보여주기 위해서 LoginInfo 타입의 변수에 
	session.getAttribute(LOGININFO); 를 담아줌 

- 로그인 정보가 있으면 -> 화면에 표시 
	- 이미지, 아이디, 이름 
- 로그인 정보가 없으면 -> 로그인이 필요합니다 오류메시지 팝업 && 로그인 페이지로 이동

6. 회원리스트 
- application에 저장된 모든 name 들 가져오기 == 회원 가입한 멤버들의 name 총 호출 
	Enumeration<String>e = request.getParameterNames(); 이용 

- body에서 테이블 형태로 출력시켜주기 
위해서 초기 테이블 생성 및 목록이름들 설정 
- 가져온 String 타입의 name 들을 반복문을 통해서 String 타입의 변수에 담음 
- 가져온 이름값을 통해서 object 타입의 변수에 application.getAttribute(name); object 가져오기 

- 만약 위의 object 를 MemberInfo 타입으로 변형할 수 있다면, 형변환 ㄱㄱ 
- 변환된 MemberInfo 타입의 객체의 get매서드들을 통해서 저장된 값들 가져오기 
- 해당 값들을 테이블 한 열에 저장시켜주기 
 
7. 로그아웃 
- request.getSession(false).invalidate() 으로 세션 종료 
- false 값을 가져와야 현재의 세션이 종료됨!!!!!!!!!
- 홈으로 페이지 이동 
 -->






<!-- ver 4.0 표현식에서 표현언어EL 로 코드 수정  -->
<!-- ver 4.1 자바코드를 -> JSTL+EL을 이용하여 바꾸기  --> 

<!-- EL 로 바꾸기 "출력"
- 데이터 출력할때 
- 내부 링크 경로 설정할때 
1. navbar 
- contextPath() 
2. mypage
- session 객체에 저장한 사용자 로그인 데이터 불러와 표시 
3. memberReg
- 회원가입 완료 후 입력값 확인용 페이지 표시 - 데이터 불러오기 필요 
- 객체.매서드() 방식으로 호출도 가능함 
-->




<!-- ver 5.0 JDBC를 통해 회원가입 폼 데이터 DB에 저장하기 -->
<!-- 1. 회원가입 폼을 통해 입력받은 값을 데이터 베이스에 저장
	 2. 회원가입 처리 - 확인페이지 출력 
	 3. 로그인 - 데이터베이스를 통해서 아이디와 비밀번호 체크  
		a. JDBC 드라이버 로드 -> JDBCDriverLoader 서블릿 클래스 통해서! (web.xml 맵핑)
		b. 데이터베이스 연결 -> DBCPInit 서블릿 클래스 (web.xml 맵핑)
			- 역할 1: JDBC 드라이버 로드 
			- 역할 2: pool driver 연결 
		c. 데이터 읽기 및 수정 
			- conn 객체 통해서 statement 객체 생성
		d. 커넥션 종료	
-->


<!-- ver 6.0 MVC 패턴으로 구조 변경
* 스프링 프레임 워크: login.do
	- get 방식이냐 post 방식이냐에 따라서 다른 처리 
- get >> form 
- post >> login 처리  
	- 서버로 보낼때: 외부 노출 방지위해서 POST 방식 사용!!! 
	- 파일 업로드 : 반드시 반드시 post 방식 

**********************************
* 게시판 4개 추가: 경험, 여행, 사업, 봉사
1. 데이터베이스 모델링 
2. 프로퍼티 파일 설정에 추가 
3. 모델 
4. 서비스 
5. DAO 

-->

   
<!--  스토리 아프리카 프로젝트 흐름도
1. 회원가입 
관리자 : admin					
일반회원
- 아이디 중복체크 - DB데이터 비교 
- 아이디 유효성체크 
- 비밀번호 유효성체크 
- 이름 유효성 체크 
- 등록시: 모든 항목 유효성 통과 여부  				

2. 로그인 + 권한설정 
관리자			
- 회원리스트 보기
- 회원 검색
- 회원 삭제 
일반회원 
- 내정보 보기
- 내정보 수정
- 회원탈퇴 

3. 게시판  
콘텐츠 리스트 : 모든사람
- 무한스크롤 ajax
콘텐츠 상세보기 : 모든사람
- 관련 api 적용 
콘텐츠 검색 : 모든사람
- ajax
콘텐츠 추가 : 회원만
- ajax
콘텐츠 수정 : 자신만
- ajax
콘텐츠 삭제 : 자신만 
- ajax
좋아요 : 회원만 
- ajax
댓글 : 회원만   
- ajax
-->

























