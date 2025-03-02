package com.company.java010;

class Farm {
	String name; // 인스턴스 변수 - heap area new랑 관련이 있음. this.name 과 관련이 있음. 
	int age;
	static String FarmName="(주)동물농장"; // 클래스 변수, method area
	static int num = 10; // 클래스 변수 
	static void num_plus() { // 클래스 함수
		num++; 
//		this.age++; Cannot use this in a static context
//		age++; Cannot make a static reference to the non-static field age
	}
	void show() {
		System.out.println("\n\n::::::::::::::::::::::::::::::::::::::::");		
		System.out.println(":::회사명 : " + FarmName);
		System.out.println(":::식구 수 : " + num); 
		System.out.println(":::이름 : " + this.name);
		System.out.println(":::나이 : " + this.age);
	}
}

public class Class005 {

	public static void main(String[] args) {
		System.out.println("Step1. 클래스 변수 - static");
		System.out.println("회사명  > " + Farm.FarmName); Farm.num_plus();
		System.out.println("식구 수 > " + Farm.num);
//		System.out.println("인스턴스 이름 > " + Farm.name); // 사용할 수 없음. 아직 객체생성이 안됐음 
		
		System.out.println("\n\nStep2. 인스턴스 변수 - this - 각각");
		Farm cat = new Farm(); cat.name = "Sally"; cat.age= 10; cat.show();
		Farm dog = new Farm(); dog.name = "Dan"; dog.age = 4; dog.show();
		
	}

}//E class
//--------------------------------------------------------------- runtime 
//[method]
// #1. Farm.class/ Class005.class/ FarmName, Farm.num, Farm.num_plus()
//---------------------------------------------------------------
//[heap]               | [stack]
//---------------------------------------------------------------
