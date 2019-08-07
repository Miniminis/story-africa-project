package com.storyafrica.sa.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.storyafrica.sa.member.domain.ListSearchParam;
import com.storyafrica.sa.member.domain.Member;

@Repository("dao")
public class MemberDao {
	
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
	
	//아이디 통해서 검색
	public Member selectMemberById(Connection conn, String userid) {
		
		String sql = "select * from memberinfo where userid=?";
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs !=null && rs.next()) {
				System.out.println("selectMemberById 1: "+rs.getString(2));
				
				member = new Member();
				
				member.setIdx(rs.getInt(1));
				member.setUserid(rs.getString(2));
				member.setUserpw(rs.getString(3));
				member.setUsername(rs.getString(4));
				member.setUserphoto(rs.getString(5));
				member.setRegdate(rs.getDate(6));
				
				System.out.println("selectMemberById 2 : "+member.toString());
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return member;
	}
	
	//전체 게시글 개수 selectCnt()
	public int selectCnt(Connection conn, ListSearchParam sparam) {
		
		int totalCnt = 0;
		ResultSet rs = null;
		
		String sql = "select count(*) from memberinfo";
		Statement stmt = null;
		
		//만약 검색어가 있다면 그에 따라서 sql 문 분기처리 
		if(sparam != null) {
			sql = "select count(*) from memberinfo where ";
			
			//조건 1) 키워드 검색 
			if(sparam.getSearchType().equals("idPlusName")) {
				sql += " userid like '%"+sparam.getKeyword()+"%' or username like '%"+sparam.getKeyword()+"%' ";
			} else if(sparam.getSearchType().equals("id")) {
				sql += " userid like '%"+sparam.getKeyword()+"%' ";
			} else if(sparam.getSearchType().equals("name")) {
				sql += " username like '%"+sparam.getKeyword()+"%' ";
			}
			
			//조건 2) 기간 검색 
			if(sparam.getSearchPeriod().equals("AllPeriod")) {
				sql += "and regdate < now()";
			} else if(sparam.getSearchPeriod().equals("day")) {
				sql += "and regdate between date_add(now(), interval -1 day) and now()";
			} else if(sparam.getSearchPeriod().equals("week")) {
				sql += "and regdate between date_add(now(), interval -1 week) and now()";
			} else if (sparam.getSearchPeriod().equals("month")) {
				sql += "and regdate between date_add(now(), interval -1 month) and now()";
			} else if (sparam.getSearchPeriod().equals("year")) {
				sql += "and regdate between date_add(now(), interval -1 year) and now()";
			}
			
		}

		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("=====totalcnt DAO ");
		System.out.println(totalCnt);
		System.out.println(sql);
		System.out.println("=====totalcnt END");
		
		return totalCnt;
	}
	
	//회원리스트 출력 
	public List<Member> selectList(Connection conn, int index, int memberNumPerPage, 
									ListSearchParam sparam) {
		
		List<Member> memberlist = new ArrayList<Member>();
		
		ResultSet rs = null;
		
		String sql = "select * from memberinfo order by idx desc limit ?, ?";
		PreparedStatement pstmt = null;
		
		if(sparam != null) {
			//조건 1) 검색어 
			sql =  "select * from memberinfo where ";
			if(sparam.getSearchType().equals("idPlusName")) {
				sql += " userid like '%"+sparam.getKeyword()+"%' or username like '%"+sparam.getKeyword()+"%' ";
			} else if(sparam.getSearchType().equals("id")) {
				sql += " userid like '%"+ sparam.getKeyword()+"%' ";
			} else if(sparam.getSearchType().equals("name")) {
				sql += " username like '%"+sparam.getKeyword()+"%' ";
			}
			
			//조건 2) 기간 검색 
			if(sparam.getSearchPeriod().equals("AllPeriod")) {
				sql += "and regdate < now()";
			} else if(sparam.getSearchPeriod().equals("day")) {
				sql += "and regdate between date_add(now(), interval -1 day) and now()";
			} else if(sparam.getSearchPeriod().equals("week")) {
				sql += "and regdate between date_add(now(), interval -1 week) and now()";
			} else if (sparam.getSearchPeriod().equals("month")) {
				sql += "and regdate between date_add(now(), interval -1 month) and now()";
			} else if (sparam.getSearchPeriod().equals("year")) {
				sql += "and regdate between date_add(now(), interval -1 year) and now()";
			}
			
			//정렬조건 추가 
			sql += " order by idx desc limit ?, ? ";
			
		}
		
		System.out.println("==selectlist sql 문 분기처리===");
		System.out.println(sql);
		System.out.println("==selectlist sql 문 분기처리 끝 ===");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, index);
			pstmt.setInt(2, memberNumPerPage);
			System.out.println("===DAO====");
			System.out.println(index);
			System.out.println(memberNumPerPage);
			System.out.println("===DAO END====");

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
		
		System.out.println("===DAO 2====");
		System.out.println(index);
		System.out.println(memberNumPerPage);
		System.out.println(memberlist);
		System.out.println("===DAO2 END====");
		
		return memberlist;
	}
	
	//idx 통해서 검색하기 
	public Member selectMemberByIdx(Connection conn, int memberIdx) {
		
		String sql = "select * from memberinfo where idx=?";
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberIdx);
			
			rs = pstmt.executeQuery();
			
			if(rs !=null && rs.next()) {				
				member = new Member();
				
				member.setIdx(rs.getInt(1));
				member.setUserid(rs.getString(2));
				member.setUserpw(rs.getString(3));
				member.setUsername(rs.getString(4));
				member.setUserphoto(rs.getString(5));
				member.setRegdate(rs.getDate(6));
				
				System.out.println("selectMemberById 2 : "+member.toString());
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return member;
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

}
