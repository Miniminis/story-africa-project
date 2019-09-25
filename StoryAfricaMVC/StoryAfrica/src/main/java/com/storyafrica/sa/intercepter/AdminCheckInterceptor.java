package com.storyafrica.sa.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.storyafrica.sa.member.domain.LoginInfo;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler)
							throws Exception {

		//세션에 로그인 정보가 있는지 없는지 확인하는 작업이 필요! 
		HttpSession session = request.getSession(false);
		/* 기존코드 */
		/*if(session != null ) {
			Object authinfo = session.getAttribute("LoginInfo");
			if(authinfo != null) {
				return true; //이후의 필터로 이어짐. 매서드의 나머지 부분은 실행 안함 
			}
		}*/
		
		/* 수정코드 */
		if(session != null && session.getAttribute("LoginInfo") != null) {
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("LoginInfo");
			
			if(loginInfo.getUserid().equals("admin@admin")) {
				return true; //다음 체이닝으로 이동. 이후의 매서드 내용 실행 안함. 
			}
		}
		
		System.out.println("request.getRequestURI()출력 :::  "+request.getRequestURI());
		
		//요청 페이지가 마이페이지일 경우 
		response.sendRedirect(request.getContextPath()+"/member/loginRequiredAdmin"); //로그인 필요함 팝업창 페이지 
		
		return false;
	}

}
