package com.company.java014;

import java.util.Scanner;

public class Exception001 {
	public static void main(String[] args) {
		int a = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try { 
				System.out.println("1 입력: "); 
				a = scanner.nextInt(); // 숫자 입력받기를 기다림. 
										//2. 'a'
				if(a==1) { System.out.println("종료합니다."); break; }
			} catch(Exception e) { 
				System.out.println("다시 시도하세요");
				scanner.next();
			}
		}// E while
	}

}
