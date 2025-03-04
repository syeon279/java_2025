package com.company.java_SelfTest;

import java.util.Scanner;

public class SelfTest004 {

	public static void main(String[] args) {
		int kor, eng;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수> "); kor = scanner.nextInt();
		System.out.print("영어 점수> "); eng = scanner.nextInt();
		
		if (kor < 40) {
			System.out.println("국어 과락");
		}
		if (eng < 40) {
			System.out.println("영어 과락");
		}
	}

}
