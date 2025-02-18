package com.company.java002;

public class Print {

	public static void main(String[] args) {
		System.out.printf("정수 %d, 실수 %f, 문자열 %s", 1, 1.2, "abc\n");
		// 4. +의 의미
		System.out.println(10 + 3); //숫자 + 숫자
		System.out.println(10 + 3 + "+" + 1 + 2 ); // 13 + 1 2 
		// Q. system.out.println( 1+2=3 );
		System.out.println( 1+"+"+2+"="+3 );
	}
}
