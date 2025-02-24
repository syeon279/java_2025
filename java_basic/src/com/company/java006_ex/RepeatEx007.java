package com.company.java006_ex;

public class RepeatEx007 {

	public static void main(String[] args) {
		// 1,2,3,4,5
		int i = 1;
		for (i=1;i<=5;i++ ) {
			System.out.print(i + "\t");
		}
		System.out.println();
		i = 1;
		while (i<=5) {
			System.out.print(i + "\t"); i++;
		}
		System.out.println();
		i = 1;
		do {
			System.out.print(i + "\t"); i++;
		} while (i<=5);
		System.out.println();
		
		
		// 5 4 3 2 1 
		for (i = 5; i>=1;i--) {
			System.out.print(i + "\t");
		}
		i=5;
		System.out.println();
		while (i>=1) {
			System.out.print(i + "\t"); i--;
		}
		System.out.println();
		
		i=5;
		do { 
			System.out.print(i + "\t"); i--;
		} while(i>=1);
		System.out.println();
		
		// java
		for (i=1;i<=3;i++) {
			System.out.print("java"+i+"\t");
		}
		System.out.println();
		i=1;
		while ( i<=3) {
			System.out.print("java"+i+"\t"); i++;
		}
		System.out.println();
		i=1;
		do {
			System.out.print("java"+i+"\t"); i++;
		} while (i<=3);
	} 
	
}
