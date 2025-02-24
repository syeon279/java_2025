package com.company.java005_ex;

import java.util.Scanner;

public class ForEx006_1 {

	public static void main(String[] args) {
		// for 문 하나로 만들기
		//변수
		Scanner scanner = new Scanner(System.in);
		int num1 = -1, num2 = -1;  char op = ' '; String result = " "; 
		//입력 num을 거짓으로 만들고 시작.
		for (;;) {
			if ((num1 > 100) || (num1 < 0 )) {
				System.out.println("숫자1 >"); num1 = scanner.nextInt(); continue;
			}
			if ((num2 > 100) || (num2 < 0)) {
				System.out.println("숫자2 >"); num2 = scanner.nextInt(); continue;
			}
			if (!(op == '+' || op == '-' || op == '*' || op == '/')) {
				System.out.println("연산자(+, -, *, /) > "); op = scanner.next().charAt(0); continue;
			}
			break; // num1 num2 op 잘 쓴 경우
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

	}// E main

}// E class

