package com.storyafrica.sa.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.storyafrica.sa.member.exception.InvalidPasswordException;
import com.storyafrica.sa.member.exception.MemberNotFoundException;
import com.storyafrica.sa.member.exception.WrongPasswordException;
import com.storyafrica.sa.member.service.DeleteService;

@Controller
public class DeleteController {
	
	@Autowired
	DeleteService deleteService;
	
	@RequestMapping("/member/deleteForm")
	public String deleteForm(@RequestParam("memberIdx") int memberIdx, 
							Model model) {		
		
		model.addAttribute("memberIdx", memberIdx);
		
		return "/member/delForm";
	}
	
	@RequestMapping("/member/deleteProcess")
	public String deleteProcess(@RequestParam("memberIdx") int memberIdx,
								@RequestParam("userpwcheck") String userpwcheck,
								Model model) {
		
		int resultCnt = 0;
		
		try {
			resultCnt = deleteService.deleteProcess(memberIdx, userpwcheck);
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (WrongPasswordException e) {
			e.printStackTrace();
		}		
		
		model.addAttribute("resultCnt", resultCnt);
		
		return "/member/delProcess";
	}

}
