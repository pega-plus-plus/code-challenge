package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.daoimpl.NoteCardsDaoImpl;

public class NoteCardController {

	public static String Add(HttpServletRequest request) {
		NoteCardsDaoImpl noteCardsDaoImpl = new NoteCardsDaoImpl();
		System.out.println("Adding New FlashCard");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String category = request.getParameter("category");	
		noteCardsDaoImpl.AddNoteCard(question, answer, category);
		return "/html/home.html";
	}

}
