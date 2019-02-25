package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {

	public static String Home(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Home.html";
		}

		return null;

	}

}
