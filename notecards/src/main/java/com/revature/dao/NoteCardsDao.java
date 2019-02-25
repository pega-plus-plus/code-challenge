package com.revature.dao;

import com.revature.model.Notecards;

public interface NoteCardsDao {

	public Notecards AddNoteCard(String question, String answer, String category);
}
