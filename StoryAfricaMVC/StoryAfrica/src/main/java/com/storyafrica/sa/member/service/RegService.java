package com.storyafrica.sa.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.member.dao.MemberDao;
import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.domain.MemberRegist;

@Service("regService")
public class RegService implements MemberService {
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	private MemberDao dao;
	
	public Map<String, Object> regist(MemberRegist memberRegist, HttpServletRequest req, Map memberMap) {
		
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
		Connection conn;
		
		try {
			conn = dataSource.getConnection();
			
			//파일을 서버의 지정 경로에 저장 - 파일 객체 존재 여부에 따라 분기 처리 
			if(memberRegist.getUserphoto().isEmpty()) {
				newfileName = "noImg.png";
				//파일이 없다면 따로 서버에 저장해주지 않는다. 
			} else {
				memberRegist.getUserphoto().transferTo(new File(dir, newfileName));
			}
			
			System.out.println("=====dir, newfiename : "+dir+"===="+newfileName+"=======");
			
			//아까 저장하지 못한 파일을 member 객체에 저장
			member.setUserphoto(newfileName);

			//member 객체 DB에 저장 
			resultCnt = dao.insert(conn, member);
			//저장된 DB의 member 정보를 기존의 member 객체에 덮어씌우기 
			member = dao.selectMemberById(conn, member.getUserid());
			System.out.println("==regservice"+member+"==regservice END");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		memberMap.put("resultCnt", resultCnt);
		memberMap.put("member", member);

		return memberMap;
				
	}
	

}
