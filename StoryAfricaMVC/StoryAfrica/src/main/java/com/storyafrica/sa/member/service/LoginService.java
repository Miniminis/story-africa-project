package com.storyafrica.sa.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.mail.service.MailSenderService;
import com.storyafrica.sa.member.dao.MemberSessionDao;
import com.storyafrica.sa.member.domain.LoginInfo;
import com.storyafrica.sa.member.domain.Member;

@Service("loginService")
public class LoginService implements MemberService{
	
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	private MemberSessionDao memDao;
	
	@Autowired
	MailSenderService mailService;
	
	public int loginProcess(String uid, String upw, HttpServletRequest req) {
		
		memDao = sqlTemplate.getMapper(MemberSessionDao.class);
		
		//DB 검색 결과 사용자 정보 담을 member 객체 
		Member member = memDao.selectMemberById(uid);
		
		/*//로그인 분기처리 3가지 
		 * 1. 미인증회원
		 * 2. 비밀번호 불일치 - 로그인 실패  
		 * 3. 인증회원 & 비밀번호 일치 
		 * */		
		
		int loginChk = 0; //로그인 성공 여부
		
		if(member != null && member.pwChk(upw)) {
			
			if(member.getVerify() == 'Y') {
				//인증코드가 있다면 세션에 정보 저장 
				LoginInfo loginInfo = member.toLoginInfo(); 
				
				req.getSession(false).setAttribute("LoginInfo", loginInfo);
				System.out.println("==LOGIN SERVICE=="+loginInfo.toString());
				loginChk = 1;
			
			} else {
				//인증 코드가 없다면 
				LoginInfo loginInfo = member.toLoginInfo(); 
				req.getSession(false).setAttribute("ResendVeriEmail", loginInfo);
				loginChk = 2;
			}
		}
		
		return loginChk;
	}
	
	//비번 찾기위한 매서드 
	public int findMember(String userid, String username) {
		
		memDao = sqlTemplate.getMapper(MemberSessionDao.class);
		Member member = memDao.selectMemberByInfo(userid, username);
		
		int rscnt = 0;
		
		if(member != null) {
			rscnt = mailService.sendFindPwMail(userid, member.getRandomPw());
		}
		
		return rscnt;
	}
	
	
}
