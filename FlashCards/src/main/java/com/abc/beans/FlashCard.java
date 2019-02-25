package com.abc.beans;

public class FlashCard {
	
	private Integer id;
	private String question;
	private String answer;
	private Integer categoryId;
	
		
	public FlashCard(int id, String question, String answer, int categoryId) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.categoryId = categoryId;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
