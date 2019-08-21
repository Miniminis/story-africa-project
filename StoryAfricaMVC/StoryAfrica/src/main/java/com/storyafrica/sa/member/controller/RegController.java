package com.storyafrica.sa.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storyafrica.sa.mail.service.MailSenderService;
import com.storyafrica.sa.member.domain.LoginInfo;
import com.storyafrica.sa.member.domain.MemberRegist;
import com.storyafrica.sa.member.service.RegService;

@Controller
public class RegController {
	
	@Autowired
	private RegService regService;
	
	@Autowired
	private MailSenderService mailservice;

	
	/*//1) 회원가입 폼 
	@RequestMapping(value = "/member/regform", method = RequestMethod.GET)
	public String getRegForm() {
		
		return "/member/memberRegForm";
	}*/
	
	//2) 회원가입처리 
	@RequestMapping(value = "/member/regMember", method = RequestMethod.POST)
	public String registMember(
								MemberRegist memberRegist,
								HttpServletRequest req,
								Model model) {
		
		//회원가입 처리 페이지로 보내줄 resultcnt, member 객체 Map 에 담아 보냄
		Map<String, Object> memberMap = new HashMap<String, Object>();
		
		memberMap = regService.regist(memberRegist, req);
		
		System.out.println("===controller"+memberRegist.toString()+"===controller END");
		
		model.addAllAttributes(memberMap);
		
		return "/member/memberReg";
	}
	
	@RequestMapping(value = "/member/verify")
	//@ResponseBody
	public String verifyMember(@RequestParam("vericode") String vericode,
								@RequestParam("userid") String userid,
								Model model) {
		int rscnt = 0;
		
		if(vericode != null && vericode != "" && 
				userid != null && userid != "") {
			
			rscnt =  regService.finalRegist(vericode, userid);
		}
		
		model.addAttribute("rscnt", rscnt);
		
		//return vericode+"  :  "+userid;
		return "/member/memberReg";
	
	}
	
	@RequestMapping(value = "/member/reverify")
	@ResponseBody
	public int reVerifyMember(HttpServletRequest req) {
		
		LoginInfo loginfo = (LoginInfo) req.getSession(false).getAttribute("ResendVeriEmail");
		
		System.out.println("메일재전송01"+loginfo.getUserid());
		int rcnt = regService.reverifyMember(loginfo.getUserid());
		
		return rcnt;
	}
	
		
}
