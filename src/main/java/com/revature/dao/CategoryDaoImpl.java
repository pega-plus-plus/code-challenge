package com.revature.dao;
import static com.revature.util.CloseStream.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Category;
import com.revature.util.ConnectionUtil;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> viewAllCategory() {
		List<Category> cats = new ArrayList<>();
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			stat = conn.prepareStatement("SELECT * FROM category");
			rs = stat.executeQuery();
					
			while (rs.next()) {
				cats.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(stat);
		}
		return cats;
	}

}
