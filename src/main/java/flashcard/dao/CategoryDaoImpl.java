package flashcard.dao;

import static flashcard.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import flashcard.beans.Category;
import flashcard.util.ConnectionUtil;

public class CategoryDaoImpl implements CategoryDao{

	public boolean addCategory(Category cat) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("INSERT INTO fc_category VALUES(fc_category_seq.NEXTVAL,?)");

			stmt.setString(1, cat.getCategoryName());
			
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close(stmt);
		}

		return true;
	}

	public List<Category> getAllCategories() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Category> catList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM fc_category");

			while (rs.next()) {
				catList.add(new Category(
						rs.getInt(1),
						rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return catList;
	}

	@Override
	public String getCategoryName(int catId) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String categoryName = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("SELECT fc_category_name FROM fc_category WHERE fc_category_id=?");

			stmt.setInt(1, catId);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				categoryName = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		} finally {
			close(stmt);
		}

		return categoryName;
	}

}
