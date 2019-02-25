package com.revature.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.FlashCardDAO;
import com.revature.bean.Categories;
import com.revature.bean.FlashCard;
import com.revature.util.ConnFactory;

public class FlashCardDAOImpl implements FlashCardDAO{

	// Connection to database
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createFlashCard(FlashCard flashCard) throws SQLException {
		// Create New Flash Card
		Connection conn = cf.getConnection();
		String sql = " { call INSERTFLASHCARD(?, ?, ?)";
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setString(1, flashCard.getQuestion());
		ps.setString(2, flashCard.getAnswer());
		ps.setInt(3, flashCard.getCategoryId());
		ps.executeQuery();
	}

	@Override
	public List<FlashCard> getAllFlashCards() throws SQLException {
		// 
		List<FlashCard> allFlashCards = new ArrayList<>();
		Connection conn = cf.getConnection();
		FlashCard flashCards = null;
		String sql = "SELECT * FROM categories";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			flashCards = new FlashCard(rs.getInt("flashcard_id"), rs.getString("question"), rs.getString("answer"),
					rs.getInt("category_id"));
			allFlashCards.add(flashCards);
		}
		
		return allFlashCards;
	}

	@Override
	public void viewFlashCard(FlashCard flashCard, Categories category) throws SQLException {
		// 
		Connection conn = cf.getConnection();
	}

	@Override
	public void updateFlashCard(FlashCard flashCard, Categories category) throws SQLException {
		// 
		Connection conn = cf.getConnection();
	}

	@Override
	public void deleteFlashCard(int flashCardId) throws SQLException {
		// 
		Connection conn = cf.getConnection();
	}

}
