package com.revature.dao;

import java.util.List;

import com.revature.beans.Flashcard;

public interface FlashcardDao {
	public List<Flashcard> viewAllFlashcards();
	public List<Flashcard> viewAllFlashcardsByCat(Integer category);
	public Boolean createNewFlashcard(Flashcard fc);
	public Boolean updateFlashcard(Flashcard fc);
	public Boolean deleteFlashcard(Integer id);
}
