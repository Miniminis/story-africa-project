package com.storyafrica.sa.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storyafrica.sa.member.dao.MemberDao;
import com.storyafrica.sa.member.domain.EditedMember;
import com.storyafrica.sa.member.domain.Member;

@Service("editService")
public class EditService {
	
	@Autowired
	BasicDataSource dataSource;

	@Autowired
	MemberDao dao;
	
	public Member getMember(int memberIdx) {
		
		Connection conn;
		Member member = null;
		
		try {
			conn = dataSource.getConnection();
			
			member = dao.selectMemberByIdx(conn, memberIdx);		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
		
	}
	
	public int editMember(EditedMember editedMember,
							HttpServletRequest req) {
		
		System.out.println("==editServiceParam"+editedMember+"===");

		int rscnt = 0;
		Member member = editedMember.toMember(); //남은 변수 파일 2개
		
		System.out.println("==editServiceParam2 "+member+"===");
		
		String path = "/uploadedfile/userphoto";
		String dir = req.getSession().getServletContext().getRealPath(path);
		
		Connection conn;
		
		//파일이 수정되었다면 
		if(editedMember.getUserphoto() != null
				&& !editedMember.getUserphoto().isEmpty()
				&& editedMember.getUserphoto().getSize()>0) {
			
			String newfilename = editedMember.getUserid()+"_"+editedMember.getUserphoto().getOriginalFilename()+System.nanoTime();
			
			try {
				//새 파일 저장 
				editedMember.getUserphoto().transferTo(new File(dir, newfilename));
				//새로운 파일명 DB 저장을 위해 member 객체에 삽입 
				member.setUserphoto(newfilename); 
				//디렉토리에 있는 이전 파일 삭제 
				File oldfile = new File(dir, editedMember.getOldPhoto());
				if(oldfile != null && oldfile.exists()) {
					oldfile.delete();
				}
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else { //만약 수정된 파일이 없다면 oldfile 그대로 사용 
			member.setUserphoto(editedMember.getOldPhoto());
		}
		
		System.out.println("====editservice==="+member+"=======");
		
		try {
			conn = dataSource.getConnection();
			
			rscnt = dao.edit(conn, member);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		return rscnt;
	}
}
