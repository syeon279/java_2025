package com.company.java012_;
class Grand extends Object {
	public void one() {
		System.out.println("grand : one");
	}
	public void two() {
		System.out.println("grand : two");
	}
} //E Grand
class Father extends Grand {
	public void three() {
		System.out.println("fater: three");
	}
} // E Father
class Uncle extends Grand {
	public void four() {
		System.out.println("uncle : four");
	}
	@Override public void one() {
		super.one();
		System.out.println("uncle : one");
	}
	@Override public void two() {
		super.two();
		System.out.println("uncle : two");
	}
} //E Uncle
class Aunt extends Object {
	String name = "Mimi";
	@Override public String toString() {
		return name + " 옆집 이모 클래스";
	}
}//E Aunt

public class Extends004 {

	public static void main(String[] args) {
		Father father = new Father(); father.three(); father.two(); father.one(); 
		System.out.println("====");
		Uncle uncle = new Uncle(); uncle.four(); uncle.two(); uncle.one(); //자식메서드(내꺼)가 우선 
		System.out.println("===");
		Aunt aunt = new Aunt();
		System.out.println(aunt);
	}

}
