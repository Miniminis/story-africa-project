package com.client.project;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.client.project.domain.Member;

@Controller
public class RestClientController {
	
	@RequestMapping("/list")
	@ResponseBody
	@CrossOrigin
	public List<Member> getAllList() {
		
		RestTemplate template = new RestTemplate(); 
			//RestController 에서 가져올때는 배열형태로 list 를 가져오게 됨 
		
		Member[] members = template.getForObject("http://localhost:8080/sa/rest/users", 
													Member[].class);
		
		List<Member> memberlist = Arrays.asList(members);
		
		for(Member m : memberlist) {
			System.out.println(m);
		}
		
		return memberlist;
	}
	
	@RequestMapping("/member/{idx}")
	@ResponseBody
	public Member getMember(@PathVariable("idx") int idx) {
		
		RestTemplate template = new RestTemplate();
		
		Member member = template.getForObject("http://localhost:8080/sa/rest/users/{idx}", 
												Member.class, 
												idx);
		System.out.println(member);
		return member;
	}

}
/* 우회 API 
 * 공공 데이터 포털 : 보안상의 이유로 client 에서 접근을 차단  // 자바스크립트를 통한 통신을 차단 
 *
 * Client : 공공 api 데이터에 접근하고 싶음 
 * 이를 restTemplate 을 사용하여 접근하면 가능! 
 * 따라서, client --> 요청 : REST API SERVER --> 요청 : 공공 데이터  
 * */