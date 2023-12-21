package com.carina.cbs.board.freeboard.vo;

/**
 * Class Name  : ReplyVO
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 23.
 * Version: 1.0
 * Purpose:   자유게시판 댓글
 * Description: vo
 */
public class ReplyVO {
	private String replyNo;
	private String boardNo;
	private String memId;
	private String replyContent;
	private String replyDate;
	private String delYn;
	
	
	public ReplyVO(String replyNo, String boardNo, String memId, String replyContent, String replyDate, String delYn) {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.memId = memId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.delYn = delYn;
	}


	public ReplyVO() {
		super();
	}


	public String getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}


	public String getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public String getReplyDate() {
		return replyDate;
	}


	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}


	public String getDelYn() {
		return delYn;
	}


	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}


	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", boardNo=" + boardNo + ", memId=" + memId + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + ", delYn=" + delYn + "]";
	}
	
	
	
	
}
