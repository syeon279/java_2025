package com.company.java005_ex;

import java.util.Scanner;

public class ForEx002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력하세요 >"); int num= scanner.nextInt();
		for ( int i =1; i<=9; i++ ) {
			System.out.println(num + "X" + i + '=' + (num*i));
		}
	}

}
