package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx003 {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("대문자를 입력하세요 > "); 
		String ch = scanner.next(); char ch1 = ch.charAt(0);
		System.out.println("소문자로 변환:      " + (ch1+=32));
		
		System.out.print("소문자를 입력하세요 > "); 
		char ch2 = scanner.next().charAt(0);
		System.out.println("대문자로 변환:      " + (char)(ch2-=32));
		
//		System.out.print("대문자를 입력하세요 > "); 
//		String ch3 = scanner.next(); char ch3 = ch.charAt(0);
//		System.out.println("소문자로 변환:  " + (char)(ch3+=32));
	}
}
