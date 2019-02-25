package com.assignment.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.assignment.DAO.FlashCardDAO;
import com.assignment.bean.FlashCard;
import com.assignment.utilities.ConnectionFactory;

public class FlashCardDAOImpl implements FlashCardDAO{
	
	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	Connection conn = cf.getConnection();
	
	@Override
	public void createFlashCard(String question, String answer, String category) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO flashcard (fc_id, question, answer, fc_category) VALUES (fc_id_seq.NEXTVAL, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, question);
		ps.setString(2, answer);
		ps.setString(3, category);
		int tempI = ps.executeUpdate();
	}

	@Override
	public FlashCard readFlashCard(int fc_id) throws SQLException {
		FlashCard f = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM flashcard WHERE fc_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,fc_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			f = new FlashCard(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
		}
		
		return f;
	}

	@Override
	public void updateFlashCard(FlashCard alpha) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE flashcard SET question = ?, answer = ?, fc_category = ? WHERE fc_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, alpha.getQuestion());
		ps.setString(2, alpha.getAnswer());
		ps.setString(3, alpha.getCategory());
		ps.setInt(4, alpha.getId());
		int tempI = ps.executeUpdate();
	}

	@Override
	public void deleteFlashCard(int fc_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM flashcard WHERE fc_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, fc_id);
		int tempI = ps.executeUpdate();
	}

	@Override
	public List<FlashCard> getFlashCardList(String category) throws SQLException {
		List<FlashCard> fcList = new ArrayList<FlashCard>();
		FlashCard f = null;
		Connection conn = cf.getConnection();
		PreparedStatement ps;
		if (category.equals("All"))
			ps = conn.prepareStatement("SELECT * FROM flashcard");
		else {
			ps = conn.prepareStatement("SELECT * FROM flashcard WHERE fc_category = ?");
			ps.setString(1, category);
		}
		ResultSet rs = ps.executeQuery();		
		while (rs.next()) {
			f = new FlashCard (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			fcList.add(f);
		}
		conn.close();
		return fcList;
	}

}
