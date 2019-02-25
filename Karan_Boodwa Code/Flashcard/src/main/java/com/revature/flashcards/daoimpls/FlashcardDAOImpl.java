package com.revature.flashcards.daoimpls;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.flashcards.dao.FlashcardDAO;
import com.revature.flashcards.models.Category;
import com.revature.flashcards.models.Flashcard;
import com.revature.flashcards.util.ConnFactory;

public class FlashcardDAOImpl implements FlashcardDAO{
	
	private static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public ArrayList<Flashcard> getAllFlashCards() {
		
		try (Connection conn = cf.getConnection();) {
			String sql = "SELECT * FROM flashcard";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Flashcard> flashcard_list = new ArrayList<>();
			while(rs.next()) {
				Flashcard flashcard = new Flashcard();
				flashcard.setId(rs.getInt("id"));
				flashcard.setQuestion(rs.getString("question"));
				flashcard.setAnswer(rs.getString("answer"));
				flashcard.setCategory(rs.getInt("category"));
				flashcard_list.add(flashcard);			
			}
			
			return flashcard_list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean insertFlashCard(Flashcard fc) {
		
		try(Connection conn = cf.getConnection();){
			String sql = "INSERT INTO flashcard VALUES(null, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fc.getQuestion());
			ps.setString(2, fc.getAnswer());
			ps.setInt(3, fc.getCategory());
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
