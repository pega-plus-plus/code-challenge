package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Flashcard;

public class HomeController {
	

	public static String Home(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Home.html";
		}
		return null;
}

	public static String FlashcardJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in JSON method");
		Flashcard card =(Flashcard)request.getSession().getAttribute("Flashcard");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(card));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
