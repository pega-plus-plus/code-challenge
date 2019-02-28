package com.revature.daoimpl;

import java.util.List;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.util.ConnFactory;

public class FlashcardDaoImpl implements FlashcardDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	/* Create card and insert into DB */
	public void create(Flashcard card) throws SQLException {
		System.out.println(card);
		System.out.println(new File(".").getAbsolutePath());
		Connection conn = cf.getConnection();
		String query = "call PR_INSERT_FLASHCARD(?, ?,?)";
		CallableStatement caller = conn.prepareCall(query);
		caller.setString(1, card.getQuestion());
		caller.setString(2, card.getAnswer());
		caller.setInt(3, card.getCategory());
		caller.execute();
		caller.close();
		conn.close();
	}

	/* Read in single card */
	public Flashcard read(int id) throws SQLException {
		Connection conn = cf.getConnection();
		ResultSet rs;
		Flashcard card = null;

		String query = "SELECT A.card_id, A.question, A.answer, A.cat, B.cat_name" + "FROM Flashcards A"
				+ "JOIN Categories B ON A.cat = B.cat_id" + "WHERE A.card_id = ?";

		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
			card = new Flashcard();
			card.setId(rs.getInt("id"));
			card.setQuestion(rs.getString("question"));
			card.setAnswer(rs.getString("answer"));
			card.setCategory(rs.getInt("cat"));
		}
		rs.close();
		ps.close();
		conn.close();
		return card;
	}

	/* Read in all cards */
	public List<Flashcard> read() throws SQLException {
		List<Flashcard> cardList = new ArrayList<Flashcard>();
		Connection conn = cf.getConnection();
		String query = "SELECT * FROM FLASHCARDS A JOIN Categories B ON A.cat =B.cat_id";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Flashcard card = new Flashcard();
			card.setId(rs.getInt("card_id"));
			card.setQuestion(rs.getString("question"));
			card.setAnswer(rs.getString("answer"));
			card.setCategory(rs.getInt("cat"));
			card.setCatName(rs.getString("cat_name"));
			cardList.add(card);
		}
		
			rs.close();
			ps.close();
			conn.close();
			return cardList;
	}

	/* Read in list of cards by category */
	public List<Flashcard> readByCat(int cat) {
		return null;
	}

	/* Update a particular card */
	public void update(int cardId, String update) {

	}

	/* Delete a card */
	public void delete(int cardId) throws SQLException {
		System.out.println("DAOIMPL DELETE METHOD");
		Connection conn = cf.getConnection();
		String query = "DELETE FROM flashcards WHERE card_id = ?";
		CallableStatement caller = conn.prepareCall(query);
		caller.setInt(1, cardId);
		caller.execute();
		caller.close();
		conn.close();
	}
}
