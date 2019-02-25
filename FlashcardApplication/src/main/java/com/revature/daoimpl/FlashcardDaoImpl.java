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

import com.revature.beans.CheckingAccount;
import com.revature.beans.Flashcard;
import com.revature.beans.SavingsAccount;
import com.revature.dao.FlashcardDAO;
import com.revature.util.ConnFactory;

public class FlashcardDaoImpl implements FlashcardDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	public void create(Flashcard card) {

	}

	public Flashcard read(int id) throws SQLException {
		Connection conn = cf.getConnection();
		ResultSet rs;
		Flashcard card;

		String query = "SELECT A.id, A.question, A.answer, B.name" + "FROM Flashcards A"
				+ "JOIN Category B ON A.category = B.category" + "WHERE A.id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
			card = new Flashcard();
		}
		card.setId(rs.getInt("id"));
		card.setQuestion(rs.getString("question"));
		card.setAnswer(rs.getString("answer"));
		card.setCategory(rs.getDouble("name"));

	}
	rs.close();
	ps.close();
	conn.close();

	return card;

	}

	public List<Flashcard> read() {
		return null;

	}

	public void update(int cardId, String update) {

	}

	public void delete(int cardId) {

	}
}
