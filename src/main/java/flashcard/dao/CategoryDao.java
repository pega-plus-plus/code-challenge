package flashcard.dao;

import java.util.List;

import flashcard.beans.Category;

public interface CategoryDao {

	public boolean addCategory(Category cat);
	public List<Category> getAllCategories();
	public String getCategoryName(int catId);
}
