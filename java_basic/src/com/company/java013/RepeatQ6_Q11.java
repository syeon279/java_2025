package com.company.java013;
// 변수 초기화 단계 
// 					  기본값		명시적 초기화 		초기화 블록		생성자 
// classValue 		  1) 0 		2) 20			3) 20			4)X
// instanceValue      5) 0 		6) 10			7) 10 			8) 10
class Membercall001{
	int instanceValue = 10;
	static int classValue=20;
	
	int instanceValue2 = classValue; // 인스턴스 변수(5) = 클래스 변수(1)/ 인스턴스 변수에 클래스 변수를 대입. 클래스 변수가 먼저 메모리 상에 올라감. 
//	static int classValue2 = instanceValue; // static에서는 인스턴스 변수 사용 불가
	
	static void staticMethod1() {
		System.out.println(classValue);
//		System.out.println(instanceValue); // staic에서는 인스턴스 변수 사용 불가 
		// 인스턴스 변수는 new 하고 난 다음에 메모리 할당 받고 객체 생성됨. 스태틱은 메모리 JVM로딩시 메모리 할당 받음.  
	}
	void instanceMethod1() {
		System.out.println(classValue);
		System.out.println(instanceValue);
	}
	static void staticMethod2() {
		System.out.println(classValue);
//		instanceMethod1(); // 스태틱에서는 인스턴스 메서드 사용 불가 
	}
	void instanceMethod2() { // 인스턴스메서드 
		staticMethod1();
	}
}
class Car4{
	private String color;

	@Override
	public String toString() {
		return "Car4 [color=" + color + "]";
	}

	public String getColor() { return color; }  
	public void setColor(String color) { this.color = color; } 
	
}
public class RepeatQ6_Q11 {

	public static void main(String[] args) {
		Car4 c1 = new Car4();
		c1.setColor("red");
		System.out.println(c1);
	}

}

// q7 접근제어자: private-package- protected(extends, 상속) -public  
// Q8 getters/setters
//   toString() 
// Q9 변수가 private 이기 때문에 getters/setters를 이용해야함.
// Q10 클래스를 상속하는 이유는 코드의 중복성을 줄이기 위해서이다.
// Q11 상속의 형식: class 자식 클래스 extends 부모클래스