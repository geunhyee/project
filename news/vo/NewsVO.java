
package com.carina.cbs.board.news.vo;

/**
 * Class Name  : NewsVO
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 23.
 * Version: 1.0
 * Purpose:   환경뉴스
 * Description:  환경뉴스VO
 */
public class NewsVO {
	private String title;
	private String link;
	private String originallink;
	private String pubDate;
	private String description;
	
	
	
	public NewsVO() {
		super();
	}



	public NewsVO(String title, String link, String originallink, String pubDate, String description) {
		super();
		this.title = title;
		this.link = link;
		this.originallink = originallink;
		this.pubDate = pubDate;
		this.description = description;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getOriginallink() {
		return originallink;
	}



	public void setOriginallink(String originallink) {
		this.originallink = originallink;
	}



	public String getPubDate() {
		return pubDate;
	}



	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "NewsVO [title=" + title + ", link=" + link + ", originallink=" + originallink + ", pubDate=" + pubDate
				+ ", description=" + description + "]";
	}
	
	
	

}
