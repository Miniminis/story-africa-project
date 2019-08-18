package com.storyafrica.sa.member.domain;

import org.springframework.web.multipart.MultipartFile;

//수정된 회원 페이지
public class EditedMember {
	
	private int idx;
	private String userid;
	private String userpw;
	private String username;
	private MultipartFile userphoto;
	private String oldPhoto;
	
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
	public MultipartFile getUserphoto() {
		return userphoto;
	}
	public void setUserphoto(MultipartFile userphoto) {
		this.userphoto = userphoto;
	}
	public String getOldPhoto() {
		return oldPhoto;
	}
	public void setOldPhoto(String oldPhoto) {
		this.oldPhoto = oldPhoto;
	}
	
	public Member toMember() {
		Member member = new Member();
		
		member.setIdx(idx);
		member.setUserid(userid);
		member.setUserpw(userpw);
		member.setUsername(username);
		
		return member;
	}
	
	
	
	@Override
	public String toString() {
		return "EditedMember [idx=" + idx + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", userphoto=" + userphoto + ", oldPhoto=" + oldPhoto + "]";
	}
	
	
	

}
