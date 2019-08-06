package com.storyafrica.sa.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	/*//로그아웃
	 * 1. controller 
	 * - 파라미터 : httpsession
	 * - 현재 세션 종료
	 * 
	 */	
	
	@RequestMapping("/member/logout")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate();
		System.out.println("세션 종료 됐니 컴터야? "+session.getId());
		return "redirect:/"; //메인페이지로 리다이렉트 
	}

}
