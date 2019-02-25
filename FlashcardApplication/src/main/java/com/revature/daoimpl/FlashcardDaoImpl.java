package com.revature.daoimpl;

import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
public class FlashcardDaoImpl implements FlashcardDAO {

	public void createFlashcard(Flashcard card) {
		
	}
	public Flashcard getFlashcard(int id) {
		return null;
		
	}
	
	
	public List<Flashcard> getAllFlashcards(){
		return null;
		
	}
	public void updateFlashcard(int cardId, String update) {
		
	}
	public void deleteFlashcard(int cardId) {
		
	}
}
