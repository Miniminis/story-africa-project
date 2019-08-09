package com.storyafrica.sa.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.member.dao.MemberDao;
import com.storyafrica.sa.member.domain.LoginInfo;
import com.storyafrica.sa.member.domain.Member;

@Service("loginService")
public class LoginService implements MemberService{
	
	@Autowired
	MemberDao dao;
	
	public boolean loginProcess(String uid, String upw, HttpServletRequest req) {
		
		boolean loginChk = false; //로그인 성공 여부
		//DB 검색 결과 사용자 정보 담을 member 객체 
		Member member = dao.selectMemberById(uid);
			
		if(member != null && member.pwChk(upw)) {
			//DB에 회원정보가 있고, 비밀번호가 일치한다면, 세션에 정보 저장 
			LoginInfo loginInfo = member.toLoginInfo();
			
			req.getSession(false).setAttribute("LoginInfo", loginInfo);
			System.out.println(loginInfo.toString());
			loginChk = true;
		}
	
		return loginChk;
	}

}
