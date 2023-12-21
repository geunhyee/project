package com.carina.cbs.board.freeboard.vo;


/**
 * Class Name  : FreeBoardVO
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 29.
 * Version: 1.0
 * Purpose:   자유게시판
 * Description: 자유게시판 vo
 */
public class FreeBoardVO {
	private int boardNo;                    
	private String boardTitle;                     
	private String boardContent;             
	private String memId;
	private String createDate;
	private String updateDate;
	private int boardHit;                              
	private String boardDelYn;
	
	public FreeBoardVO(int boardNo, String boardTitle, String boardContent, String memId, String createDate,
			String updateDate, int boardHit, String boardDelYn) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memId = memId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.boardHit = boardHit;
		this.boardDelYn = boardDelYn;
		
	}

	public FreeBoardVO() {
		super();
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public String getBoardDelYn() {
		return boardDelYn;
	}

	public void setBoardDelYn(String boardDelYn) {
		this.boardDelYn = boardDelYn;
	}

	@Override
	public String toString() {
		return "FreeBoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", memId=" + memId + ", createDate=" + createDate + ", updateDate=" + updateDate + ", boardHit="
				+ boardHit + ", boardDelYn=" + boardDelYn + "]";
	}              
	
	
	

	

	

}
