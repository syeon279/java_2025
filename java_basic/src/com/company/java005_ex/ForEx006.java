package com.company.java005_ex;

import java.util.Scanner;

public class ForEx006 {

	public static void main(String[] args) {
		//변수
		//입력
		Scanner scanner = new Scanner(System.in);
		int num1, num2;  String result = " "; char op = ' ';
//		System.out.println("숫자1 >"); num1 = scanner.nextInt();
//		System.out.println("숫자2 >"); num2 = scanner.nextInt();
//		System.out.println("연산자(+, -, *, /) > "); char op = scanner.next().charAt(0);
		
		for (;;) {
			System.out.println("숫자1 >"); num1 = scanner.nextInt();
			if ((num1 > 100) || (num1 <0)) {
				System.out.println("0~100 사이의 숫자를 입력하세요."); continue;
			}
			if ((num1 <= 100) && (num1 >= 0)) {
				break;
			}
		} 
		for (;;) {
			System.out.println("숫자2 >"); num2 = scanner.nextInt();
			if ((num2 > 100) || (num2 <0)) {
				System.out.println("0~100 사이의 숫자를 입력하세요."); continue;
			}
			if ((num2 <= 100) && (num2 >= 0)) {
				break;
			}
		} 
		for (;;) {
			System.out.println("연산자(+, -, *, /) > "); op = scanner.next().charAt(0);
			if (op == '+' || op == '-' || op == '*' || op == '/') {
				break;
			}
		}
		// 처리
		switch(op) {
		case '+' : result = " " + (num1 + num2); break;
		case '-' : result = " " + (num1 - num2); break;
		case '*' : result = " " + (num1 * num2); break;
		case '/' : result = String.format("%.2f", num1/(double)num2); 
		}
		// 출력
		System.out.printf("결과: %d %s %d = %s", num1, op, num2, result);
		
		// op != '/'? ""+(int)result : String.format(%.2f, result) 
		// result를 double로 선언했을때, 사용 ""는 문자열로 출력하고 싶을 때 사용. 
	}// E main

}// E class

