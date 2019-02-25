package flashcard.dao;

import static flashcard.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import flashcard.beans.Flashcard;
import flashcard.util.ConnectionUtil;

public class FlashcardDaoImpl implements FlashcardDao {

	public boolean addFlashCard(Flashcard fc) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,?,?,?)");

			stmt.setString(2, fc.getQuestion());
			stmt.setString(3, fc.getAnswer());
			stmt.setInt(4, fc.getCategoryId());
			
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close(stmt);
		}

		return true;
	}

	public boolean updateFlashcard(Flashcard fc) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("UPDATE flashcard SET question=?, answer=?, category_id=?");

			stmt.setString(1, fc.getQuestion());
			stmt.setString(2, fc.getAnswer());
			stmt.setInt(3, fc.getCategoryId());
			
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close(stmt);
		}

		return true;
	}

	public boolean deleteFlashcard(int fcId) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("DELETE FROM flashcard WHERE flashcard_id=?");

			stmt.setInt(1, fcId);
			
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close(stmt);
		}

		return true;
	}

	public List<Flashcard> getAllFlashcards() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Flashcard> fcList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT f.flashcard_id, f.question, f.answer, f.category_id, " +
					"c.category_name FROM flashcard f INNER JOIN category c ON f.category_id = c.fc_category_id");

			while (rs.next()) {
				fcList.add(new Flashcard(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return fcList;
	}

	public List<Flashcard> getFlashcardsByCategory(int categoryId) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Flashcard> fcList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("SELECT f.flashcard_id, f.question, f.answer, f.category_id, " +
					"c.category_name FROM flashcard f INNER JOIN category c ON f.category_id = c.fc_category_id " +
					"WHERE f.category_id=?");
			
			stmt.setInt(1, categoryId);

			rs = stmt.executeQuery();

			while (rs.next()) {
				fcList.add(new Flashcard(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return fcList;
	}

}
