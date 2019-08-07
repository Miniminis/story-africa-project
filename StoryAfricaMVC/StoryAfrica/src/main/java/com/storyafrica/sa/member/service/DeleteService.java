package com.storyafrica.sa.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
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
	BasicDataSource dataSource;
	
	@Autowired
	MemberDao dao;
	
	public int deleteProcess(int memberIdx, String userpwcheck) throws 
	InvalidPasswordException, MemberNotFoundException, SQLException, WrongPasswordException {
		int rscnt = 0;
		
		Connection conn;
		
		try {
			conn = dataSource.getConnection();
			
			//삭제하기 전에 확인사항 
			Member member = dao.selectMemberByIdx(conn, memberIdx);
			
			if(member == null) {
				 throw new MemberNotFoundException("존재하지 않는 회원입니다! ");
			} else if (member.getUserpw() == null
					&& member.getUserpw().isEmpty()) {
				throw new InvalidPasswordException("잘못된 비밀번호 형식입니다! ");
			} else if(!member.getUserpw().equals(userpwcheck)) {
				throw new WrongPasswordException("비밀번호가 일치하지 않습니다! ");
			}
			
			//확인되면 삭제
			rscnt = dao.delete(conn, memberIdx);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			throw e;
		} catch (WrongPasswordException e) {
			e.printStackTrace();
			throw e;
		}
		

		return rscnt;
	}

}
