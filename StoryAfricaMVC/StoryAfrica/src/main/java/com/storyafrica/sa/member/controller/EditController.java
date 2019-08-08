package com.storyafrica.sa.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.storyafrica.sa.member.domain.EditedMember;
import com.storyafrica.sa.member.domain.Member;
import com.storyafrica.sa.member.domain.MemberRegist;
import com.storyafrica.sa.member.service.EditService;

@Controller
public class EditController {
	
	/* 수정 
	 * 1. DB에서 기존 데이터 가져오기 
	 * 2. 수정 폼 이동 
	 * 3. 수정폼: 기존 데이터 불러와서 표시
	 * - 파일 부분 : 기존파일과 새로운 파일 처리  
	 * 4. 새로 입력된 데이터 다시 DB에 저장 
	 * 
	 * */
	
	@Autowired
	EditService editService;
	
	@RequestMapping("/member/editForm")
	public String editForm(@RequestParam("memberIdx") int memberIdx,
							Model model) {
		
		Member member = editService.getMember(memberIdx);
		
		model.addAttribute("member", member);
		
		return "/member/editForm";
	}
	
	@RequestMapping(value = "/member/editMember", method = RequestMethod.POST)
	public String editProcess(EditedMember editedMember,
							HttpServletRequest req,
							Model model) {
		
		System.out.println("==contollerrParam"+editedMember+"===");
		
		int rscnt = editService.editMember(editedMember, req);
		
		model.addAttribute("rscnt", rscnt);
		System.out.println("==contollerrscnt"+rscnt+"===");
		
		return "/member/editResult";
	}
	
	
	
	

}
