package com.company.java013;
class A11{
	int a; //1
	A11(){}
	A11(int a){
		this.a = a;
	} //2
	void show() { //3
		this.a = 11;
		System.out.println(this.a);
	}
	void classMethod() { //4
		this.a = 12;
	}
//	int show2(){ //5
//		int a; // stact 임시공간 변수 초기하가 안됨. 주의 
//		return a;
	}
//}

public class RepeatQ1_Q5 {

	public static void main(String[] args) {
		A11 a1 = new A11(); //지역변수 = a1 stact 영역
	}

}

// Q1. 1 - 클래스 변수; 2-지역변수 - stact area ; 3-인스턴스 메서드-heap; 4- 클래스메서드-method; 5-인스턴스 메서드
// Q2. 스태틱 함수에서는 인스턴스 함수 사용이 불가능하다. static을 지운다.
// Q3. new;A11();a1
// Q4. 생성자 오버로딩, 상속할때 기본생성자가 없으면 오류남.
// Q5. c,d
