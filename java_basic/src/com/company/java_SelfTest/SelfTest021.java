package com.company.java_SelfTest;

public class SelfTest021 {

	public static void main(String[] args) {
		print(3,5);
		print(1.2,3.4);
	}

	public static void print(double d, double e) {
		System.out.println(String.format("%.1f",(d+e)));
	}

	public static void print(int i, int j) {
		System.out.println(i+j);
	}

}
