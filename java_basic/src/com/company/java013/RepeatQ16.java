package com.company.java013;

// 상속도
/*
 *  Object
 *  
 *  Papa         int money=10000, sing() god 거짓말
 *  
 *  son2         int money = 1500, sing() 빅뱅 거짓말
 */

class Papa extends Object {
	int money = 10000; //멤버 변수
	public Papa() {
		super();
	}
	public void sing() { // 멤버 메서드
		System.out.println("GOD - 거짓말");
	}
}

class Son2 extends Papa{
	int money = 1500; // 멤버 변수
	public Son2() {
		super();
	}
	@Override
	public void sing() { // 멤버 메서드
		System.out.println("빅뱅-거짓말");
	}
	
}

public class RepeatQ16 {
	public static void main(String[] args) {
		Papa mypapa = new Son2(); //부모=자식 업캐스팅, 타입캐스팅x
		// Papa mypapa = money=10000, sing() 이거 쓸 수 있어!
		// 1번지 {money = 1500, sing() 빅뱅 거짓말}--{ money=10000, -----}
		
		// >> mypapa 1번지 {money = 1500, [sing() 빅뱅 거짓말}--{ money=10000,] -----}
		
		System.out.println(mypapa.money); //10000
		mypapa.sing();//빅뱅 거짓말
		((Papa)mypapa).sing();//빅뱅 거짓말
		System.out.println(((Son2)mypapa).money); //1500
	}

}
