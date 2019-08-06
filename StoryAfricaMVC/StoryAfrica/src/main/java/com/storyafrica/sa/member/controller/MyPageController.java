package com.storyafrica.sa.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {
	
	/* 마이페이지 
	 * 1. controller 
	 * - 세션 값에 따라 페이지 뷰 분기처리 
	 * - 로그인 : 마이페이지 
	 * - 미로그인 : 로그인 폼 
	 * 
	 * */
	
	@RequestMapping("/member/mypage")
	public String showMyPage(HttpSession session) {
		
		String viewpage = "/member/myPage";
		
		if(session ==null || session.getAttribute("LoginInfo") == null) {
			viewpage = "/member/loginRequired"; //로그인 필요 팝업창
		}
		
		return viewpage;
	}
}
