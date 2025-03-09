package com.company.java012_;
/*
 
	Object						
  	   ↑						   
	TestA     int a / toString
	   ↑
	TestB     int b / toString 
	
*/
class TestA2 extends Object {
	int a = 10;
	@Override public String toString() {
		return "TestA2 [a=" + a + "]";
	}
}
class TestB2 extends TestA2{
	int b=20;

	@Override public String toString() {
		super.toString();
		return "TestB2 [b=" + b + "]";
	}
	
}
public class Poly002 {

	public static void main(String[] args) {
		TestA2 ta = new TestB2(); //4. 부모 = 자식 / 업캐스팅 / 타입캐스팅 필요 x 
		//1. TestA2 ta { int a/ toString }
		//2. 			TestB2 -> TestA2() -> Object()
		//  			{int b /toString} - { int a / toString }
		// 3. ta        {int b /toString} - { int a / -------- }
		System.out.println(ta); //TestB2 [b=20]
		System.out.println(ta.a);
		System.out.println(((TestB2)ta).b);
		
		System.out.println(); System.out.println();
		
		
	}

}
