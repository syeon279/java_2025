package com.company.java002_ex;

import java.util.Scanner;

public class DataTypeEx003 {

	public static void main(String[] args) {
		double pi;
		Scanner scanner = new Scanner (System.in);
		System.out.print("파이를 입력하시오: ");
		pi = scanner.nextDouble();
		System.out.println("파이 값은 " + pi + "입니다.");
		
		float pie;
		System.out.print("파이를 입력하시오: ");
		pie = scanner.nextFloat();
		System.out.println("파이 값은 " + pi + "입니다.");
	}

}
