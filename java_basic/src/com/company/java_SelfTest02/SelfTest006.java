package com.company.java_SelfTest02;

class A1 extends Object{
	int a;
	public A1() {
		super();
	}
	public A1(int a) {
		super();
		this.a = a;
	}
}

class B1 extends A1{
	int b;
	
	public B1() {
		super();
	}

	public B1(int b) {
		super();
		this.b = b;
	}
	
	public B1(int a, int b) {
		super(a);
		this.b = b;
	}
	
}

class C1 extends B1 {
	int c;
	public void show() {
		System.out.println("상속받은 A 클래스의 a : " + a);
		System.out.println("상속받은 B 클래스의 b : " + b);
		System.out.println("상속받은 C 클래스의 c : " + c);
	}
}

public class SelfTest006 {

	public static void main(String[] args) {
		C1 myc = new C1();
		myc.a = 10; myc.b=20; myc.c=30; myc.show();
	}

}
// 클래스를 상속하는 이유: 코드의 중복을 제거하고 재사용하기 위해
// 상속의 형식: class 자식 클래스 extends 부모클래스