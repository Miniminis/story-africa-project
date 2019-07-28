package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class RegIdChkService implements MemberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		//이미 사용중인 아이디인지 유효성검사 
		String userid = request.getParameter("id");
		
		Member member=null;
		Connection conn;
		
		String resultCode = "N";
		
		try {
			conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			
			if(userid == null) {
				resultCode = "N";
			} else {
				member = dao.selectOne(conn, userid);
				
				if(member == null) {
					resultCode = "Y";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println(member.toString()); 
		//만약 member 객체가 null 이라면, nullpointer 오류가 뜰 것임! 
		System.out.println(resultCode);
		
		request.setAttribute("resultCode", resultCode);
		return "/WEB-INF/member/memberRegIdChk.jsp"; 
	}

}
