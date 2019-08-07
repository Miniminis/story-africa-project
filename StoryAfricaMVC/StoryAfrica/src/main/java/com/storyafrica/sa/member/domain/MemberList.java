package com.storyafrica.sa.member.domain;

import java.util.List;

public class MemberList {
	
	/* 리스트 출력 페이지에 필요한 데이터 
	 * 1. 멤버 타입의 리스트 
	 * 2. 한 페이지 당 출력 개수 
	 * 3. 전체 페이지 번호 
	 * 4. 현재 페이지 번호 
	 * 5. 전체 회원 개수 
	 * 6. 리스트의 시작 row 
	 * */
	private List<Member> memberList; //리스트 타입의 객체 
	private int memberNumPerPage; //한 페이지 당 출력개수 
	private int totalPageNum; //전체 페이지 수 
	private int curPageNum; //현제 페이지 수 
	private int totalMemNum; //전체 회원 수 
	private int startRow;  //한 리스트의 시작 점 
	
	public MemberList () {}


	public MemberList(List<Member> memberList, int memberNumPerPage, int totalPageNum, int curPageNum, int totalMemNum,
			int startRow) {
		super();
		this.memberList = memberList;
		this.memberNumPerPage = memberNumPerPage;
		this.totalPageNum = totalPageNum;
		this.curPageNum = curPageNum;
		this.totalMemNum = totalMemNum;
		this.startRow = startRow;
	}



	public List<Member> getMemberList() {
		return memberList;
	}



	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}



	public int getMemberNumPerPage() {
		return memberNumPerPage;
	}



	public void setMemberNumPerPage(int memberNumPerPage) {
		this.memberNumPerPage = memberNumPerPage;
	}



	public int getTotalPageNum() {
		return totalPageNum;
	}



	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}



	public int getCurPageNum() {
		return curPageNum;
	}



	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum;
	}



	public int getTotalMemNum() {
		return totalMemNum;
	}



	public void setTotalMemNum(int totalMemNum) {
		this.totalMemNum = totalMemNum;
	}



	public int getStartRow() {
		return startRow;
	}



	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	@Override
	public String toString() {
		return "MemberList [memberList=" + memberList + ", memberNumPerPage=" + memberNumPerPage + ", totalPageNum="
				+ totalPageNum + ", curPageNum=" + curPageNum + ", totalMemNum=" + totalMemNum + ", startRow="
				+ startRow + "]";
	}
	
	

	

}
