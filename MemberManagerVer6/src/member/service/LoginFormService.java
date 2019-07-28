package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.LoginInfo;

public class LoginFormService implements MemberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewpage="/WEB-INF/member/login.jsp";
		
		LoginInfo loginInfo = (LoginInfo) request.getSession(false).getAttribute("LoginInfo");
		
		if(loginInfo != null) {
			viewpage = "/WEB-INF/member/alreadyLogin.jsp";
		}
		
		return viewpage; 
	}
}
