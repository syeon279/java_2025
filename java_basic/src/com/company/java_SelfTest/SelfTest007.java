package com.company.java_SelfTest;

import java.util.Scanner;

public class SelfTest007 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch; String result = "다시 입력하세요.";
		System.out.println("입력: "); ch = scanner.next().charAt(0);
//		if(ch=='A'||ch=='B'||ch=='C') {
//			ch+=32;
//		}
		switch(ch) {
		case 'a' : case 'A'  : result = "apple"; break;
		case 'b' : case 'B' : result = "banana"; break;
		case 'c' : case 'C' : result = "coconut"; break;
		}
		System.out.println(result);
	}

}
