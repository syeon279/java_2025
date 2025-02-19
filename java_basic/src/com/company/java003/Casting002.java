package com.company.java003;

import java.util.Scanner;

public class Casting002 {
	public static void main( String [] args) {
		// 1. 문자 초기화
		// 문자는 저장시 숫자로 출력시 문자로 
		char ch1 = ' '; // 공백 한개라도 있어야함
		char ch2 = '\u0000';
		System.out.println("1. :  " + ch1 + "\t" + ch2); //\t 누른 효과
		System.out.println("2. :  " + (int)ch1 + "\t" + (int)ch2); //\t 누른 효과
		
		// 2. 문자의 연산
		char c = 'A';
		System.out.println("3. :  " + c + "\t" + (int)c );
		
		System.out.println("4. :  " + (char)(c+1)); //66
		// A=65  B=66 C=67
		// 1) +는 더하기 연산
		// 2) 숫자 + 숫자 더하기 
		// 3) 'A' + 1 = 'A'(char | 2byte) + 1(int | 4byte) 
		byte ex1 = 1;
		int result = ex1 + 10;// byte(1) + int(4);
		System.out.println(result);
		
		// Q1. 대문자 'A'를 소문자 'a'로 변환시키기
		char q1 = 'A';
		System.out.println(((int)'a')); //97   97-65 = 32
		System.out.println("5. :  " + (char)((int)'A'+32));
		System.out.println("5. :  " + (q1+=32)); // += 더하기를 하고 대입, q1의 자료형은 char임.
		
		// 3. 문자열
		// 자료형의 분류는 기본형과 참조형 String은 기본형이 아님
		String str1 = "abc";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(str1); //str1주소
		System.out.println(scanner); // scanner 주소
		
		System.out.println(str1.charAt(0) );
		System.out.println(str1.charAt(1) );
		System.out.println(str1.charAt(2) );
		
		String str = scanner.next();
		System.out.println("입력한 문자열 : " + str);
		
		char ch = scanner.next().charAt(0);
		System.out.println("입력한 문자 : " + ch);
		
		//Q2 대문자 입력을 받아서 소문자로 변경프로그램 castingEx003
		
		
	}
}
