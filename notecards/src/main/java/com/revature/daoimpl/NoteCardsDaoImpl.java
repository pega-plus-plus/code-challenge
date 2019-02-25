package com.revature.daoimpl;

import com.revature.dao.NoteCardsDao;
import com.revature.model.Notecards;

public class NoteCardsDaoImpl implements NoteCardsDao{

	@Override
	public Notecards AddNoteCard(String question, String answer, String category) {
		// TODO Auto-generated method stub
		
		System.out.println("Question: "+ question +"Answer: "+ answer + "Category: "+category);
		return null;
	}

}
