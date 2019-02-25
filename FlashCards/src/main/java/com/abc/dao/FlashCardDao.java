package com.abc.dao;

import static com.abc.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abc.beans.FlashCard;
import com.abc.util.DBConnection;

public class FlashCardDao {
	
	/**
	 * Get all flashcards
	 * @return a list of flashcards
	 */
	public List<FlashCard> getAllFlashCards(){
		String sql = "SELECT * FROM flashcard";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FlashCard> list = new ArrayList<FlashCard>();
		
		try(Connection conn = DBConnection.getConnection()){
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new FlashCard(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4)
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				close(ps);
			}
			if(rs != null) {
				close(rs);
			}
		}		
		
		return list;
	}
	
	/**
	 * get all flashcards by category
	 * 
	 * @param category
	 * @return
	 */
	public List<FlashCard> getFlashCardByCategory(int category){
		String sql = "SELECT * FROM flashcard WHERE categoryId = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FlashCard> list = new ArrayList<FlashCard>();		
		
		try(Connection conn = DBConnection.getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new FlashCard(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4)
						));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				close(ps);
			}
			if (rs != null) {
				close(rs);
			}
		}
		
		return list;
	}
	
	/**
	 * creating a new flashcard
	 * 
	 * @param flashcard the flashcard to insert
	 * @return
	 */
	public boolean insertFlashCard(FlashCard flashcard) {
		String sql = "INSERT INTO flashcard VALUES(?,?,?,?)";
		PreparedStatement ps = null;
		
		try (Connection conn = DBConnection.getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setObject(1, null);
			ps.setString(2, flashcard.getQuestion());
			ps.setString(3, flashcard.getAnswer());
			ps.setInt(4, flashcard.getCategoryId());
			
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if(ps != null) {
				close(ps);
			}
		}
		return false;
	}
	
	/**
	 * Deleting a flashcard
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteFlashCard(int id) {
		String sql = "DELETE FROM flashcard WHERE id = ?";
		PreparedStatement ps = null;
		try(Connection conn = DBConnection.getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				close(ps);
			}
		}
		return false;
	}

}
