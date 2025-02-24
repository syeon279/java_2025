package com.company.java006_ex;

public class RepeatEx009 {

	public static void main(String[] args) {
		char a = ' ';
		
		for (a = 'A'; a<='Z'; a++) {
			System.out.print(a);
			if (a == 'E' || a == 'J' || a == 'O' || a == 'T' || a == 'Y') {
				System.out.println();
			}
		}
		System.out.println();
		
		a='A';
		while (a<='Z') {
			System.out.print(a); 
			if (a == 'E' || a == 'J' || a == 'O' || a == 'T' || a == 'Y') {
				System.out.println();
			}
			a++;
		}
		System.out.println();
		
		a='A';
		do {
			System.out.print(a); 
			if (a == 'E' || a == 'J' || a == 'O' || a == 'T' || a == 'Y') {
				System.out.println();
			}
			a++;
		} while (a<='Z');
		System.out.println();
		System.out.println("=============================");
		
		a = 'A';
		while (a<='Z') {
			System.out.print(a); 
			if(a%5==4) {
				System.out.println();
			} //줄바꿈은 5번째마다
			a++;
		}
	}// E main

}// E class
