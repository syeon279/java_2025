package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자를 입력하세요> "); char ch = scanner.next().charAt(0);
		String result = "영어를 입력하세요.";
		if ((ch >= 'A') && (ch <= 'Z')) {
			result = "대문자";
		} else if ((ch >= 'a') && (ch <= 'z')) {
			result = "소문자";
		} 
		System.out.println(result);
		
	}

}
