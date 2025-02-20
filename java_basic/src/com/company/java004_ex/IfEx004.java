package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자를 입력하세요> "); char ch = scanner.next().charAt(0);
		if ((ch >= 'A') && (ch <= 'Z')) {
			System.out.println("대문자 입니다.");
		} else if ((ch >= 'a') && (ch <= 'z')) {
			System.out.println("소문자 입니다.");
		} else {
			System.out.println("영어를 입력하세요. ");
		}
	}

}
