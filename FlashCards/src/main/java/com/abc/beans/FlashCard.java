package com.abc.beans;

public class FlashCard {
	
	private Integer flashId;
	private String question;
	private String answer;
	private Integer categoryId;
	
		
	public FlashCard(int flashId, String question, String answer, int categoryId) {
		super();
		this.flashId = flashId;
		this.question = question;
		this.answer = answer;
		this.categoryId = categoryId;
	}


	public int getId() {
		return flashId;
	}
	
	public void setId(int flashId) {
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
