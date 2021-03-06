package com.storyafrica.sa.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storyafrica.sa.member.domain.LoginInfo;
import com.storyafrica.sa.member.service.LoginService;

@Controller
public class LoginController {
	
	//로그인 페이지 구성 
	/* 1. controller 
	 * - form 
	 * - login process: session 
	 * 2. view
	 * - 로그인 정상처리 - main 으로 이동 : redirect 
	 * - 로그인 실패 : 로그인 폼으로 script 이용하여 이동 
	 * 3. service 
	 * - get : 로그인 폼 : 세션 확인 푸 메인페이지 혹은 로그인 폼페이지 
	 * - post : id, pw 확인 후 로그인 처리 
	 * 4. DAO 
	 * - id로 검색한 결과! 
	 * 
	 */
	@Autowired
	LoginService loginService;
	
	//로그인 폼 
	@RequestMapping(value = "/member/loginform", method = RequestMethod.GET)
	public String getLoginForm(HttpServletRequest req) {
		
		String viewpage = "/member/login"; //기본 뷰페이지는 login form 
		
		HttpSession session = req.getSession(false);
		
		//1. 로그인 상태 
		if(session != null && session.getAttribute("LoginInfo") != null) {
			viewpage = "redirect:/"; //이미 로그인 되어있다면 메인페이지로 이동 
		}
		//System.out.println("session.getAttribute(\"LoginInfo\") : "+((LoginInfo) session.getAttribute("LoginInfo")).getUserid() );

		//2. 미로그인 상태 --> 위에서 정의된 viewpage 가 그대로 return
		System.out.println("미 로그인상태에서 로그인시도시 : "+viewpage);
		return viewpage;
	}
	
	//로그인 처리 
	@RequestMapping(value = "/member/loginProcess", method = RequestMethod.POST) 
	public String loginProcess(
			@RequestParam("userid") String uid, 
			@RequestParam("userpw") String upw,
			HttpServletRequest req
			) {
		
		//default page : 로그인 실패 
		String viewpage = "/member/loginfail";

		//로그인 성공 여부 
		int chk = loginService.loginProcess(uid, upw, req);
		System.out.println("컴터야, 로그인 성공햇니?:"+chk);
		
		//로그인 성공 시 뷰페이지 
		if(chk == 1) {
			viewpage = "redirect:/";

		} else if(chk==2) {
			viewpage = "/member/loginVerify";
		}
		
		return viewpage;
	}
	
	//로그아웃
	@RequestMapping("/member/logout")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate();
		System.out.println("세션 종료 됐니 컴터야? "+session.getId());
		return "redirect:/"; //메인페이지로 리다이렉트 
	}
	
	//마이페이지
	@RequestMapping("/member/mypage/filteredMypage")
	public String showMyPage(HttpSession session) {
		
		String viewpage = "/member/myPage";
		
		/*if(session ==null || session.getAttribute("LoginInfo") == null) {
			viewpage = "/member/loginRequired"; //로그인 필요 팝업창
		}*/
		
		return viewpage;
	}
	
	//로그인 필요 페이지 : + from interceptor
	@RequestMapping("/member/loginRequired")
	public String showLoginRequeiredPage() {
		return "/member/loginRequired";
	}
	
	//관리자 로그인 필요 페이지 + from interceptor
	@RequestMapping("/member/loginRequiredAdmin")
	public String showAdminLoginRequeiredPage() {
		return "/member/loginRequiredAdmin";
	}


	/* 비밀번호 찾기 
	 * 1. 뷰에서 전달 
	 * 2. 컨트: 비번 찾기위한 폼페이지 전달 
	 * 3. 뷰: 해당 폼에서 질문들 리스트로 받아서 post 로 넘기기 
	 * 4. 컨트 -서비-dao: 해당 정보와 정확히 일치하는 사용자 찾아서 member 타입으로 받기 
	 * 5. 해당 member 가 존재하면 - 비밀번호 암호화 메일 전송 
	 * 6. 존재하지 않으면 - 정보를 다시 확인해주세요! 
	 * */
	@RequestMapping("/member/forgotPw")
	public String forgotPW() {
		return "/member/forgotPw";
	}
	
	@RequestMapping("/member/findPw")
	@ResponseBody
	public int findPw(@RequestParam("userid") String userid,
							@RequestParam("username") String username) {
		
		return loginService.findMember(userid, username);
	}
	
	
}
