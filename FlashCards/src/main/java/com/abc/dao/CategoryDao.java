package com.abc.dao;

import static com.abc.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abc.beans.Category;
import com.abc.util.DBConnection;

public class CategoryDao {
	
	/**
	 * Get all flashcards
	 * @return a list of flashcards
	 */
	public List<Category> getAllCategorys(){
		String sql = "SELECT * FROM category";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		
		try(Connection conn = DBConnection.getConnection()){
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Category(
						rs.getInt(1),
						rs.getString(2)
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
	public List<Category> getCategoryByCategoryId(int categoryId){
		String sql = "SELECT * FROM category WHERE categoryId = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();		
		
		try(Connection conn = DBConnection.getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Category(
						rs.getInt(1),
						rs.getString(2)
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
	public boolean insertCategory(Category cat) {
		String sql = "INSERT INTO category VALUES(?,?)";
		PreparedStatement ps = null;
		
		try (Connection conn = DBConnection.getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setObject(1, null);
			ps.setString(2, cat.getName());
			
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if(ps != null) {
				close(ps);
			}
		}
		return false;
	}
}
