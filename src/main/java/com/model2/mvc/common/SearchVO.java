package com.model2.mvc.common;


public class SearchVO {
	
	private int page; //현재 페이지
	String searchCondition;
	String searchKeyword; //상품을 찾기 위한 
	int pageUnit; //
	
	public SearchVO(){
	}
	
	public int getPageUnit() { 
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}