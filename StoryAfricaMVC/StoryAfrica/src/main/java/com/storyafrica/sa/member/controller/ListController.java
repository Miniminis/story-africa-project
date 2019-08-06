package com.storyafrica.sa.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {
	
	/* 회원리스트 
	 * - 관리자 세션 로그인 상태 : memberList 페이지 이동 
	 * - service, dao 통해서 전체 회원리스트 가져와 MemberList 객체에 담아 전달 
	 * - 관리자 미로그인 상태 : loginRequired 페이지 
	 * */

	@RequestMapping("/member/memberlist")
	public String showMemberList(@RequestParam("page") int page,
								HttpServletRequest req) {
		String viewpage = "/member/memberList";
		
		
		
		
		
		return viewpage;
	}
}
