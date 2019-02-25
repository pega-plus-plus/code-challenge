package com.revature.util;

import java.util.Scanner;

public class OneScanner {

	static Scanner scan = new Scanner(System.in);

	private OneScanner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Scanner getScanner() {
		return scan;
	}
}
