package com.assignment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public static String process (HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		//names are all tentative, depending on js call
		case "/TRMSProject/html/Login.do":
			break;

		}
		return null;
	}
}
