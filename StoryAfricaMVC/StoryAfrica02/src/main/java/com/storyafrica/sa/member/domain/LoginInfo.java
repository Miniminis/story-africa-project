package com.storyafrica.sa.member.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class LoginInfo {
	
	private String userid;
	private String username;
	private String userphoto;
	private Date regdate;
	
	public LoginInfo () {}

	public LoginInfo(String userid, String username, String userphoto, Date regdate) {
		super();
		this.userid = userid;
		this.username = username;
		this.userphoto = userphoto;
		this.regdate = regdate;
	}

	public String getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public String getUserphoto() {
		return userphoto;
	}

	public Date getRegdate() {
		return regdate;
	}

	@Override
	public String toString() {
		return "LoginInfo [userid=" + userid + ", username=" + username + ", userphoto=" + userphoto + ", regdate="
				+ regdate + "]";
	}

		
}
