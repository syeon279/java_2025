//2. 상태와 행위
//3. 상속 - 재활용
package com.company.java012_;

class A1 extends Object {
	int a;
	public A1() {
		super();
	} //생략된 코드 
}

class B1 extends A1 {
	int b;
	public B1() {
		super();
	}
}

class C1 extends B1 {
	int c;
	public C1() {
		super();
	}
	public void show() {
		System.out.println(a + "\t" + b + "\t" + c + "\t");
	}
}

public class Extends001 {
	public static void main(String[] args) {
		C1 c1 = new C1();
		c1.a=10; c1.b=20; c1.c=30; c1.show();
		
	}

}
/*
 ---------------------------------------
 [method] A1.class, B1.class, C1.class, public Extends001.class #1
 ---------------------------------------
 [heap]					| [stack]
         Object(){#3-4    }#3-5 Object 틀 사용가능
     {a=0} A1(){ #3-3     }#3-6 a=0으로 초기화
     {b=0} B1(){ #3-2     }#3-7 b=0으로 초기화
 1번지{c=0} C1(){ #3-1     }#3-8 c=0으로 초기화   - 인스턴스 변수를 초기화해 사용가능
 				       <- c1 1번지
 						|	main #2
 ---------------------------------------
*/
