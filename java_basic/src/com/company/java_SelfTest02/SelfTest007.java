package com.company.java_SelfTest02;

class Papa extends Object {
	int money = 10000;
	public Papa() {
		super();
	}
	
	public void sing() {
		System.out.println("GOD - 거짓말");
	}
} // E class

class Son extends Papa {
	int money = 1500;
	public Son() {
		super();
	}
	@Override
	public void sing() {
		super.sing();
		System.out.println("빅뱅 - 거짓말");
	}
	
} // E class

public class SelfTest007 {

	public static void main(String[] args) {
		Papa mypapa = new Son();
		System.out.println(mypapa.money); //10000
		mypapa.sing();// 빅뱅 - 거짓말
		
		// 1500 출력되게 하기
		System.out.println(((Son)mypapa).money);
	}

}
