package com.company.java003_ex;

import java.util.Scanner;

public class OperatorEx002 {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		//q1-1 int형 변수 x가 3보다 크고 10보다 작을때 true인 조건식 
		System.out.print("Q1. X의 값이 3보다 크고 10보다 작은가? >"); 
		int x = scanner.nextInt();
		System.out.println((x>3)&&(x<10));
		//q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식    
		System.out.print("Q2. a 또는 A인가? > "); 
		char ch = scanner.next().charAt(0);
		System.out.println((ch == 'a') || (ch=='A'));
		//q1-3 char형 변수 ch1가 숫자('0'~'9')일때   true인 조건식    
		System.out.print("Q3. 0-9까지의 숫자인가? > "); 
		String ch1 = scanner.next();
		char ch2 = ch1.charAt(0);
		char ch3 = ch1.charAt(1);
//		System.out.println(((int)ch2 >= 0 || (int)ch2<=9) && (int)ch3<=0 && (int)ch3 != null); // 두번째 숫자가 없으면 오류남
		
		System.out.print("Q3-1. 0-9까지의 숫자인가? > "); 
		String ch11 = scanner.next(); //48~57
		char ch22 = ch11.charAt(0);
		System.out.println((ch22 >='0') && (ch22 <='9'));
//		System.out.println((int)ch22 >= 48 && (int)ch22 <= 57);
		//q1-4 char형 변수 ch2가 영문자(대문자 또는 소문자) 일 때 true인 조건식 
//		System.out.println((int)'A');
//		System.out.println((int)'a');
//		System.out.println((int)'Z');
//		System.out.println((int)'z');
		System.out.print("Q4. 영문자인가? > "); 
		char ch4 = scanner.next().charAt(0);
		System.out.println(((int)ch4 >= 65) && ((int)ch4 <= 122));
	}
}
