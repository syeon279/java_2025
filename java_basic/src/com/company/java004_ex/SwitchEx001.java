package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("현재 달을 입력해 주세요 > "); int month = scanner.nextInt();
		String result = "존재하지 않는 달";
		switch(month) {
		case 3: case 4: case 5:
			result = "봄"; break;
		case 6: case 7: case 8:
			result = "여름"; break;
		case 9: case 10: case 11:
			result = "가을"; break;
		case 12: case 1: case 2:
			result = "겨울"; break;
		}
		System.out.printf("%d월은 %s 입니다. ", month, result );
	}

}
