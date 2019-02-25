package com.flashcard.dao;

import java.util.List;

import com.flashcard.bean.FlashCard;

public interface ViewFlashCardDao {

	public abstract List<FlashCard> viewFlashCards();
	public abstract List<FlashCard> viewCategory(String category);
}
