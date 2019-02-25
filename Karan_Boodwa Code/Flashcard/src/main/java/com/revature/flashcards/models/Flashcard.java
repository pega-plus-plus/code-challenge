package com.revature.flashcards.models;

public class Flashcard {
	int id;
	String question;
	String answer;
	int category;
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + category;
		result = prime * result + id;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flashcard other = (Flashcard) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (category != other.category)
			return false;
		if (id != other.id)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", Answer=" + answer + ", category=" + category + "]";
	}
	public Flashcard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flashcard(int id, String question, String answer, int category) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.category = category;
	}
	public Flashcard(String question, String answer, int category) {
		super();
		this.question = question;
		this.answer = answer;
		this.category = category;
	}

	
	
}
