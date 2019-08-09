package com.storyafrica.sa.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.member.dao.MemberDao;
import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.exception.InvalidPasswordException;
import com.storyafrica.sa.member.exception.MemberNotFoundException;
import com.storyafrica.sa.member.exception.WrongPasswordException;

@Service("deleteService")
public class DeleteService implements MemberService{
	
	@Autowired
	MemberDao dao;
	
	public int deleteProcess(int memberIdx) throws 
							InvalidPasswordException, MemberNotFoundException, 
							SQLException, WrongPasswordException {

		//삭제하기 전에 확인사항 
		Member member = dao.selectMemberByIdx(memberIdx);
		
		if(member == null) {
			 throw new MemberNotFoundException("존재하지 않는 회원입니다! ");
		} 
		
		//확인되면 삭제
		return dao.delete(memberIdx);
	}

}
