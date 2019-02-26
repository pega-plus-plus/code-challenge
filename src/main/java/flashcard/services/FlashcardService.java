package flashcard.services;

import java.util.List;
import java.util.Random;

import flashcard.beans.Flashcard;
import flashcard.dao.FlashcardDao;
import flashcard.dao.FlashcardDaoImpl;

public class FlashcardService {
	private FlashcardDao fcDao = new FlashcardDaoImpl();
	
	public Flashcard getRandomFlashcard() {
		List<Flashcard> fcList = fcDao.getAllFlashcards();
		
		Random rand = new Random();
	    int randomIndex = rand.nextInt(fcList.size());
		
		return fcList.get(randomIndex);
	}
	
	public Flashcard getRandomFlashcardInCategory(int catId) {
		List<Flashcard> fcList = fcDao.getFlashcardsByCategory(catId);
		
		Random rand = new Random();
	    int randomIndex = rand.nextInt(fcList.size());
		
		return fcList.get(randomIndex);
	}

}
