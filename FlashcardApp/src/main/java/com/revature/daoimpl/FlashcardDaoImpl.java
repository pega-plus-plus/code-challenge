package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.statement;
import com.revature.util.ConnFactory;

public class FlashcardDaoImpl implements FlashcardDao {

	public void createFlashcard(Flashcard card) throws SQLException {
		Connection conn = ConnFactory.getInstance();
		CallableStatement caller = conn.prepareCall("call CREATE_FLASHCARD(?,?,?)");
		caller.setString(1, card.getCategory());
		caller.setString(2, card.getQuestion());
		caller.setString(3, card.getAnswer());
		caller.execute();
		caller.close();
		conn.close();
	}

	public Flashcard getFlashcard(int id) throws SQLException {
		Connection conn = ConnFactory.getInstance();
		Flashcard card = null;
		
		String query = "SELECT * FROM FLASHCARDS WHERE cardID = (?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, Integer.toString(id));
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			card = new Flashcard(rs.getInt("cardID"),rs.getString("cardCategory"), 
					rs.getString("cardQuestion"),rs.getString("getAnswer"));
		}	
		return card;
	}

	public List<Flashcard> getAllFlashcards() throws SQLException {
		Connection conn = ConnFactory.getInstance();
		Flashcard card = null;
		List<Flashcard> flashcards = new ArrayList<Flashcard>();
		String query = "SELECT * FROM FLASHCARDS";
		PreparedStatement ps = conn.prepareStatement(query);
		//ps.setString(1, Integer.toString(id));
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			card = new Flashcard(rs.getInt("cardID"),rs.getString("cardCategory"), 
					rs.getString("cardQuestion"),rs.getString("getAnswer"));
			flashcards.add(card);
		}	
		return flashcards;
	}

	public void updateFlashcard(Flashcard card) throws SQLException {
		
	}

}
