package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMyPage implements MemberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		String viewpage="/WEB-INF/member/myPage.jsp";

		return viewpage;
	}

}
