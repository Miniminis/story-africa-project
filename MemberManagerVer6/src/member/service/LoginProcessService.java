package member.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.LoginInfo;
import member.model.Member;

public class LoginProcessService implements MemberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		/* 로그인 처리 
		 * 1. 로그인 폼: 사용자 아이디, 비밀번호
		 * 2. DB에 있는 아이디, 비밀번호 호출 
		 * - conn, dao(userid)
		 * - Member 객체 반환 
		 * 3. 입력된 아이디, 비밀번호와 DB 아이디, 비밀번호 비교
		 * - memberinfo.getid(), memberinfo.getpw() 
		 * - return true or false
		 * - return MemberInfo
		 * 
		 * 4. 결과 true 일때 : 로그인 정보 세션에 저장, 로그인 처리 팝업 
		 * 5. 결과 false 일때: 로그인 실패 처리 팝업 
		 * 
		 *  */
		
		String viewpage = "/WEB-INF/member/loginProcess.jsp";
		
		//한글값 처리를 위한 encoding 과정
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		//로그인 폼에서 정보 받아오기 
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		Member member = null; //DB 에서 사용자 정보 가져와서 담을 Member 객체 생성 
		boolean chk = false;//DB에 사용자 정보 일치 결과 여부 
		String msg = "디폴트 스트리으이으잉";
		
		//사용자 입력정보와 DB에 저장된 사용자 정보 비교
		Connection conn;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDao dao = MemberDao.getInstance();
			member = dao.selectOne(conn, userid);
			
			
			if(member != null && member.pwChk(userpw)) {
				//member 객체가 존재하고 
				//member.pwChk(): 
				//	1. DB에서 Member 객체에 담아서 가져올때 데이터의 유실은 없는가  
				//	2. 호옥시 DB에 저장되어있는 데이터가 공백 문자열이 들어가지는 않았는가 
				//	3. DB에서 담아온 데이터와 사용자가 입력한 데이터가 일치하는가 체크 
				
				request.getSession(false).setAttribute("LoginInfo", member.toLoginInfo());				
				chk = true;
				msg = "로그인이 정상적으로 처리되었습니다. ";
				
				System.out.println("5 "+member.toLoginInfo().toString());
				
			} else {
				System.out.println("6");
				msg = "아이디 혹은 비밀번호를 입력해주세요. ";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		request.setAttribute("chk", chk);
		request.setAttribute("msg", msg);
		
		return viewpage;
	}	
}
