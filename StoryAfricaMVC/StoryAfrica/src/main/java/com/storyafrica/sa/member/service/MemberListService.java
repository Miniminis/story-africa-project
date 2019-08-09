package com.storyafrica.sa.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.member.dao.MemberDao;
import com.storyafrica.sa.member.domain.ListSearchParam;
import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.domain.MemberList;

@Service("memberListService")
public class MemberListService implements MemberService{
	
	@Autowired
	private MemberDao dao;
	
	public MemberList getMemberList(int page, ListSearchParam sparam) {
		//반환 정보 
		MemberList memberlistview = new MemberList();
		
		Connection conn;
		
		//MemberList 객체 출력을 위해 필요한 데이터들 
		List<Member> mlist = null;//리스트 타입의 객체 v
		int memberNumPerPage = 5; // 한 페이지 당 출력 개수 v
		int totalPageNum = 0; //전체 페이지 수 
		int totalMemNum = 0; //전체 회원 수 v
		int startRow = 0;  //뷰 페이지에서 보이는 리스트의 시작점  
		int index = 0; //리스트 페이지 당 출력을 
		int curPageNum = page; //현제 페이지 번호  v
			
		//전체 멤버 수 
		totalMemNum = dao.selectCnt(sparam);
			
		//각 페이지의 첫번째 row idx 구하기 
		index = memberNumPerPage*(curPageNum-1);
		startRow = totalMemNum - index;
			
		//DB에 있는 모든 회원 정보를 페이지당 5개씩만 표현 
		mlist = dao.selectList(index, memberNumPerPage, sparam); 
		
		totalPageNum = totalMemNum/memberNumPerPage;
		
		if(totalMemNum % memberNumPerPage != 0) {
			totalPageNum = totalPageNum+1;
		}
		
		System.out.println("=== LIST SERVICE==");
		System.out.println(mlist);
		System.out.println(memberNumPerPage);
		System.out.println(totalPageNum);
		System.out.println(curPageNum);
		System.out.println(totalMemNum);
		System.out.println(startRow);
		System.out.println("===LIST SERVICE END==");

		memberlistview.setMemberList(mlist);
		memberlistview.setMemberNumPerPage(memberNumPerPage);
		memberlistview.setTotalPageNum(totalPageNum);
		memberlistview.setCurPageNum(curPageNum);
		memberlistview.setTotalMemNum(totalMemNum);
		memberlistview.setStartRow(startRow);
		
		return memberlistview;
	}

}
