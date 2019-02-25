package com.revature.beans;

public class Flashcard {
	private int f_id;
	private String question;
	private String answer;
	private int cate;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
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
	public int getCate() {
		return cate;
	}
	public void setCate(int cate) {
		this.cate = cate;
	}
	@Override
	public String toString() {
		return "Flashcard [f_id=" + f_id + ", question=" + question + ", answer=" + answer + ", cate=" + cate + "]";
	}
	public Flashcard() {
		super();
	}
	public Flashcard(int f_id, String question, String answer, int cate) {
		super();
		this.f_id = f_id;
		this.question = question;
		this.answer = answer;
		this.cate = cate;
	}
	public Flashcard(String question, String answer, int cate) {
		super();
		this.question = question;
		this.answer = answer;
		this.cate = cate;
	}

	
}
