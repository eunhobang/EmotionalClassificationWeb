package com.magic.diary.domain;

public class Member {
	private String memId;
	private String memPw;
	private String memName;
	private String memAnniversary;
	private String memDate;

	public Member() {
		
	}
	
	public Member(String memId, String memName) {
		this.memId = memId;
		this.memName = memName;
	}
	
	public Member(String memId, String memName, String memAnniverary, String memDate) {
		this.memId = memId;
		this.memName = memName;
		this.memAnniversary = memAnniverary;
		this.memDate = memDate;
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
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemAnniversary() {
		return memAnniversary;
	}
	public void setMemAnniversary(String memAnniversary) {
		this.memAnniversary = memAnniversary;
	}
	public String getMemDate() {
		return memDate;
	}
	public void setMemDate(String memDate) {
		this.memDate = memDate;
	}
	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memAnniverary="
				+ memAnniversary + ", memDate=" + memDate + "]";
	}
	
	
}
