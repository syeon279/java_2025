package com.company.java007;

import java.util.Scanner;

public class Repeat002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력하세요> "); char a = scanner.next().charAt(0);
		String result = "존재하지 않는 단어입니다.";
		switch(a) {
		case 'a' : result = "apple"; break;
		case 'b' : result = "banana"; break;
		case 'c' : result = "coconut"; break;
		}
		System.out.println(result);
	}

}
