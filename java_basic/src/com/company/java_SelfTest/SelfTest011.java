package com.company.java_SelfTest;

import java.util.Scanner;

public class SelfTest011 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(;;) {
			System.out.println("숫자 입력"); int i = scanner.nextInt();
			if(i<= 100 && i>=1) {
				System.out.println("종료");break;
			}
		}
	}

}
