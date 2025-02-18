package com.company.java002_ex;

public class VarEx002 {

	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		System.out.println(a + "+" + b + "= " +(a+b));
		System.out.println(a + "-" + b + "= " +(a-b));
		System.out.println(a + "*" + b + "= " +(a*b));
		System.out.println(a + "/" + b + "= " +(a/b));
		System.out.printf("%d + %d = %d\n", a, b, a+b);
		double a1 = 10;
		double b1 = 3;
		System.out.println(a1 + "+" + b1 + "= " +(a1+b1));
		System.out.println(a1 + "-" + b1 + "= " +(a1-b1));
		System.out.println(a1 + "*" + b1 + "= " +(a1*b1));
		System.out.println(a1 + "/" + b1 + "= " +(a1/b1));
//		System.out.printf("%.1f / %.1f = %.1f\n", a, b, a/b);
		System.out.printf("%d / %d = %f\n", a, b, a/(float)b);
	}

}
