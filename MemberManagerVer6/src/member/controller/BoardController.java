package member.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import experience.service.ExperienceService;
import member.service.MemberService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(
		urlPatterns = { "*.bo" }, /*  *.do 확장자를 가진 파일만 서블릿에서 실행하도록 처리함.  */
		initParams = { 
				@WebInitParam(name = "config", value = "/WEB-INF/cmdBoardService.properties")
		})
public class BoardController extends HttpServlet {
	
	private Map<String, ExperienceService> commands = new HashMap<String, ExperienceService>();
	
	//1. commandsService.properties 외부파일에서 서비스 경로 설정 
	//및 그에 따른 service 클래스 연결을 위한 init(config) 매서드 정의 작업  
	public void init(ServletConfig config) throws ServletException {
		
		String configfile = config.getInitParameter("config");  
		//서블릿 생성당시 지정한 초기 파라미터를 받아 value 값에 접근할 수 있도록 함
		
		
		Properties prop = new Properties(); //1. 프로퍼티 인스턴스 생성
		FileInputStream fis = null; //FileNotFoundException 미리 예방 - 예외처리시 변수 사용하기 위해서 미리 초기화
		String configFilePath = config.getServletContext().getRealPath(configfile);
		
		try {
			fis = new FileInputStream(configFilePath); //프로퍼티 파일이 존재하는 진짜 경로를 FileInputStream 의 초기화 매서드에 매개변수로 넣어준다. 
			prop.load(fis);	// Reads a property list (key and element pairs) from the inputbyte stream		
							//load()매서드를 통해 파일을 읽는다. 
		} catch (FileNotFoundException e) { //매개변수로 전달한 경로에 파일이 존재하지 않을수 있음 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator itr = prop.keySet().iterator(); 
		//읽어들인 프로퍼티 파일들을 set 타입으로 읽되 
		//iterator() 통해서 반복작업하며 남아있는 모든 프로퍼티들을 읽어들인다. 
		
		while(itr.hasNext()) {			
			
			String command = (String)itr.next();  //사용자 요청 uri --> key 값 
			String serviceClassName = prop.getProperty(command); 
			//그에 대응되는 서비스 클래스의 이름 --> key 값을 통해 value 값을 찾음  
			//예상결과값: command = /guestWriteForm,  
			//          serviceClassName = guestBook.service.WriteFormService 
			
			//System.out.println(command+" 커맨드와 서비스1 "+serviceClassName);
			//*** println(itr.next())  --> next() 매서드가 실행되기 때문에 쓰면 안됨. 대신 변수에 담아서 출력하는건 괜찮.
			//		--> 이 경우에는 command 를 출력해보는게 좋음 
			//확인
			System.out.println("Iterator 시작 - 현재 command는? "+command);
			
			try {
				//prop에 있는 클래스 이름으로 인스턴스 생성
				
				//System.out.println(command+" 커맨드와 서비스2 "+serviceClassName);
				Class serviceClass = Class.forName(serviceClassName);
				ExperienceService service = (ExperienceService) serviceClass.newInstance(); 
											//object 타입 GuestBookService타입으로 형변환
				
				//commands Map 에 저장 <String, GuestBookService>
				commands.put(command, service);
				
				//System.out.println(command+" 커맨드와 서비스3 "+ service);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	} //2. init(config) 매서드의 정의가 완료되었다면 
	//이제 사용자 요청 uri에 따라 서비스 분기처리 하기 위해 아래의 process(request, response) 매서드 정의 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	//do or post 두 방식 모두 process 매서드로 처리
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/*
		 * //1. 사용자 요청 분석 
		 * 		- 각 서비스의 실행 결과는 return viewpage 
		 * //2. 사용자 요청에 맞는 모델 실행 (서비스, DAO, 모델 실행 ) --> view 페이지 반환 
		 * //3. view 페이지로 포워딩
		 */	
		
		
		//1. 사용자 요청 분석 
		String commanduri = request.getRequestURI(); //결과: /guest/guestWriteForm/ --> contextpath/페이지
		

		if(commanduri.indexOf(request.getContextPath()) == 0) {
			commanduri = commanduri.substring(request.getContextPath().length()); // /guestWriteForm
		}
		//사용자 요청 uri에서 contextpath가 나타나는 지점이 0이라면
		//즉, /guest/guestWriteForm/ 에서 /guest 가 처음부터 나타난다면, 
		//처리 : /guest의 길이인 0-5까지 잘라낸 다음 index 인 6부터를 사용자 요청 uri 라고 하자. 
		
		//System.out.println("commanduri는 "+commanduri); //출력결과: /guest/guestWriteForm
		
		//2. 사용자 요청에 맞는 모델 실행 (서비스, DAO, 모델 실행 ) --> view 페이지 반환 
		String viewpage = "/WEB-INF/experience/null.jsp"; //아무 요청이 없을때 반환할 페이지 설정 
		
		ExperienceService service = commands.get(commanduri); //반환할 것이 없다면 null 값을 반환하기도 한다.
		//commanduri 는 key 값으로 사용되어 get() 매서드를 통해 최종적으로 해당 key 값에 맞는 서비스 클래스를 반환한다. 
		
		if(service != null) { //만약에 해당 서비스가 있다면 --> 서비스 인터페이스의 getViewName() 결과값을 viewpage로 설정
			viewpage = service.getViewName(request, response);  			
		}
		
		
		//3. view 페이지로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
	}


}
