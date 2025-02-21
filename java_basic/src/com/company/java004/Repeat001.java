package com.company.java004;

import java.util.Scanner;

public class Repeat001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 입력: "); int num = scanner.nextInt();
		
		if (num==1) {
			System.out.println("1이다.");
		} else if (num==2) {
			System.out.println("2이다.");
		} else if (num==3) {
			System.out.println("3이다.");
		} else {
			System.out.println("1,2,3이 아닙니다.");
		}
	}

}
