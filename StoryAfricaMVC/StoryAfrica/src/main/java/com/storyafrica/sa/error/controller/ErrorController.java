package com.storyafrica.sa.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.storyafrica.sa.member.domain.Member;

@Controller
public class ErrorController {

	@RequestMapping("/error/pagenotfound")
	public String errorPage() {
		
		Member member = null;
		
		System.out.println(member.getUserid());
		
		return "/errorPage/defaultErrorPage";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handlerNullPointerException(NullPointerException e) {
		
		return "/errorPage/NullPointerException";
	}
}
