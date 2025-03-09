package com.company.java013;

abstract class Shape002{
	abstract void showArea(int w, int h);
	
	abstract void showArea(int r);
}

class Rectangle002 extends Shape002 {
 @Override void showArea(int w, int h) { 
	 System.out.println("사각형의 넓이: "+w*h);
 }
 @Override void showArea(int r) { } 
}

class Circle002 extends Shape002{
	double pi = 3.141592;
	@Override
	void showArea(int w, int h) {}
	@Override
	void showArea(int r) {
		System.out.println("원의 넓이: "+(r*r*pi));
	}
}

class Triangle002 extends Shape002{
	@Override
	void showArea(int w, int h) {
		System.out.println("삼각형의 넓이: "+w*h/2);
	}
	@Override
	void showArea(int r) {}
}

public class Abstract002 {
	public static void main(String[] args) {
		Rectangle002 rec= new Rectangle002();
		rec.showArea(10, 10);
		Triangle002 tri = new Triangle002();
		tri.showArea(10, 10);
		Circle002 cir = new Circle002();
		cir.showArea(10);
		
		Shape002 shape2 = null;
		Shape002 [] s = {new Rectangle002(), new Circle002(), new Triangle002()} ;
		//intstaceof - 객체가 어떤 클래스인지 어떤 ㅋ르래스를 상속받았었는지 확인
		if ( s[0] instanceof Circle002) {
			s[0].showArea(10);
		} else {
			s[0].showArea(10, 3);
		}
		if ( s[1] instanceof Circle002) {
			s[1].showArea(10);
		} else {
			s[1].showArea(10, 3);
		}
		if ( s[2] instanceof Circle002) {
			s[2].showArea(10);
		} else {
			s[2].showArea(10, 3);
		}
		
		
	}

}
