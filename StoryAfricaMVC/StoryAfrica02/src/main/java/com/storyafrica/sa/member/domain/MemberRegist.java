package com.storyafrica.sa.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegist {
	
	private String userid;
	private String userpw;
	private String username;
	private MultipartFile userphoto;
	
	public MemberRegist() {}

	public MemberRegist(String userid, String userpw, String username, MultipartFile userphoto) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userphoto = userphoto;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MultipartFile getUserphoto() {
		return userphoto;
	}

	public void setUserphoto(MultipartFile userphoto) {
		this.userphoto = userphoto;
	}
	
	
	public Member toMember() {
		
		//multipart 형식으로 받은 사진 파일은 나중에 service 단에서 setter 통해서 정의할 것이기 때문에 
		//우선 regform으로부터 받은 세 개의 매개변수만 setter 매서드 통해서 객체에 넣어준다. 
		Member member = new Member();
		
		member.setUserid(userid);
		member.setUserpw(userpw);
		member.setUsername(username);
		
		return member;
	}

	@Override
	public String toString() {
		return "MemberRegist [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userphoto="
				+ userphoto.getOriginalFilename() + "]";
	}
	
	
	
	
	
	

}
