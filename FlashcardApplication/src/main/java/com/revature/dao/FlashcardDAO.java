package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Flashcard;

public interface FlashcardDAO {

	public void create(Flashcard card) throws SQLException;
	public Flashcard read(int id) throws SQLException;
	public List<Flashcard> read() throws SQLException;
	public List<Flashcard> readByCat(int cat) throws SQLException;
	public void update(int cardId, String update) throws SQLException;
	public void delete(int cardId) throws SQLException;
}