package com.company.java009;

import java.util.Scanner;

public class Repeat002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하세요> ");char ch = scanner.next().charAt(0);
		String result="다시 입력하세요.";
		switch (ch) {
		case 'j':result = "java"; break;
		case 'h': result = "html"; break;
		case 'c': result = "css";
		}
		System.out.println(result);
	}

}
