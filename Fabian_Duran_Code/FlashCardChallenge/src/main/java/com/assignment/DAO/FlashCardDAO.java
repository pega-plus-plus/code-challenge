package com.assignment.DAO;

import java.sql.SQLException;
import java.util.List;

import com.assignment.bean.FlashCard;

public interface FlashCardDAO {
	//CRUD
	public abstract void createFlashCard(String question, String answer, String category)throws SQLException;
	public abstract FlashCard readFlashCard (int fc_id)throws SQLException;
	public abstract void updateFlashCard (FlashCard alpha)throws SQLException;
	public abstract void deleteFlashCard (int fc_id)throws SQLException;
	public abstract List<FlashCard> getFlashCardList (String category)throws SQLException;
}
