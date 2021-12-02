package com.magic.diary.domain;

public class Diary {
	private int diaryId;
	private String diaryDate;
	private String diaryQuestions;
	private String diaryAnswers;
	private String diaryContents;
	private String diaryLabels;
	private String diaryImage;
	private String diaryEmotions;
	private String memId;
	
	
	
	public Diary() {
	}
	
		
	public Diary(int diaryId, String diaryDate, String diaryQuestions, String diaryLabels, String diaryImage,
			String diaryEmotions, String memId) {
		this.diaryId = diaryId;
		this.diaryDate = diaryDate;
		this.diaryQuestions = diaryQuestions;
		this.diaryLabels = diaryLabels;
		this.diaryImage = diaryImage;
		this.diaryEmotions = diaryEmotions;
		this.memId = memId;
	}



	public int getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}
	public String getDiaryDate() {
		return diaryDate;
	}
	public void setDiaryDate(String diaryDate) {
		this.diaryDate = diaryDate;
	}
	public String getDiaryQuestions() {
		return diaryQuestions;
	}
	public void setDiaryQuestions(String diaryQuestions) {
		this.diaryQuestions = diaryQuestions;
	}
	public String getDiaryAnswers() {
		return diaryAnswers;
	}
	public void setDiaryAnswers(String diaryAnswers) {
		this.diaryAnswers = diaryAnswers;
	}
	public String getDiaryContents() {
		return diaryContents;
	}
	public void setDiaryContents(String diaryContents) {
		this.diaryContents = diaryContents;
	}
	public String getDiaryLabels() {
		return diaryLabels;
	}
	public void setDiaryLabels(String diaryLabels) {
		this.diaryLabels = diaryLabels;
	}
	public String getDiaryImage() {
		return diaryImage;
	}
	public void setDiaryImage(String diaryImage) {
		this.diaryImage = diaryImage;
	}
	public String getDiaryEmotions() {
		return diaryEmotions;
	}
	public void setDiaryEmotions(String diaryEmotions) {
		this.diaryEmotions = diaryEmotions;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}


	@Override
	public String toString() {
		return "Diary [diaryId=" + diaryId + ", diaryDate=" + diaryDate + ", diaryQuestions=" + diaryQuestions
				+ ", diaryAnswers=" + diaryAnswers + ", diaryContents=" + diaryContents + ", diaryLabels=" + diaryLabels
				+ ", diaryImage=" + diaryImage + ", diaryEmotions=" + diaryEmotions + ", memId=" + memId + "]";
	}
	
	
	
}
