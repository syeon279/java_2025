package com.company.java005_ex;

import java.util.Scanner;

public class Repeat004 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(;;) {
			System.out.print("숫자를 입력하세요> ");
			int a = scanner.nextInt();
			System.out.println(a);
			if (a==1) {
				break;
			}
		} 
	}

}
