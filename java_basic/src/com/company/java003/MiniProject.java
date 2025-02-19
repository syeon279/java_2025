package com.company.java003;

import java.util.Scanner;

public class MiniProject {

	public static void main(String[] args) {
		// 삼항 연산자를 이용하여 메뉴판 만들기
		// 1이면 추가, 출력 2이면 조회, 3이면 입금, 4이면 출금, 9이면 종료
//		int i;
		Scanner scanner = new Scanner(System.in); 
//		System.out.print("입력하세요>"); int i = scanner.nextInt();
//		String result;
//		result = i == 1 ? "추가" : "다시 입력하세요.";
//		result = i == 2 ? "조회" : "다시 입력하세요.";
//		result = i == 3 ? "입금" : "다시 입력하세요.";
//		result = i == 9 ? "종료" : "다시 입력하세요.";
//		System.out.println(result);
		
		System.out.print("입력하세요> "); int i1 = scanner.nextInt();
		String result1 = i1 == 1 ? "추가" : i1 == 2 ? "조회" : i1 == 3 ? "입금" : i1 == 9 ? "종료"  : "다시 입력하세요.";
		System.out.println(result1);
//		System.out.print("입력하세요> "); i1 = scanner.nextInt(); 
//		System.out.println(result1); 
		
	}

}
