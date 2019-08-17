package com.storyafrica.sa.member.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.domain.MemberRegist;
import com.storyafrica.sa.member.domain.MemberRegistREST;
import com.storyafrica.sa.member.exception.InvalidPasswordException;
import com.storyafrica.sa.member.exception.MemberNotFoundException;
import com.storyafrica.sa.member.exception.WrongPasswordException;
import com.storyafrica.sa.member.service.DeleteService;
import com.storyafrica.sa.member.service.MemberListService;
import com.storyafrica.sa.member.service.RegService;

/*uri
 * api/users - GET : 모든 리스트, 페이징 처리됨
 * api/users/{id} - GET: 회원 1명 select
 * api/users - POST : 회원 1명 insert
 * api/users/{id} - PUT : 회원 1명 정보 update
 * api/users/{id} - DELETE : 회원 1명 정보 delete 
 * */

@Controller 
@RequestMapping("/api/users")
public class RestApiController {
	
	@Autowired
	private MemberListService memberListService;
	
	@Autowired
	private RegService regService;
	
	@Autowired
	private DeleteService deleteService;
	
	
	//@CrossOrigin("http://www.naver.com") 
	//CORS : 웹피이지의 제한된 자원을 외부의 도메인에서 접근하도록 허용해주는 매커니즘
	/*
	 * ERRROR: Access to XMLHttpRequest at 'http://localhost:8080/sa/api/members'
	 * from origin 'file://' has been blocked by CORS policy: No
	 * 'Access-Control-Allow-Origin' header is present on the requested resource.
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Member> getAllList() {
		
		return memberListService.getMemberListRest();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public int regMember(
			@RequestBody MemberRegist regMemRest,
			HttpServletRequest req) {
		
		Map<String, Object> memberMap = new HashMap<String, Object>();
 
		System.out.println("rest1"+regMemRest.getUserid()+"/"+regMemRest.getUsername()+"/"+regMemRest.getUserpw());
		System.out.println("rest2"+req);
		
		memberMap = regService.regist(regMemRest, req);
		
		System.out.println("rest3"+memberMap);
		
		int resultcnt = 0;
		
		if(memberMap != null) {
			resultcnt = 1;
		} 
		System.out.println(resultcnt);
		return resultcnt;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public int delMember(@PathVariable("id") int memberIdx) {
		
		int resultCnt = 0;
		
		try {
			resultCnt = deleteService.deleteProcess(memberIdx);
			
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (WrongPasswordException e) {
			e.printStackTrace();
		}
		
		return resultCnt;
		
	}

}
