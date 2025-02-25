package com.company.java007;

import java.util.Scanner;

public class Repeat001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하세요>");char a=scanner.next().charAt(0);
		String result="존재하지 않는 단어입니다.";
		if (a=='a') {
			result = "apple";
		} else if (a=='b') {
			result = "banana";
		} else if (a=='c') {
			result = "coconut";
		} 
		System.out.println(result);
	}
}