package com.company.java_SelfTest02;

class Sawon005{
	int pay = 10000;
	static int su = 10;
//	static int basicpay = pay; //스태틱에서는 인스턴스 변수 사용불가!
	static int basicpay2;
	static {
		basicpay2 = 20000;
	}
	
	public static void showSu() {
		System.out.println(su);
	}
	
	public static void showPay() {
//		System.out.println(this.pay); //스태틱에서는 인스턴스 변수 사용불가!
	}
	
	public void showAll001() {
		System.out.println(su);
		System.out.println(this.pay);
	}

	public static void showAll002() {
//		showAll001(); 
//		System.out.println(this.pay); //스태틱에서는 인스턴스 변수 사용불가!
	}
}

public class SelfTest003 {
	public static void main(String[] args) {
		Sawon005 sola = new Sawon005();
		sola.showAll001();
	}

}
