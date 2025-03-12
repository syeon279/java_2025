package com.company.java016;
// 1. 클래스는 부품객체			-설계도
// 2. 상태와 행위를 갖는다. 		-interface ( public static final / pubilc abstract )

interface Inter1 {
	void method();
} // E interface

class Inter1Impl implements Inter1{
	@Override
	public void method() {
		System.out.println("Hi");
	}
	
}// E class
public class Lambda001 {

	public static void main(String[] args) {
		//#1. interface - 구현객체를 만들기
		Inter1 a1 = new Inter1Impl(); a1.method();
		
		//#2. 익명이너클래스 (test목적으로, 잘 안쓰는 이벤트)
		Inter1 a2 = new Inter1() {
			@Override
			public void method() {
				System.out.println("하이");
			}
		};
		a2.method();
		
		//#3. lambda 뭐 받아서 처리 ()-> {}
		Inter1 a3 = ()-> System.out.println("Hello");
		a3.method();
	}

}
