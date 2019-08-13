package com.storyafrica.sa.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.member.dao.MemberDao;
import com.storyafrica.sa.member.dao.MemberSessionDao;
import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.domain.MemberRegist;

@Service("regService")
public class RegService implements MemberService {
	
	@Autowired
	private SqlSessionTemplate sqltemplate;
	
	private MemberSessionDao memSessDao; //위에 붙이면 같이 autowired됨 !
	
	
	public Map<String, Object> regist(MemberRegist memberRegist, HttpServletRequest req, Map<String, Object> memberMap) {
		
		memSessDao = sqltemplate.getMapper(MemberSessionDao.class);
		
		//form 으로부터 전달받은 정보 중 파일형식이 아닌 아이디, 비번, 이름을 먼저 객체에 저장 
		Member member = memberRegist.toMember();
		
		//회원의 사진 파일 저장을 위한 작업 시작 		
		//서버상의 경로 
		String path = "/uploadedfile/userphoto";
		//절대 경로 : request, session, servletcontext, getrealpath 
		String dir = req.getSession().getServletContext().getRealPath(path);
		//파일이름 중복 방지를 위한 이름 재정의
		
		String newfileName = member.getUserid()+"_"+memberRegist.getUserphoto().getOriginalFilename();
		
		//반환 변수 
		int resultCnt = 0;
			
		//파일을 서버의 지정 경로에 저장 - 파일 객체 존재 여부에 따라 분기 처리 
		if(memberRegist.getUserphoto().isEmpty()) {
			newfileName = "noImg.png";
			//파일이 없다면 따로 서버에 저장해주지 않는다. 
		} else {
			try {
				memberRegist.getUserphoto().transferTo(new File(dir, newfileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		System.out.println("REG-SERVICE DIR/NEWFILENAME: "+dir+"===="+newfileName+"=======");
			
		//아까 저장하지 못한 파일을 member 객체에 저장
		member.setUserphoto(newfileName);

		//member 객체 DB에 저장 
		resultCnt = memSessDao.insert(member);
		
		//저장된 DB의 member 정보를 기존의 member 객체에 덮어씌우기 
		member = memSessDao.selectMemberById(member.getUserid());
		System.out.println("==regservice"+member+"==regservice END");
		
		memberMap.put("resultCnt", resultCnt);
		memberMap.put("member", member);

		return memberMap;
				
	}
	
	//중복아이디 체크 01
	public char idChk(String id) {
		memSessDao = sqltemplate.getMapper(MemberSessionDao.class);
		
		char chk = memSessDao.selectMemberById(id)==null ? 'Y' : 'N';
		
		return chk;
	}
	
	//중복아이디 체크 02
	public String idChk2(String id) {
		memSessDao = sqltemplate.getMapper(MemberSessionDao.class);

		String chk = memSessDao.selectMemberById(id)==null?"Y":"N";
		
		return chk;
	}
	

}
