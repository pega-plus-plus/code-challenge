package flashcard.beans;

public class Flashcard {
	private int flashcardId;
	private String question;
	private String answer;
	private int categoryId;
	private String categoryName;
	/**
	 * @param flashcardId
	 * @param question
	 * @param answer
	 * @param categoryId
	 * @param categoryName
	 */
	public Flashcard(int flashcardId, String question, String answer, int categoryId, String categoryName) {
		this.flashcardId = flashcardId;
		this.question = question;
		this.answer = answer;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	/**
	 * 
	 */
	public Flashcard() {
	}
	/**
	 * @return the flashcardId
	 */
	public int getFlashcardId() {
		return flashcardId;
	}
	/**
	 * @param flashcardId the flashcardId to set
	 */
	public void setFlashcardId(int flashcardId) {
		this.flashcardId = flashcardId;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flashcard [flashcardId=" + flashcardId + ", question=" + question + ", answer=" + answer
				+ ", categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	

}
