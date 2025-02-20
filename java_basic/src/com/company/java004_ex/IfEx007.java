package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		// 계산기
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 숫자를 입력하세요 > "); int num1 = scanner.nextInt();
		System.out.print("두 번째 숫자를 입력하세요 > "); int num2 = scanner.nextInt();
		System.out.print("원하는 연산을 입력하세요 > "); char ch = scanner.next().charAt(0);
		
		if (ch == '더') {
			ch = '+' ;
			System.out.printf("%d" + "%s" + "%d = %d", num1 , ch, num2, num1+num2);
		} else if ( ch == '빼') {
			ch = '-';
			System.out.printf("%d" + "%s" + "%d = %d", num1 , ch, num2, num1-num2);
		} else if ( ch == '곱') {
			ch = 'X';
			System.out.printf("%d" + "%s" + "%d = %d", num1 , ch, num2, num1*num2);
		} else if ( ch == '나') {
			ch = '/';
			System.out.printf("%d" + "%s" + "%d = %.2f", num1 , ch, num2, (double)(num1/(double)num2));
		} else {
			System.out.println("원하시는 연산은 더하기, 빼기, 곱하기, 나누기 중 하나를 선택하세요.");
		}
		
//		int total = num1 + (int)ch + num2;
		
//		System.out.printf("%d" + "%s" + "%d = %d", num1 , ch, num2, total);
	}

}
