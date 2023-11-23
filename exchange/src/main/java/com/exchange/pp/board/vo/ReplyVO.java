package com.exchange.pp.board.vo;

public class ReplyVO {
	  private String replyNo;
	  private String boardNo;
	  private String memId;
	  private String memNm;
	  private String replyContent;
	  private String replyDate ;
	  private String delYn;
	  
	  
	  
	public ReplyVO() {
		super();
	}



	public ReplyVO(String replyNo, String boardNo, String memId, String memNm, String replyContent, String replyDate,
			String delYn) {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.memId = memId;
		this.memNm = memNm;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.delYn = delYn;
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



	public String getMemNm() {
		return memNm;
	}



	public void setMemNm(String memNm) {
		this.memNm = memNm;
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
		return "ReplyVO [replyNo=" + replyNo + ", boardNo=" + boardNo + ", memId=" + memId + ", memNm=" + memNm
				+ ", replyContent=" + replyContent + ", replyDate=" + replyDate + ", delYn=" + delYn + "]";
	}

	
	  
	  
}
	  
	