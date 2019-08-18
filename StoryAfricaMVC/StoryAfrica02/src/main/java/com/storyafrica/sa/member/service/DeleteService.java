package com.storyafrica.sa.member.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.member.dao.MemberSessionDao;
import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.exception.InvalidPasswordException;
import com.storyafrica.sa.member.exception.MemberNotFoundException;
import com.storyafrica.sa.member.exception.WrongPasswordException;

@Service("deleteService")
public class DeleteService implements MemberService{
	
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	private MemberSessionDao memDao;
	
	public int deleteProcess(int memberIdx) throws 
							InvalidPasswordException, MemberNotFoundException, 
							SQLException, WrongPasswordException {

		memDao = sqlTemplate.getMapper(MemberSessionDao.class);
		
		//삭제하기 전에 확인사항 
		Member member = memDao.selectMemberByIdx(memberIdx);
		
		if(member == null) {
			 throw new MemberNotFoundException("존재하지 않는 회원입니다! ");
		} 
		
		//확인되면 삭제
		return memDao.delete(memberIdx);
	}

}
