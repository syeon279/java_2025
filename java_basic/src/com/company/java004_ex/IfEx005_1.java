package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005_1 {
	public static <string> void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("변환 하실 문자를 입력하세요 >"); char ch = scanner.next().charAt(0);
		
		String result = "영어를 입력하세요.";
		
		if ((ch>='A') && (ch<='Z')) {
			// 문자열 "ABC" 자료형이 안맞음 
			result = " " + (ch+=32);
		} else if ((ch >= 'a') && (ch<='z')) {
			result = " " + (ch-=32);
		}
		System.out.println(result);
	}
}
