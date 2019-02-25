package com.revature.services;

import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDao;
import com.revature.dao.FlashcardDaoImpl;

public class FlashcardServices {
	public List<Flashcard> viewAllFlashcards(){
		FlashcardDao fcd = new FlashcardDaoImpl();
		
		return fcd.viewAllFlashcards();
	}
	
	public List<Flashcard> viewFlashcardByCat(Integer category){
		FlashcardDao fcd = new FlashcardDaoImpl();
		
		return fcd.viewAllFlashcardsByCat(category);
	}
	
	public Boolean insertFlashcard(Flashcard fc) {
		FlashcardDao fcd = new FlashcardDaoImpl();
		
		return fcd.createNewFlashcard(fc);
	}
}
