package com.carina.cbs.board.freeboard.vo;

import com.carina.cbs.common.vo.PagingVO;

public class SearchVO extends PagingVO{
	
	private String keyword;
	private String searchOption;
	
	
	
	public SearchVO() {
		super();
	}



	public SearchVO(String keyword, String searchOption) {
		super();
		this.keyword = keyword;
		this.searchOption = searchOption;
	}



	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	public String getSearchOption() {
		return searchOption;
	}



	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}



	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", searchOption=" + searchOption + "]";
	}
	
	
	

}
