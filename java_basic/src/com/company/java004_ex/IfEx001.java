package com.company.java004_ex;

import java.util.Scanner;

public class IfEx001 {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("평균을 입력하세요 > "); int avg = scanner.nextInt();
		if (avg>=60) {
			System.out.println("합격 입니다.");
		} else {
			System.out.println("불합격 입니다.");
		}
//		
		
//		if (avg >=60) {
//			System.out.println("합격 입니다.");
//		}
//		if (avg <60) {
//			System.out.println("불합격 입니다.");
//		}
		
		if (avg > 0) {
			if(avg >= 60) {
				System.out.println("합격");
			} 
			System.out.println("불합격");
		} // 불합격 무조건 출력. 
		
//		if ( (avg >= 60) && (avg>0) ) {
//			
//		}
		
		String result = "불합격";
		if ( avg >= 60) {result = "합격";}
		System.out.println(result); // 기본 불합격, 조건에 맞으면 합격
		
	}// e main
}	
