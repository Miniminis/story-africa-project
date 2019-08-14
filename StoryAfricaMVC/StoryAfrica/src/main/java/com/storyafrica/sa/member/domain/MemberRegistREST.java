package com.storyafrica.sa.member.domain;


//JSON 타입 --> 객체로 바로 매핑 해주는 DTO 
public class MemberRegistREST {
	
	private String userid;
	private String userpw;
	private String username;
	
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
	
	@Override
	public String toString() {
		return "MemberRegistREST [userid=" + userid + ", userpw=" + userpw + ", username=" + username + "]";
	}
	
	public Member toMember() {
		Member member = new Member();
		
		member.setUserid(userid);
		member.setUserpw(userpw);
		member.setUsername(username);
		
		return member;
	}

}
