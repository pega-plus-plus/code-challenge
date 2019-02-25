package com.revature.flashcards.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.flashcards.controller.AlertController;

public class RequestHelper {

	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		
		switch(req.getRequestURI()) {
		case "/Flashcards/html/home.do":
			return HomeController.Home(req);
		case "/Flashcards/html/flashcardJSON.do":
			return HomeController.FlashcardJSON(req,resp);
		case "/Flashcards/html/add_fc.do":
			return HomeController.AddFlashcard(req);
		case "/Flashcards/html/alertJSON.do":
			return AlertController.AlertJSON(req,resp);
		default:
			return HomeController.Home(req);
		}
		
		
	}

}
