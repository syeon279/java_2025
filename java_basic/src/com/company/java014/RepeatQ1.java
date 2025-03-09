package com.company.java014;
//Object     									Object(){#3        }#4 객체들
//
//Parent 	x=100; method(Parent Method);		Parent(){#2			}#5 x=100/----(오버라이드 되어서 덮어쓰게 됨)
//
//Child    x=200; method(Child Method);			1번지 child(){#1     }#6 x=200/ method

class Parent{
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
	@Override
	public String toString() {
		return "Parent [x=" + x + "]";
	}
	
}

class Child extends Parent{
	int x = 200;
	int y = 300;
	void method() {
		System.out.println("Child Method");
	}
	@Override
	public String toString() {
		return "Child [y=" + y + ", x=" + x + "]";
	}
	
}

public class RepeatQ1 {
	public static void main(String[] args) {
		Parent p = new Child(); //1. new 메모리 빌려고 객체 생성을 해줌. 2. child라는 생성자를 불러옴
		System.out.println(p); // Papa class의 x와 Child class 의 x는 각각 다른 변수. method만 같은. 오버라이드되니까
		Child c = new Child();
		System.out.println("p.x="+p.x);//100
		p.method();// child method
		// 자식 생성자 호출시 부모생성자 호출(부모인스턴스변수 청소) 
		// 같은 메서드가 있다면 자식메서들 오버라이드 
		System.out.println("c.x="+c.x);//200
		c.method();//child method
	}

}
