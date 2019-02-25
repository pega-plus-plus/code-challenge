package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Flashcard;

public interface FlashcardDAO {

	public Flashcard getFlashcard(int id) throws SQLException;
	public void createFlashcard(Flashcard card) throws SQLException;
	public List<Flashcard> getAllFlashcards() throws SQLException;
	public void updateFlashcard(int cardId, String update) throws SQLException;
	public void deleteFlashcard(int cardId) throws SQLException;
}