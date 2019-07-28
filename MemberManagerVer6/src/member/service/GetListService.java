package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.model.MemberList;

public class GetListService implements MemberService{
	
	//반환할 데이터 설정
	MemberList list = null; 

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		//반환할 페이지 설정
		String viewpage="/WEB-INF/member/memberList.jsp";
		
		
		//네브바 혹은 리스트 페이지에서 받을 리스트 번호 파라미터로 받기 
		int curPageNum = 1;
		
		String pageNumStr = request.getParameter("page");
		
		if(pageNumStr != null) {
			curPageNum = Integer.parseInt(pageNumStr);
		}

		System.out.println("curPageNum은 "+curPageNum);
		
		//받은 페이지 번호로 리스트 가져오기  	
		list = getListView(curPageNum); 
			
		//파라미터 포워딩
		request.setAttribute("list", list);
		 
		//뷰페이지로 연결 
		return viewpage;
	}
	
	private static final int ARTICLE_COUNT_PER_PAGE = 5;  //한페이지 당 게시글의 수 FINAL처리 	
	
	public MemberList getListView(int pagenumber) {
		
		//한페이지에 5명씩 멤버 리스트 출력하는데 필요한 변수들 				
		int articleTotalCnt = 0;  //총 게시글 수 
		int curPageNum = pagenumber; //현재 페이지 번호
		int startRow = 0; //리스트 시작줄
		List<Member> memberlist = null;  //리스트 타입의 객체 
		
		Connection conn;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			//총 게시글 수 
			MemberDao dao = MemberDao.getInstance();
			articleTotalCnt = dao.selectCnt(conn);

			
			if(articleTotalCnt > 0) {
				
				//파라미터로 넘겨받은 pageNumber 에 따라서 게시판 리스트의 시작로우와 끝 로우가 정해진다.
				startRow = (curPageNum -1)*ARTICLE_COUNT_PER_PAGE +1;	
				
				//첫째줄과 함께 dao 로 넘기기 
				//반환: MemberList 타입 list
				memberlist = dao.selectList(conn, startRow);
				
			} else {
				curPageNum = 0;
				memberlist = Collections.emptyList();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//리스트 객체 생성
		list = new MemberList(articleTotalCnt, curPageNum, startRow, memberlist, ARTICLE_COUNT_PER_PAGE);
		
		return list;
	}
	

}
