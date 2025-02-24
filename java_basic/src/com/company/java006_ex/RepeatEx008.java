package com.company.java006_ex;

public class RepeatEx008 {
	public static void main(String [] args) {
		// 1-10 까지 3의 배수의 합
		int i = 1, sum = 0; 
		for ( i=1; i<=10; i++ ) {
			if (i%3==0) {
				System.out.print(i!=9?i + "+":i);
				sum += i;
			}
		}
		System.out.println("=" +sum);
		System.out.println();
		
		i=1; sum=0;
		while (i<=10) {
			if (i%3==0) {
				System.out.print(i!=9?i + "+":i);
				sum += i;
			}
			i++;
		}
		System.out.println("=" +sum);
		System.out.println();
		
		i=1; sum=0;
		do {
			if (i%3==0) {
				System.out.print(i!=9?i + "+":i);
				sum += i;
			}
			i++;
		} while(i<=10);
		System.out.println("=" +sum);
		System.out.println();
		
	}
}

