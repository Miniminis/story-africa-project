package com.storyafrica.sa.member.dao;

import java.util.List;
import java.util.Map;

import com.storyafrica.sa.member.domain.ListSearchParam;
import com.storyafrica.sa.member.domain.Member;

//1. pom.xml 라이브러리추가 
//2. MemberSessionDao 인터페이스 생성 
//3. mapper 생성 - sql 작성 
public interface MemberSessionDao {
	
	public int insert(Member member);
	public Member selectMemberById(String userid);
	public int selectCnt(ListSearchParam sparam);
	public List<Member> selectList(Map<String, Object> paraMap);
	public Member selectMemberByIdx(int memberIdx);
	public int delete(int memberIdx);
	public int edit(Member member);

}
