package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.beans.Flashcard;

public interface FlashcardDao {

	//CRUD
	public void createFlashcard(Flashcard card) throws SQLException;
	public Flashcard getFlashcard(int id) throws SQLException;
	public List<Flashcard> getAllFlashcards() throws SQLException;
	public void updateFlashcard(Flashcard card) throws SQLException;
}
