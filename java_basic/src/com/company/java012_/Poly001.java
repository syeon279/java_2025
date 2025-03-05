package com.company.java012_;

/*
		Object						Object	
		  ↑							  ↑
	TestA(int a)				 TestB(int b)
 
 
*/
class TestA extends Object{
	int a;
}
class TestB extends Object{
	int b;
}

public class Poly001 {

	public static void main(String[] args) {
		TestA v110 = new TestA();
		//TestB v220 = v100; //v100 cannot be resolved to a variable
		// 클래스도 자료형 ( 틀 - Object )
	}

}
