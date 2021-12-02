package com.magic.diary.domain;

public class Calendar {
	private int calId;
	private String calDate;
	private String calEvent;
	private String calComment;
	private String memId;

	public Calendar(int calId, String calDate, String calEvent, String calComment, String memId) {
		this.calId = calId;
		this.calDate = calDate;
		this.calEvent = calEvent;
		this.calComment = calComment;
		this.memId = memId;
	}

	
	
//	public Calendar(int calId, String calEvent, String calComment) {
//		this.calId = calId;
//		this.calEvent = calEvent;
//		this.calComment = calComment;
//	}



	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public Calendar() {
	}

	public int getCalId() {
		return calId;
	}

	public void setCalId(int calId) {
		this.calId = calId;
	}

	public String getCalDate() {
		return calDate;
	}

	public void setCalDate(String calDate) {
		this.calDate = calDate;
	}

	public String getCalEvent() {
		return calEvent;
	}

	public void setCalEvent(String calEvent) {
		this.calEvent = calEvent;
	}

	public String getCalComment() {
		return calComment;
	}

	public void setCalComment(String calComment) {
		this.calComment = calComment;
	}

	
	
	
	
}
