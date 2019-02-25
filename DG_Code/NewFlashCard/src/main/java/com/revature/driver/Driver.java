package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAOImpl.CategoriesDAOImpl;
import com.revature.DAOImpl.FlashCardDAOImpl;
import com.revature.bean.Categories;
import com.revature.bean.FlashCard;
import com.revature.util.OneScanner;

public class Driver {

	public static void main(String[] args) {
		// Testing retrieving data from database
		
		FlashCard newFlashCard = new FlashCard();
		FlashCardDAOImpl flashDAOImpl = new FlashCardDAOImpl();
		CategoriesDAOImpl categoriesDAOImpl = new CategoriesDAOImpl();
		List<Categories> allCategories = new ArrayList<>();
		String category;
		try {
			allCategories =  categoriesDAOImpl.getAllCategories();
			
			for(int i = 0; i < allCategories.size(); i++)
			{
				System.out.println(allCategories.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Create Flash Card");
		newFlashCard.setQuestion(OneScanner.getScanner().nextLine());
		newFlashCard.setAnswer(OneScanner.getScanner().nextLine());
		category = OneScanner.getScanner().nextLine();
		
		for(int i=0; i<allCategories.size(); i++)
		{
			if(category.equals(allCategories.get(i).getCategoryName())) {
				newFlashCard.setCategoryId(allCategories.get(i).getCategoryId());
				try {
					flashDAOImpl.createFlashCard(newFlashCard);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
