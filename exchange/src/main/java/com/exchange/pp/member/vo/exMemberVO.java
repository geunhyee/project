package com.exchange.pp.member.vo;

public class exMemberVO {
	private String memId;
	private String memPw;
	private String memNm;
	private String memEmail;
	private String profileImg;
	
	public exMemberVO() {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memNm = memNm;
	}

	public exMemberVO(String memId, String memPw, String memNm, String memEmail) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memNm = memNm;
		this.memEmail = memEmail;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	@Override
	public String toString() {
		return "exMemberVO [memId=" + memId + ", memPw=" + memPw + ", memNm=" + memNm + ", memEmail=" + memEmail + "]";
	}

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
