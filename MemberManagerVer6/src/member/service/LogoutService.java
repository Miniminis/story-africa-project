package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutService implements MemberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession(false).invalidate();
		//현재 session 객체를 소멸시킨다. false를 써야 현재의 session 정보를 가져온다. (default=true)
		
		return "/WEB-INF/member/logout.jsp";
	}

}
