package com.company.java005_ex;

public class ForEx003 {

	public static void main(String[] args) {
		int sum=0;
		int i;
		for (i=1; i<=10; i++) {
//			if (i==1) {
//				System.out.print(i);
//			} else {
//				System.out.print("+"+ i);				
//			}
			System.out.print((i==1)? i : "+" + i);
			sum += i;
		}
		System.out.println("=" + sum);
	}

}
//1+2+3+4+5+6+7+8+9+10=55