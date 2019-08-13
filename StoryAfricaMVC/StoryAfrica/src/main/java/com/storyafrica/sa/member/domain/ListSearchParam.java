package com.storyafrica.sa.member.domain;


public class ListSearchParam {
	
	private String searchType;
	private String keyword;
	private String searchPeriod;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchPeriod() {
		return searchPeriod;
	}
	public void setSearchPeriod(String searchPeriod) {
		this.searchPeriod = searchPeriod;
	}
	
	@Override
	public String toString() {
		return "ListSearchParam [searchType=" + searchType + ", keyword=" + keyword + ", searchPeriod=" + searchPeriod
				+ "]";
	}
	
}
