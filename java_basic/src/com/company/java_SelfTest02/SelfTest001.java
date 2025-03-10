package com.company.java_SelfTest02;

class Coffee012 {
	String name; int price, num;
	
	Coffee012 () {
		name = "아메리카노";
		num = 1;
		price = 2000;
	}
	
	Coffee012(String name, int num, int price){
		this.name=name; this.num=num; this.price= price;
	}
	
	void show() {
		System.out.println(":::::::::::::::::::::");
		System.out.println("주문한 커피: " + name);
		System.out.println("주문 수 : " + num);
		System.out.println("주문 금액 : " + num*price);
		System.out.println(":::::::::::::::::::::");
	}
} // E class

public class SelfTest001 {
	public static void main(String[] args) {
		Coffee012 a1 = new Coffee012("카페라떼", 2, 4000);
		a1.show();
		Coffee012 a2 = new Coffee012();
		a2.show();
	} // E main

} // E class
