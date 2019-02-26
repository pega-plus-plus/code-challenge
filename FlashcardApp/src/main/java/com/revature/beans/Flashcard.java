package com.revature.beans;

public class Flashcard {
	
	private int id;
	private String category;
	private String question;
	private String answer;
	
	// CONSTRUCTORS
	public Flashcard() {
		super();
	}
	
	public Flashcard(int id, String ctgry, String qstn, String ansr) {
		this.id = id;
		this.category = ctgry;
		this.question  = qstn;
		this.answer = ansr;
	}
	
	
	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
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

	// TO STRING
	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", category=" + category + ", question=" + question + ", answer=" + answer + "]";
	}
	
}
