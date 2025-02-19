package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {

	public static void main(String[] args) {
		int num1, num2; double numOp;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자: "); num1 = scanner.nextInt();
		System.out.print("두 번째 숫자: "); num2 = scanner.nextInt();
		
		numOp = (double)num1 / (double)num2;
		System.out.printf("%.2f\n",numOp);
		System.out.println(num1 + " / " + num2 + " = " + String.format("%.2f", numOp)); //Sring.format("출력서식", 처리할 값)
	}

}
