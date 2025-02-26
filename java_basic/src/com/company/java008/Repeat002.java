package com.company.java008;

public class Repeat002 {

	public static void main(String[] args) {
		for(int i = 1; i<4; i++) {
			System.out.println(i*100);
		}
		int i= 1;
		while (i<4) {
			System.out.println(i*100); i++;
		} 
		
		i=1;
		do {
			System.out.println(i*100); i++;
		} while(i<4);
	}

}
