package com.revature.flashcards.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.flashcards.daoimpls.FlashcardDAOImpl;
import com.revature.flashcards.models.Flashcard;
import com.revature.flashcards.models.Alert;

public class HomeController {

	public static String Home(HttpServletRequest req) {
		return "/html/index.html";
	}

	public static String FlashcardJSON(HttpServletRequest req, HttpServletResponse resp) {
		try {
			ArrayList<Flashcard> reimb_list = new FlashcardDAOImpl().getAllFlashCards();
			//System.out.println(reimb_list);
			resp.getWriter().write(new ObjectMapper().writeValueAsString(reimb_list));
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String AddFlashcard(HttpServletRequest req) {
		Flashcard fc = new Flashcard(req.getParameter("question"), req.getParameter("answer"), Integer.parseInt(req.getParameter("category")));
		FlashcardDAOImpl fcd = new FlashcardDAOImpl();
		boolean success = fcd.insertFlashCard(fc);
		
		if(success) {
			Alert alert = new Alert("success","Flashcard Added");
			req.getSession().setAttribute("Alert", alert);
		}else {
			Alert alert = new Alert("danger","Error entering flashcard");
			req.getSession().setAttribute("Alert", alert);
		}
		return "/html/index.html";
	}

}
