package com.storyafrica.sa.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storyafrica.sa.member.service.RegService;

@Controller
public class IdCheckController {
	
	@Autowired
	private RegService regService;
	
	//@RequestMapping("/member/regIdChk")
	public String idChk01(@RequestParam("id") String id,
							Model model){
		
		model.addAttribute("resultCode", regService.idChk(id));
		return "/member/memberRegIdChk";
	}
	
	//@ResponseBody 
	//따로 뷰페이지를 구성하지 않고 간단한 Y/N과 같은 문자, 0/1과 같은 숫자를 페이지로 보냄으로서 
	//ajax 처리를 보다 효율적으로 할 수 있다. 
	@RequestMapping("/member/regIdChk")
	@ResponseBody
	public String idChk02(@RequestParam("id") String id,
							Model model){
				
		return regService.idChk2(id);
	}

}
