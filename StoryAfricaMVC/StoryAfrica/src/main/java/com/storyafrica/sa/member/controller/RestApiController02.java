package com.storyafrica.sa.member.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storyafrica.sa.member.domain.EditedMember;
import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.domain.MemberRegist;
import com.storyafrica.sa.member.exception.InvalidPasswordException;
import com.storyafrica.sa.member.exception.MemberNotFoundException;
import com.storyafrica.sa.member.exception.WrongPasswordException;
import com.storyafrica.sa.member.service.DeleteService;
import com.storyafrica.sa.member.service.EditService;
import com.storyafrica.sa.member.service.MemberListService;
import com.storyafrica.sa.member.service.RegService;

@RestController //@ResponseBody 생략 : 뷰페이지 구성하지 않고 데이터만 반환 
@RequestMapping("/rest/users")
public class RestApiController02 {
	
	@Autowired
	private MemberListService memberListService;
	
	@Autowired
	private DeleteService deleteService;
	
	@Autowired
	private RegService regService;
	
	@Autowired
	private EditService editService;
	
	//회원리스트
	@GetMapping()
	//@CrossOrigin
	public ResponseEntity<List<Member>> getMemList() {
		
		List<Member> memList = memberListService.getMemberListRest();
		
		ResponseEntity<List<Member>> entity 
			= new ResponseEntity<List<Member>>(memList, HttpStatus.OK); 
												//무조건 OK status 반환
												//데이터 호출 및 처리에 문제가 있어도 비정상적으로 종료되지 않도록 처리 
												//HttpStatus.NOT_FOUND : 404 
												//HttpStatus.INTERNAL_SERVER_ERROR : 500 
		
		return entity;
	}
	
	//회원등록
	@PostMapping()
	@CrossOrigin
	public ResponseEntity<Integer> regMember(
			MemberRegist memberRegist, 
			HttpServletRequest req
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = regService.regist(memberRegist, req);
		
		return new ResponseEntity<Integer>((Integer) map.get("resultCnt"), HttpStatus.OK);
	}
	
	//회원삭제
	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Integer> delMember(@PathVariable("id") int idx) {
		int rscnt = 0;
		
		try {
			rscnt = deleteService.deleteProcess(idx);
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (WrongPasswordException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Integer>(rscnt>0? 1:0, HttpStatus.OK);
	}
	
	//회원수정 
	@GetMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Member> getMember(
			@PathVariable("id") int memberIdx) {
		
		return new ResponseEntity<Member>(editService.getMember(memberIdx), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Integer> editMember(
			@PathVariable("id") int idx,
			@RequestBody EditedMember editedMember,
			HttpServletRequest req) {
		
		System.out.println("e0   "+idx);
		System.out.println("e1  "+editedMember.toString());
		
		editedMember.setIdx(idx);
		int rscnt =  editService.editMember(editedMember, req);

		System.out.println("e6   "+rscnt);

		return new ResponseEntity<Integer>(rscnt, HttpStatus.OK);
	}
}
