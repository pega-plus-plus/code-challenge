package com.revature.flashcards.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.flashcards.dao.CategoryDAO;
import com.revature.flashcards.models.Category;
import com.revature.flashcards.util.ConnFactory;

public class CategoryDAOImpl implements CategoryDAO{

	private static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public ArrayList<Category> getAllCategories() {
		try (Connection conn = cf.getConnection();) {
			String sql = "SELECT * FROM category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Category> category_list = new ArrayList<>();
			while(rs.next()) {
				Category category = new Category();
				category.setName(rs.getString("name"));
				category.setId(rs.getInt("id"));
				category_list.add(category);			
			}
			
			return category_list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
