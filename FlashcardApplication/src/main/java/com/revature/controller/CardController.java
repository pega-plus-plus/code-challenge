package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Flashcard;
import com.revature.daoimpl.FlashcardDaoImpl;

public class CardController {

	/*Submit a flashcard for creation*/
	public static String SubmitCard(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		int category = Integer.parseInt(request.getParameter("category"));
		Flashcard card = new Flashcard(question, answer, category);
		FlashcardDaoImpl fcdi = new FlashcardDaoImpl();
		fcdi.create(card);
		return "home.html";
	}

	/*Retrieve table of flashcards in JSON string*/
	public static String CardTableJSON(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		FlashcardDaoImpl rfdi = new FlashcardDaoImpl();
		List<Flashcard> cardList = (List<Flashcard>)rfdi.read();
		System.out.println(cardList);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(cardList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String DeleteCard(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException {
		System.out.println("cardController delete method");
		FlashcardDaoImpl fcdi = new FlashcardDaoImpl();
		if(request.getParameterMap().isEmpty()) {
			System.out.println("PARAMS ARE EMPTY");
			return "home.html";
		};
		//fcdi.delete((int) request.getAttribute("id"));
		
		//System.out.println("PARAMS: " + request.getParameterMap().entrySet());
		return null;
	}
}
