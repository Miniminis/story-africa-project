package com.storyafrica.sa.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.storyafrica.sa.member.domain.ListSearchParam;
import com.storyafrica.sa.member.domain.LoginInfo;
import com.storyafrica.sa.member.domain.MemberList;
import com.storyafrica.sa.member.service.MemberListService;

@Controller
public class ListController {
	
	/* 회원리스트 
	 * - 관리자 세션 로그인 상태 : memberList 페이지 이동 
	 * - service, dao 통해서 전체 회원리스트 가져와 MemberList 객체에 담아 전달 
	 * - 관리자 미로그인 상태 : loginRequired 페이지 
	 * */

	@Autowired
	private MemberListService memberListService;
	
	@RequestMapping("/member/memberlist")
	public String showMemberList(
								HttpServletRequest req, 
								Model model,
								@RequestParam(value = "page", defaultValue = "1") int page,
								@RequestParam(value = "searchType", required = false) String searchType, 
								@RequestParam(value = "keyword", required = false) String keyword,
								@RequestParam(value = "searchPeriod", required = false) String searchPeriod
								) {
		
		//default 미로그인 - 로그인 요청 페이지 
		String viewpage = "/member/loginRequiredAdmin";
		
		HttpSession session = req.getSession(false);
		
		//검색유형+키워드 받아서 객체 생성 
		ListSearchParam sparam = null;
		
		if(
				searchType != null 
				&& keyword != null
				&& searchPeriod !=null
				&& !searchType.isEmpty()
				&& !keyword.isEmpty()
				&& !searchPeriod.isEmpty()
				) {
			
			sparam = new ListSearchParam();
			sparam.setSearchType(searchType);
			sparam.setKeyword(keyword);
			sparam.setSearchPeriod(searchPeriod);
		}

		//로그인 시
		if(session != null && session.getAttribute("LoginInfo") != null) {
			
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("LoginInfo");
			
			if(loginInfo.getUserid().equals("admin")) {
				MemberList list = memberListService.getMemberList(page, sparam);
				
				model.addAttribute("list", list);
				
				viewpage = "/member/memberList";
			}

		}		
		
		return viewpage;
	}
	
	
	
}
