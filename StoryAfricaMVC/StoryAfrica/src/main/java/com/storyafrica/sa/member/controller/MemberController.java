package com.storyafrica.sa.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storyafrica.sa.member.domain.MemberList;
import com.storyafrica.sa.member.service.MemberListService;

@RestController
/* uri 
 * /api/members - get 리스트 
 * /api/members - post 회원등록 
 * /api/members/{id} - get 회원1명 조회 
 * /api/members/{id} - put 회원 1명 수정 
 * /api/members/{id} - delete 회원 1명 탈퇴 
 * */
public class MemberController {

	@Autowired 
	private MemberListService memberListService;
	
	
	//리스트
	@GetMapping("/api/members")
	@CrossOrigin
	public MemberList getMemList() {		
		return null;
		
	}
	
	//등록 
	@PostMapping("/api/members")
	@CrossOrigin
	public int enrollMem() {
		return 0;
	}
	
	//수정
	@PutMapping("/api/members/{id}")
	@CrossOrigin
	public int editMem() {
		return 0;
	}
	
	//삭제 
	@DeleteMapping("/api/members/{id}")
	@CrossOrigin
	public int delMem() {
		return 0;
	}

}
