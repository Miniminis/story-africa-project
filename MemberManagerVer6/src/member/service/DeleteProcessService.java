package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;

public class DeleteProcessService implements MemberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewpage="/WEB-INF/member/delProcess.jsp";
		
		int memberIdx = 0;
		
		String memberIdxStr = request.getParameter("memberIdx");
		if(memberIdxStr != null) {
			memberIdx = Integer.parseInt(memberIdxStr);
		}
		
		String userpwcheck = request.getParameter("userpwcheck");
		
		int resultCnt = 0; //삭제결과 
		boolean chk = false; //비밀번호 유효성 검사 결과 
		String msg = ""; //삭제 실패시 띄울 메시지 
		
		resultCnt = delMember(memberIdx, userpwcheck);
		
		request.setAttribute("resultCnt", resultCnt);
		
		return viewpage;
	}
	
	public int delMember(int memberIdx, String userpwcheck) {
		
		int resultCnt = 0;
		
		Connection conn;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDao dao = MemberDao.getInstance();
			resultCnt = dao.delete(conn, memberIdx);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultCnt;		
	}

}
