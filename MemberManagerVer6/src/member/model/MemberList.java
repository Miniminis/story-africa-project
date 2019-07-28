package member.model;

import java.util.List;

public class MemberList {
	
	private int articleTotalCnt; //총 게시글 수 
	private int curPageNum; //현재 페이지 번호 
	private int pageTotalCnt; //전체 페이지 개수 
	private int startRow; //리스트 시작줄 
	private List<Member> memberList; //리스트 타입의 객체 
	private int ARTICLE_COUNT_PER_PAGE; //한페이지 당 게시글의 수 FINAL
	
	public MemberList () {}	
	
	public MemberList(int articleTotalCnt, int curPageNum, int startRow,
			List<Member> memberList, int ARTICLE_COUNT_PER_PAGE) {
		this.articleTotalCnt = articleTotalCnt;
		this.curPageNum = curPageNum;
		this.startRow = startRow;
		this.memberList = memberList;
		this.ARTICLE_COUNT_PER_PAGE = ARTICLE_COUNT_PER_PAGE;
		calculatePageTotalCnt();
	}
	
	//전체 페이지 번호 매서드 
	private void calculatePageTotalCnt() {
		
		//	7/3 = 2 + (7%3 >0 이면 1);
		if(articleTotalCnt==0) { //만약 게시글이 0개라면 
			pageTotalCnt=0;		//전체 페이지 번호도 0번
		} else {				//게시글이 1개 이상이면 
			pageTotalCnt = articleTotalCnt / ARTICLE_COUNT_PER_PAGE; //전체 게시글의 수 / 페이지 당 게시글의 수 = 전체 페이지 번호
			
			if(articleTotalCnt % ARTICLE_COUNT_PER_PAGE >0) {			//만약 위의 연산 결과 나머지가 있다면 
				pageTotalCnt = pageTotalCnt + 1;					//전체 페이지 번호 + 1
			}
		}	
	}

	public int getArticleTotalCnt() {
		return articleTotalCnt;
	}

	public int getCurPageNum() {
		return curPageNum;
	}

	public int getPageTotalCnt() {
		return pageTotalCnt;
	}

	public int getStartRow() {
		return startRow;
	}


	public List<Member> getMemberList() {
		return memberList;
	}
	
	public int getARTICLE_COUNT_PER_PAGE() {
		return ARTICLE_COUNT_PER_PAGE;
	}


	//메시지 리스트가 0일때 전체 메시지 개수 
	public boolean isEmpty() {
		return pageTotalCnt ==0; 
	}
	

}
