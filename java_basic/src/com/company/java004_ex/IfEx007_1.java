package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007_1 {

	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 숫자를 입력하세요 > "); int num1 = scanner.nextInt();
		System.out.print("원하는 연산을 입력하세요(+,-,*,/) > "); char ch = scanner.next().charAt(0);
		System.out.print("두 번째 숫자를 입력하세요 > "); int num2 = scanner.nextInt();
		String result = "";
		// 계산기
		//출력구문 하나만 써서 
		
//		switch (ch) {
//		case '+' : result = num1 + num2; break;
//		case '-' : result = num1 - num2; break; 
//		case '*' : result = num1 * num2; break;
//		case '/' : result1 = num1 / (double)num2;
//		}
//		if (ch == '/') {
//			System.out.printf("결과: %d" + " %s " + "%d" + " = " + "%.2f\n", num1, ch, num2, result1);
//		} else {
//			System.out.printf("결과: %d" + " %s " + "%d" + " = %d" , num1, ch, num2, result);
//		}
		
		
		switch (ch) {
		case '+' : result = " "+(num1 + num2); break;
		case '-' : result = " "+(num1 - num2); break; 
		case '*' : result = " "+(num1 * num2); break;
		case '/' : result = String.format("%.2f", num1/(double)num2);
		}
//		if (result == (int)result) {
//			result = (int)result;
//			System.out.printf("결과: %d  %s  %d  =  %d", num1, ch, num2, result);
//		}
		System.out.printf("결과: %d  %s  %d  =  %s", num1, ch, num2, result);
		
		//result의 자료형을 문자열로 바꾼다음, 연산결과를 문자형으로 처리. 
			
	}
//	public static String formatResult(double num) {
//		if (result == (int)result) {
//			return String.valueOf((int)result);
//		} else {
//			return String.valueOf(result);
//		}
//	}

}
