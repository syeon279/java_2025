package com.company.java012_;
/*

	Object						
   	  ↑						   
	TestA3    int a / toString
   	  ↑
	TestB3    int b / toString 

*/
class TestA3 extends Object {
	int a = 10;
	@Override public String toString() {
		return "TestA3 [a=" + a + "]";
	}
}
class TestB3 extends TestA3{
	int b=20;

	@Override public String toString() {
		super.toString();
		return "TestB3 [b=" + b + "]";
	}
	
}
public class Poly003 {

	public static void main(String[] args) {
//		TestB3 tb = (TestB3) new TestA3();// 4. 자식 = 부모 / 다운캐스팅/티입캐스팅 필요함.
		//1. TestB3 tb 범위    =       TestB3{int b / toString } -- TestA3{int a / -----}
		//2. TestA3()는 int a만 처리 				X                  TestA3(){int a/ toString} 
		//3. TestB3{int b / toString } 보장안됨. 
		//Exception in thread "main" java.lang.ClassCastException:
	}

}
