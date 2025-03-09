package com.company.java014;

//Q13 다음코드에서 오류나는 부분을 체크
interface Animal{
	String NAME = "홍길동"; //1. public static final 
	void eat();            // 2. public abstract 
}

class Saram implements Animal{
	@Override public void eat() {
		//NAME = "아이유"; // 상수는 바꿀수 없음
		System.out.println(NAME + "이 밥을 먹어요.");
	}
}

public class RepeatQ13 {
	public static void main(String[] args) {
		//Animal ani = new Animal(); // interface는 구현부가 없어서 객체 생성이 안됨.
		Animal ani = null; //???
		ani = new Saram(); ani.eat();
	}

}
