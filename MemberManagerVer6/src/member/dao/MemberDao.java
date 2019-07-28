package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.model.LoginInfo;
import member.model.Member;

public class MemberDao {
	
	private MemberDao() {}
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	//회원가입 
	public int insert(Connection conn, Member member) {
		int rsCnt=0;
		
		String sql = "insert into memberinfo values(null, ?, ?, ?, ?, now())";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getUserpw());
			pstmt.setString(3, member.getUsername());
			pstmt.setString(4, member.getUserphoto());
			
			rsCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rsCnt;
	}
	
	//전체 게시글 개수 selectCnt()
	public int selectCnt(Connection conn) {
		
		int totalArticleCnt = 0;
		ResultSet rs = null;
		
		String sql = "select count(*) from memberinfo";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				totalArticleCnt = rs.getInt(1);
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totalArticleCnt;
	}
	
	//회원리스트 출력 
	public List<Member> selectList(Connection conn, int startRow) {
		
		List<Member> memberlist = new ArrayList<Member>();
		
		ResultSet rs = null;
		
		String sql = "select * from memberinfo order by idx desc limit ?, 5";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow-1);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setIdx(rs.getInt(1)); 
				member.setUserid(rs.getString(2));
				member.setUserpw(rs.getString(3));
				member.setUsername(rs.getString(4));
				member.setUserphoto(rs.getString(5));
				member.setRegdate(rs.getDate(6));
				
				memberlist.add(member);
				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberlist;
	}
	
	//회원삭제 
	public int delete(Connection conn, int memberIdx) {
		int rsCnt = 0;
		
		String sql = "delete from memberinfo where idx=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberIdx);
			
			rsCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rsCnt;
	}
	
	//로그인 확인을 위한 selectOne 매서드 
	public Member selectOne(Connection conn, String userid) {
		
		String sql = "select * from memberinfo where userid=?";
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs !=null && rs.next()) {
				System.out.println("1 "+rs.getString(2));
				
				member = new Member();
				
				member.setUserid(rs.getString(2));
				member.setUserpw(rs.getString(3));
				member.setUsername(rs.getString(4));
				member.setUserphoto(rs.getString(5));
				member.setRegdate(rs.getDate(6));
				
				System.out.println("2 "+member.toString());
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return member;
	}
	
	
}
