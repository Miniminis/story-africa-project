package com.storyafrica.sa.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storyafrica.sa.member.domain.MemberRegist;
import com.storyafrica.sa.member.service.RegService;

@Controller
public class RegController {
	
	@Autowired
	private RegService regService;
	
	//1) 회원가입 폼 
	@RequestMapping(value = "/member/regform", method = RequestMethod.GET)
	public String getRegForm() {
		
		return "/member/memberRegForm";
	}
	
	//2) 회원가입처리 
	@RequestMapping(value = "/member/regMember", method = RequestMethod.POST)
	public String registMember(
								MemberRegist memberRegist,
								HttpServletRequest req,
								Model model) {
		
		//회원가입 처리 페이지로 보내줄 resultcnt, member 객체 Map 에 담아 보냄
		Map<String, Object> memberMap = new HashMap<String, Object>();
		
		memberMap = regService.regist(memberRegist, req, memberMap);
		
		System.out.println("===controller"+memberRegist.toString()+"===controller END");
		
		model.addAllAttributes(memberMap);
		
		return "/member/memberReg";
	}
		
}
