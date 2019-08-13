package com.storyafrica.sa.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.storyafrica.sa.member.domain.ListSearchParam;
import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.domain.RowMemberMapper;

@Repository("dao")
public class MemberDao {
	
	//@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//회원가입 
	public int insert(Member member) {
		
		String sql = "insert into memberinfo values(null, ?, ?, ?, ?, now())";
		return jdbcTemplate.update(sql, 
							member.getUserid(), 
							member.getUserpw(), 
							member.getUsername(),
							member.getUserphoto());
	}
	
	//아이디 통해서 검색
	public Member selectMemberById(String userid) {
		
		String sql = "select * from memberinfo where userid=?";
		
		Member member = null; 
		
		try {
			member = jdbcTemplate.queryForObject(sql, new RowMemberMapper(), userid);
			
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	//전체 게시글 개수 selectCnt()
	public int selectCnt(ListSearchParam sparam) {
		
		String sql = "select count(*) from memberinfo";
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
		
		System.out.println("=====totalcnt DAO ");
		System.out.println(sql);
		System.out.println("=====totalcnt END");
		
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	//회원리스트 출력 
	public List<Member> selectList(int index, int memberNumPerPage, 
									ListSearchParam sparam) {
		
		String sql = "select * from memberinfo order by idx desc limit ?, ?";
		
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
		
		
		List<Member> memberlist = jdbcTemplate.query(sql, new RowMemberMapper(), index, memberNumPerPage);
		
		System.out.println("===DAO 2====");
		System.out.println(index);
		System.out.println(memberNumPerPage);
		System.out.println(memberlist);
		System.out.println("===DAO2 END====");
		
		return memberlist.isEmpty() ? null : memberlist;
	}
	
	//idx 통해서 검색하기 
	public Member selectMemberByIdx(int memberIdx) {
		
		String sql = "select * from memberinfo where idx=?";
		Member member = null;
		
		try {
			member = jdbcTemplate.queryForObject(sql, new RowMemberMapper(), memberIdx);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}
	
	//회원삭제 
	public int delete(int memberIdx) {
		
		String sql = "delete from memberinfo where idx=?";
		
		return jdbcTemplate.update(sql, memberIdx);
	}
	
	//회원수정 
	public int edit(Member member) {
		System.out.println("===editDAO====="+member+"===========");

		String sql = " update memberinfo set userpw=?, username=?, "
				+ " userphoto=? where idx=? ";
		
		return jdbcTemplate.update(sql, 
							member.getUserpw(), 
							member.getUsername(), 
							member.getUserphoto(), 
							member.getIdx());
		
	}

}
