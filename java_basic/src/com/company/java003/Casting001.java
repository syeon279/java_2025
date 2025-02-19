package com.company.java003;

public class Casting001 {
	public static void main(String [] args) {
		// 1. 형 변환 - 자동 타입변환
		byte by = 1;
		short sh = 2;
		int in = 4;
		long l = 8L;
		float f = 3.14f;
		double d = 3.14;
		
		sh = by; // 정수(2byte) - 정수(1byte)
		in = by; // 정수(4byte) - 정수(1byte)
		l = by;  // 정수(8byte) - 정수(1byte)
		
		//l = f; // 정수(8byte) - 실수(4byte)  Type mismatch: cannot convert from float to long
		f = l; // 실수(4byte) - 정수(8byte) 
		
		boolean bl = true;
		// in = bl; 형변환 안됨.
		
		
		// 2. 형 변환 - 강제 타입변환
		by = (byte) in; //정수(1byte) - 정수(4byte)
		
		int in2 = (int)1.2; // 정수 (4byte) - 실수 double(8byte)
		float f12 = (float) 3.14111111111111; //실수(4byte)
		//float : 소수점 7자리        double 소수점 15자리 
		
		System.out.println(in2); //1
		System.out.println(f12); 
		
		//Q1) Systme.out.println ( 1.5 + 2.7 ); 결과가 3으로 나오도록
		int num = (int) 1.5 + (int) 2.7; 
		System.out.println(num); 
		
		System.out.println((int)1.5+(int)2.7); 
	}
}
