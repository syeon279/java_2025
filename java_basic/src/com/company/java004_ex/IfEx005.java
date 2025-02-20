package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005 {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("변환 하실 문자를 입력하세요 >"); char ch = scanner.next().charAt(0);
		if ((ch>='A') && (ch<='Z')) {
			System.out.println(ch+=32);
		} else if ((ch >= 'a') && (ch<='z')) {
			System.out.println(ch-=32);
		} else {
			System.out.println("영어를 입력하세요.");
		}
	}
}
