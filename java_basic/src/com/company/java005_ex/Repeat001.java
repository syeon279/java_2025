package com.company.java005_ex;

import java.util.Scanner;

public class Repeat001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		if(num == 10) {
			System.out.println("10이다.");
		} else if (num == 20) {
			System.out.println("20이다.");
		} else if (num==30) {
			System.out.println("30이다.");
		} else {
			System.out.println( "다시 입력하세요.");
		}
	}

}
