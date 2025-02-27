package com.company.java009;

import java.util.Scanner;

public class Repeat001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하세요> ");char ch = scanner.next().charAt(0);
		String result="다시 입력하세요.";
		if (ch=='j') { 
			result = "Java";
		} else if (ch == 'h') {
			result = "html";
		} else if (ch == 'c') {
			result = "css";
		}
		
		System.out.println(result);
	}

}
