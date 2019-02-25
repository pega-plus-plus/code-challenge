package com.revature.model;

public class Notecards {
	
	private String question;
	private String answer;
	private String category;
	
	public Notecards() {
	}

	public Notecards(String question, String answer, String category) {
		super();
		this.question = question;
		this.answer = answer;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Notecards [question=" + question + ", answer=" + answer + ", category=" + category + "]";
	}
	
	
}
