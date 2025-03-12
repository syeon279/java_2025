package com.company.java017;

class RefClass{
	void method(String str) {
		System.out.println(str);
	}
}

interface InterUsing {
	void inter(RefClass c, String str);
}

public class Lambda003_ref {
	public static void main(String[] args) {
		//#1. 익명클래스
		InterUsing a1 = new InterUsing() {
			@Override
			public void inter(RefClass c, String str) { 
				c.method(str);
			}
		};
		// RefClass c = new RefClass(), String str = "Hi ;)"
		a1.inter(new RefClass(), "Hi ;) ");
		
		//#2. 람다 ()->{}
		InterUsing a2 = (RefClass c, String str)-> {
				c.method(str);
		};
		a2.inter(new RefClass(), "Hi hi ;) ");
		
		//#3. :: 표현식 (참조)
		InterUsing a3 = RefClass::method;
		a3.inter(new RefClass(), "Hi hi hi ;) ");
		
		//#4			리턴 o,  파라미터 o
		InterBasic basic = (int a, int b)-> {return Math.max(a, b);}; // 큰 값을 확인해 줌 
		System.out.println(basic.method(10, 3));
		
		InterBasic basic2 = (a, b)-> Math.max(a, b);
		System.out.println(basic2.method(20, 30));
		
		InterBasic basic3 = Math::max;
		System.out.println(basic3.method(20, 40));
		
		//아래 식을 :: 바꾸기
		InterEx1 ex1 = str -> str.length();
		System.out.println(ex1.method("ABC"));
		
		InterEx1 ex11 = String::length;
		System.out.println(ex11.method("ABC"));
		
		InterEx2 ex2 = num -> System.out.println(num);
		ex2.method(100);
		
		InterEx2 ex21 = System.out::println;
		ex21.method(100);
		
	}// E main
	
}//E class

interface InterBasic {
	int method(int a, int b);
}

interface InterEx1 {
	int method(String str);
}

interface InterEx2 {
	void method(int num);
}
