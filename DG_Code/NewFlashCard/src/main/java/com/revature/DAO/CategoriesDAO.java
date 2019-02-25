package com.revature.DAO;

import java.sql.SQLException;
import java.util.List;

import com.revature.bean.Categories;

public interface CategoriesDAO {

	// READ
	public abstract List<Categories> getAllCategories() throws SQLException;
	

}
