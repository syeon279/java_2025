package com.company.java012_;
/*

	Object						
	  ↑						   
	TestA4    int a / toString
	  ↑
	TestB4    int b / toString 

*/
class TestA4 extends Object {
	int a = 10;
	@Override public String toString() {
	return "TestA4 [a=" + a + "]";
	}
}

class TestB4 extends TestA4{
	int b=20;

	@Override public String toString() {
	return "TestB4 [b=" + b + "]";
	}
}

public class Poly004 {
	public static void main(String[] args) {
		TestA4 ta              = new TestA4();
		// 1. int a / toString = int a / toString
		TestB4 tb                                  = new TestB4();
		// 2. int b / toString -- int a / toString = int b / toString -- int a / ------
		ta = new TestB4(); // 5. b를 초기화 추가. 부모는 자식을 담은 적이 있어야한다. < 다운캐스팅 시 필요함. 
		//tb = ta; //Type mismatch: cannot convert from TestA4 to TestB4
		tb = (TestB4)ta; //4. 자식 = 부모 / 다운캐스팅 / 타입캐스팅 필요
		//3. int b / toString -- int a / toString =  -- int a / ------
		// ta의 메모리는 int a / toString 만족 int b 는 생성자 호출해서 초기화 한 적이 없음.
		System.out.println(tb); // 오류남
	}

}
