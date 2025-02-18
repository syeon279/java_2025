package com.company.java002;

import java.util.Scanner;

public class DataType002 {
	public static void main(String [] args) {
		// 자료형의 분류 : 기본형(값) / 참조형(주소)
		// 기본형 : 논리형, 정수형, 실수형
		
		// OOP 클래스(부품객체)들을 조립해 완성해가는 프로그램 (객체 지향 언어)
		int      a = 1; // 기본형
		Scanner scanner = new Scanner(System.in); // 참조형 ctrl + shift + O
		// 1. new 공간 빌리기      heap[]
		// 2. Scanner(System.in) 사용할 수 있게 초기화 -키보드로 입력 표준입력 system.in
		// heap 1000번지 [  [키보드로 입력받는 기능]   ] <- scanner [1000번지]
		// OOP 
		
		System.out.print("좋아하는 숫자를 입력하세요. > ");
		a = scanner.nextInt();  //자료형에 맞게 입력받고 처리
		
		System.out.println("좋아하는 숫자는 : " + a);
		
		
		
		
	}
}
