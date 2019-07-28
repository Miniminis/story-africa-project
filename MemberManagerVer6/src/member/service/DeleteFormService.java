package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.LoginInfo;

public class DeleteFormService implements MemberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewpage = "/WEB-INF/member/delForm.jsp";
		
		//삭제할 회원 번호 받기 : 어차피 DB처리는 delete process service단에서 처리할 것이기 때문에 굳이 int로 형변환 X
		String memberIdx = request.getParameter("memberIdx"); 
		
		request.setAttribute("memberIdx", memberIdx);
		return viewpage;
	}
}
