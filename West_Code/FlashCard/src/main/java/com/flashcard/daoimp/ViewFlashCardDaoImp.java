package com.flashcard.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flashcard.bean.FlashCard;
import com.flashcard.dao.ViewFlashCardDao;
import com.flashcard.utilities.ConnFactory;

public class ViewFlashCardDaoImp implements ViewFlashCardDao {
	public static ConnFactory conF = ConnFactory.getInstance();

	@Override
	public List<FlashCard> viewFlashCards() {
		List<FlashCard> flashCards = new ArrayList<FlashCard>();
		try (Connection conn = conF.getConnection()) {
			String sql = "SELECT * FROM FlashCard";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			FlashCard flash = null;
			while (rs.next()) {
				flash = new FlashCard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				flashCards.add(flash);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flashCards;

	}

	@Override
	public List<FlashCard> viewCategory(String category) {
		List<FlashCard> flashCards = new ArrayList<FlashCard>();
		try (Connection conn = conF.getConnection()){
			String sql = "SELECT * FROM FlashCard WHERE category2 = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			FlashCard flash = null;
			while (rs.next()) {
				flash = new FlashCard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				flashCards.add(flash);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return flashCards;
		

	}

}
