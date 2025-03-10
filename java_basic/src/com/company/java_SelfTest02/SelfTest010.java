package com.company.java_SelfTest02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SelfTest010 {
	public static int nextInt() throws InputMismatchException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("1을 입력하세요 > ");
		return scanner.nextInt();
	}
	public static void main(String[] args) {
		int one = 0;
		while(true) {
			try {
				one = nextInt();
				if(one==1) {
					System.out.println("종료"); break;
				}
			} catch(Exception e) {
				System.out.println("오류");
			}
		}
	}

}
