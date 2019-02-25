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

			stmt.setString(2, cat.getCategoryName());
			
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close(stmt);
		}

		return true;
	}

	@Override
	public List<Category> getAllCategories() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Category> catList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM category");

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

}
