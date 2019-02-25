package flashcard.dao;

import java.util.List;

import flashcard.beans.Flashcard;

public interface FlashcardDao {
	
	public boolean addFlashCard(Flashcard fc);
	public boolean updateFlashcard(Flashcard fc);
	public boolean deleteFlashcard(int fcId);
	public List<Flashcard> getAllFlashcards();
	public List<Flashcard> getFlashcardsByCategory(int categoryId);

}
