package com.carina.cbs.board.actboard.vo;

public class ActBoardVO {
	private int boardNo;
	private String category;
	private String boardTitle;
	private String boardContent;
	private String memId;
	private String createDate;
	private String updateDate;
	private String actImg;
	private int actHit;
	private int actGood;
	private int actTogether;
	private int actUsefull;
	private String delYn;
	
	public ActBoardVO(int boardNo, String category, String boardTitle, String boardContent, String memId,
			String createDate, String updateDate, String actImg, int actHit, int actGood, int actTogether,
			int actUsefull, String delYn) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memId = memId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.actImg = actImg;
		this.actHit = actHit;
		this.actGood = actGood;
		this.actTogether = actTogether;
		this.actUsefull = actUsefull;
		this.delYn = delYn;
	}

	public ActBoardVO() {
		super();
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getActImg() {
		return actImg;
	}

	public void setActImg(String actImg) {
		this.actImg = actImg;
	}

	public int getActHit() {
		return actHit;
	}

	public void setActHit(int actHit) {
		this.actHit = actHit;
	}

	public int getActGood() {
		return actGood;
	}

	public void setActGood(int actGood) {
		this.actGood = actGood;
	}

	public int getActTogether() {
		return actTogether;
	}

	public void setActTogether(int actTogether) {
		this.actTogether = actTogether;
	}

	public int getActUsefull() {
		return actUsefull;
	}

	public void setActUsefull(int actUsefull) {
		this.actUsefull = actUsefull;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "ActBoardVO [boardNo=" + boardNo + ", category=" + category + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", memId=" + memId + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", actImg=" + actImg + ", actHit=" + actHit + ", actGood=" + actGood + ", actTogether="
				+ actTogether + ", actUsefull=" + actUsefull + ", delYn=" + delYn + "]";
	}
	

	
	
}
