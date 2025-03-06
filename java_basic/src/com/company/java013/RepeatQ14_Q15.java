package com.company.java013;
class Parent{
	int i, j;
	public Parent() {
		super(); // 1. Object
	 }
	public Parent(int i, int j) {
		super(); // 2. Object
		this.i = i;
		this.j = j;
	}
}
class Child extends Parent {
	int k;
	public Child() {
		super(); // 3. Parent()
	}
	public Child(int i, int j, int k) {
		super(i,j); //4.Parent(int i, int j)
		this.k = k;
		
	}
}
public class RepeatQ14_Q15 {

	public static void main(String[] args) {
		Child child = new Child(10,20,30);
		System.out.println(child.i); 
		System.out.println(child.j);
		System.out.println(child.k);
	}

}
// Q14 메서드 재정의: 상속시 부모 메서드와 같은 메서드를 오버라이딩이라고 한다. 