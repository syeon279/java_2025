package com.company.java011;
//final 변경하지마

//final class 상속받지마
class FinalEx extends Object{ // Object - 자바팀이 객체툴로 만들어놓음. 2. extends 상속(앞에 객체 그대로 사용)
	//static String tree="4-5"; // 3-1. 식목일 - 나무심는 날 기념일
	final static String tree ="4-5";
	String name;
	void show() {
		System.out.println(FinalEx.tree + "/"+ name);
	}
}
class MyDate extends FinalEx{
	@Override
	void show() {
		super.show(); //5. 오버라이드 자식클래스에서 메서드 재수정
	}
}
public class Final001 {
	public static void main(String[] args) {
//		FinalEx.tree = "4-6";//3-2 static 공용 아래에서 변경가능 
								//3-4 final 변경이 안되는 값 - cannot be assigned
		System.out.println("식목일-나무심는 날, 기념일(공유, 변경 안돼는 값) >" + FinalEx.tree);
		FinalEx finalEx = new FinalEx();
		finalEx.show();
	}

}
