package com.company.java002;

public class DataType001 {
	public static void main(String [] args) {
		// 1. 자바의 자료형 분류 (기본형 / 참조형) 
		// 2. 기본형: 실제 값을 저장
		// 논리, 정수, 실수 
		boolean bl = true; // true/false
		System.out.println("1. 논리: " + bl);
		
		// 정수(1,2,4,8 : byte-short-int-long:L)
		byte by =1; short sh=2; int in=4; long l = 8L;
		System.out.println("2. 정수 byte-short-int-long   " + l);
		
		// 1. 연산시 +     2. i n t (기본 자료형 보다 작은 애: byte, short) 연산시 주의바람!
		short result  = (short) (by+sh);   // 1+2 
		System.out.println(result);
		
		//실수 (float / double)
		float f1=3.14f; double d=3.14;
		System.out.println("2. 실수 float - double: " + f1 + "\t" + d);
		
		System.out.println("4. 실수 > 정수 : ");
		f1 = l;
		System.out.println(f1);
		
		System.out.println("5. 정밀도");
		float fper1 = 1.0000001f;               //0 6개 +1 =7자리
		float fper2 = 1.00000001f;               //0 7개 +1 = 8자리 1.1234568
		double dper1 = 1.000000000000001;       //0 14개 +1 = 15자리
		double dper2 = 1.0000000000000001;       // 0 15개 +1 = 16자리
		System.out.println(fper1);
		System.out.println(fper2);
		System.out.println(dper1);
		System.out.println(dper2);
		double dper = 1.123456789123456;        //1.123456789 
		// float 는 7자리 보장, double 15자리 보장
		
		int a = 2>>32; //i n t-4byte - 8*4 byte -32
		int b = 2>>33; // 1 
		System.out.println(a + "\t" + b);
		
		System.out.println("6. 문자 저장시 숫지로 - 출력시 문자로");
		char ch = 'A';
		System.out.println(ch);
		System.out.println((int)ch);
	}
}
