package com.company.java_SelfTest;

import java.util.Scanner;

public class SelfTest005 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int age;
		System.out.println("나이 입력:"); age = scanner.nextInt();
		if(age<19) {
			System.out.println("미성년자");
		} else {
			System.out.println("성인");
		}
	}

}
