package com.company.java004;

import java.util.Scanner;

public class Switch001 {

	public static void main(String[] args) {
		// 변수
		int a = 0;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("숫자 한 개 입력>");
		a = scanner.nextInt();
		//처리 
		if (a == 1) {
			System.out.println("1이다.");
		} else if (a==2) {
			System.out.println("2이다.");
		} else if (a==3) {
			System.out.println("3이다.");
		}
		
		switch(a) {
		case 1: System.out.println("1이다."); break;
		case 2: System.out.println("2이다."); break;
		case 3: System.out.println("3이다." ); break;
		default: System.out.println("1,2,3이 아닙니다. ");
		}
		// 출력
	}

}
