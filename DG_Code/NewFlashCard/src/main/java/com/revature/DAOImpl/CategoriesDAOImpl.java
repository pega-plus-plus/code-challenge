package com.revature.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.CategoriesDAO;
import com.revature.bean.Categories;
import com.revature.util.ConnFactory;

public class CategoriesDAOImpl implements CategoriesDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public List<Categories> getAllCategories() throws SQLException {
		List<Categories> allCategories = new ArrayList<>();
		Categories categories = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM categories";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			categories = new Categories(rs.getInt("category_id"), rs.getString("category_name"));
			allCategories.add(categories);
		}
		return allCategories;
	}

}
