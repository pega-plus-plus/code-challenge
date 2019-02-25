package com.revature.bean;

public class FlashCard {
	
	private int flashCardId;
	private String question;
	private String answer;
	private int categoryId;
	
	
	
	public FlashCard(int flashCardId, String question, String answer, int categoryId) {
		super();
		this.flashCardId = flashCardId;
		this.question = question;
		this.answer = answer;
		this.categoryId = categoryId;
	}

	public FlashCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFlashCardId() {
		return flashCardId;
	}

	public void setFlashCardId(int flashCardId) {
		this.flashCardId = flashCardId;
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

	@Override
	public String toString() {
		return "FlashCard [flashCardId=" + flashCardId + ", question=" + question + ", answer=" + answer
				+ ", categoryId=" + categoryId + "]";
	}

}
