package com.storyafrica.sa.member.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private int idx;
	private String userid;
	private String userpw;
	private String username;
	private String userphoto;
	private Date regdate;
	
	//default
	public Member() {}
	
	//생성자1
	public Member(String userid, String userpw, String username, String userphoto) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userphoto = userphoto;
	}
	
	//생성자2
	public Member(int idx, String userid, String userpw, String username, String userphoto, Date regdate) {
		super();
		this.idx = idx;
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userphoto = userphoto;
		this.regdate = regdate;
	}


	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getUserphoto() {
		return userphoto;
	}

	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}	

	
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", userphoto=" + userphoto + ", regdate=" + regdate + "]";
	}
	
	public LoginInfo toLoginInfo() {
		return new LoginInfo(userid, username, userphoto, regdate); 
	}
	
	//비밀번호 검사 
	public boolean pwChk(String pw) {
		//DB에서 받아온 데이터, 사용자 입력값 검사 
		//1. DB에서 객체에 저장이 잘 안되었느지
		//2. DB에 저장된 값에는 공백 문자열이 없는지
		//3. DB에 저장된 값과 사용자의 입력값이 일치하는지 검사 필요 
		return userpw !=null && userpw.trim().length()>0 && userpw.equals(pw);
	}
	
}
