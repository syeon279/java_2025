package com.company.java014;

import java.util.ArrayList;

//상속도
//Object     
//
//Papa 	money= 10
//
//Son   money = 150; car = 2;

class Papa{
	int money = 10;
	public Papa() {}
	public Papa(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Papa [money="+money+"]";
	}
}

class Son extends Papa{
	int money = 150;
	int car = 2;
	public Son() {
		super();
	}
	public Son(int money) {
		this.money=money;
	}
	public Son(int money, int car) {
		this.money=money; this.car=car;
	}
	@Override
	public String toString() {
		return "Son [money=" + money + ", car=" + car + "]";
	}
}

public class RepeatQ2_Q7 {
	public static void main(String[] args) {
		Papa p1 = new Papa();
		System.out.println(p1);// Papa [money=10]
		
		Son s2 = new Son(); 
		System.out.println(s2);//Son [money= 150 , car= 2]
		
//		Son s3 = new Papa(); // Papa 생성자는 자식 인스턴스를 초기화 한 적이 없음.
//		System.out.println(s3); 
		
		Papa p4 = new Son();
		System.out.println(p4); // Son [money=150, car=2]
		
		System.out.println(p4.money);//10
		
		Papa p5 = new Son(); // 1. 부모 = 자식 ; 부모는 자식을 담을 수 있다. 업 캐스팅. 
		Son s5 = (Son)p5; //// 자식 클래스가 부모클래스를 담으려면 다운캐스팅, 타입캐스팅이 필요함. 
		//조건 = 부모는 자식생성자를 호출한 적이 있어야함. 
		System.out.println(s5); //Son [money= 150 , car= 2]
		System.out.println(s5.money);//150
		System.out.println(p5.money);//10
		
		ArrayList<String> list = new ArrayList<>();
	}

}
