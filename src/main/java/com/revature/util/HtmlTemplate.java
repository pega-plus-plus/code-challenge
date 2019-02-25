package com.revature.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HtmlTemplate {
	public static void goBack(PrintWriter out) {
		out.println(
                "<hr><input type='button' value='GO BACK' "
                + "onclick='goBack()'>"
                + "<script>function goBack(){ window.history.back();}"
                + "</script>"
            );
	}
	
	public static PrintWriter getHtmlOut(HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		return res.getWriter();
	}
	
	public static void printTableHeaders(PrintWriter out, String ...headers) {
		out.println("<table border=2p style='color:green'x><tr>");
		for(String h: headers) {
			out.println("<th>" + h + "</th>");
		}
		out.println("</tr>");
	}
}
