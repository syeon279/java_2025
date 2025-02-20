package com.company.java004_ex;

import java.util.Scanner;

public class IfEx003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 > "); int ex3 = scanner.nextInt();
		if (ex3==1) {
			System.out.println("one");
		} else if (ex3==2) {
			System.out.println("two");
		} else if (ex3==3) {
			System.out.println("three");
		} else {
			System.out.println("1,2,3이 아닙니다.");
		}
	}

}
