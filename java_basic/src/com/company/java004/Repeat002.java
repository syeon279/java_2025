package com.company.java004;

import java.util.Scanner;

public class Repeat002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 입력 > "); int num = scanner.nextInt();
		
		String result = " 1, 2, 3이 아닙니다. ";
		
		switch (num) {
		case 1: result = "1이다."; break;
		case 2: result = "2이다."; break;
		case 3: result = "3이다."; break;
		}
		System.out.println(result);
	}

}
