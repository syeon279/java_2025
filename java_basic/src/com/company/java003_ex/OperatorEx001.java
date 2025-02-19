package com.company.java003_ex;

public class OperatorEx001 {

	public static void main(String[] args) {
		int a=3, b=10;
		System.out.println( b+=10 - a--); // 10-3 = 7, a=2, b=17 
		System.out.println(a += 5); //a=7
		System.out.println(a>=10 || a<0 && a>3); // false
	}

}
