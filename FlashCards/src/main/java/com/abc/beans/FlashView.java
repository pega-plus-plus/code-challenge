package com.abc.beans;

public class FlashView {
	private Integer flashId;
	private String question;
	private String answer;
	private String categoryId;
	
	public FlashView() {
		super();
	}

	public Integer getFlashId() {
		return flashId;
	}

	public void setFlashId(Integer flashId) {
		this.flashId = flashId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
