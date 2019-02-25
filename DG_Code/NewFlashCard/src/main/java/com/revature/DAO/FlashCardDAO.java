package com.revature.DAO;

import java.sql.SQLException;
import java.util.List;

import com.revature.bean.Categories;
import com.revature.bean.FlashCard;

public interface FlashCardDAO {

	// CREATE
	public abstract void createFlashCard(FlashCard flashCard) throws SQLException;
	
	// READ
	public abstract List<FlashCard> getAllFlashCards() throws SQLException;
	public abstract void viewFlashCard(FlashCard flashCard, Categories category) throws SQLException;
	
	// UPDATE
	public abstract void updateFlashCard(FlashCard flashCard, Categories category) throws SQLException;

	// DELETE
	public abstract void deleteFlashCard(int flashCardId) throws SQLException;

}
