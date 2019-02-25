package com.revature.beans;

public class Flashcard {

	private int id;
	private String question;
	private String answer;
	private String category;
	
	public Flashcard() {
		super();
	}
	
	/*building from program, db will set ID after*/
	public Flashcard( String q, String a, String cat) {
		this.question = q;
		this.answer = a;
		this.category = cat;
	}
	
	/*building from DB, id will be read in*/
	public Flashcard( int id, String q, String a, String cat) {
		this.id = id;
		this.question = q;
		this.answer = a;
		this.category = cat;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String string) {
		this.category = string;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", category=" + category + "]";
	}
	
}
