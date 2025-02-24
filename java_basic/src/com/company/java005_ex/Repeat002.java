package com.company.java005_ex;

import java.util.Scanner;

public class Repeat002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt(); String result = "다시 입력하세요.";
		
		switch (a) {
		case 10 : result ="10이다."; break;
 		case 20 : result = "20이다."; break;
		case 30 : result = "30이다."; break;
		}
		System.out.println(result);
	}

}
