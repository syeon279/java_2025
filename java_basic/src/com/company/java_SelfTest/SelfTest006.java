package com.company.java_SelfTest;

import java.util.Scanner;

public class SelfTest006 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int kor; String result ="가";
		System.out.println("국어 점수: "); kor = scanner.nextInt();
		
		if (kor>=90) {
			result = "수";
		} else if (kor >= 80) {
			result = "우";
		} else if (kor >= 70) {
			result = "미";
		} else if (kor >= 60) {
			result = "양";
		} 
		System.out.println(result);
	}

}
