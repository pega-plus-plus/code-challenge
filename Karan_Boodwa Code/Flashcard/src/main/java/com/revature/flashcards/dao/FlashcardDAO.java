package com.revature.flashcards.dao;

import java.util.ArrayList;

import com.revature.flashcards.models.Flashcard;

public interface FlashcardDAO {
	// CRUD operations
	
	// Create
	public boolean insertFlashCard(Flashcard fc);
	
	// Read
	ArrayList<Flashcard> getAllFlashCards();
	
	// Update
	
	// Delete
}
