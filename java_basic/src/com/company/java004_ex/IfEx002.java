package com.company.java004_ex;

import java.util.Scanner;

public class IfEx002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요> "); int num = scanner.nextInt();
		if (num > 0) {
			System.out.println("양수 입니다.");
		} else if (num < 0) {
			System.out.println("음수 입니다.");
		} else {
			System.out.println("zero");
		}
	}

}
