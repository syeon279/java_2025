package com.company.java_SelfTest;

import java.util.Scanner;

public class SelfTest003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		System.out.print("당신의 이름을 입력하세요. > "); name = scanner.next();
		System.out.println("당신의 이름은 " + name + " 입니다.");
	}

}
