package com.revature.dao;
import static com.revature.util.CloseStream.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.util.ConnectionUtil;

public class FlashcardDaoImpl implements FlashcardDao{

	public List<Flashcard> viewAllFlashcards() {
		List<Flashcard> fcs = new ArrayList<Flashcard>();
		ResultSet rs = null;
		PreparedStatement stat = null;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			stat = conn.prepareStatement("SELECT * from flashcard");
			rs = stat.executeQuery();
			while (rs.next()) {
				fcs.add(new Flashcard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(stat);
		}
		return fcs;
	}

	public List<Flashcard> viewAllFlashcardsByCat(Integer category) {
		List<Flashcard> fcs = new ArrayList<Flashcard>();
		ResultSet rs = null;
		PreparedStatement stat = null;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			stat = conn.prepareStatement("SELECT * from flashcard WHERE cate = ?");
			stat.setInt(1, category);
			rs = stat.executeQuery();
			while (rs.next()) {
				fcs.add(new Flashcard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(stat);
		}
		return fcs;
	}

	public Boolean createNewFlashcard(Flashcard fc) {
		PreparedStatement stat = null;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			stat = conn.prepareStatement("INSERT INTO flashcard VALUES (null, ? , ?, ?)");
			stat.setString(1, fc.getQuestion());
			stat.setString(2, fc.getAnswer());
			stat.setInt(3, fc.getCate());
			
			stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			close(stat);
		}
		
		return true;
	}

	public Boolean updateFlashcard(Flashcard fc) {
		PreparedStatement stat = null;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			stat = conn.prepareStatement("UPDATE set question = ?, answer = ?, cate = ? where f_id = ?");
			stat.setString(1, fc.getQuestion());
			stat.setString(2, fc.getAnswer());
			stat.setInt(3, fc.getCate());
			stat.setInt(4, fc.getF_id());
			stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			close(stat);
		}
		
		return true;
	}

	public Boolean deleteFlashcard(Integer id) {
		PreparedStatement stat = null;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			stat = conn.prepareStatement("DELETE FROM flashcard where f_id = ?");
			stat.setInt(1, id);
			stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			close(stat);
		}
		
		return true;
	}

}
