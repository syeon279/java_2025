package com.company.java013;
// 일반+설계 

abstract class Animal{
	String name; int age;
	abstract void eat(); // 추상메서드가 있으면 반드시 추상클래스로 만들어줘야함.
	abstract void sleep(); // 추상메서드 {} 구현부가 없음. - 공통의 속성으로 만들어주려고, 구체적인 내용은 상속받은 클래스에서 
	abstract void poo(); // 추상화=일반화=설계 : 공통적인 속성, 행동을 뽑은 것. 
}

class Cat extends Animal{
	@Override void eat() {
		System.out.println( super.name + "고양이 냠냠");
	} 
	@Override void sleep() { 
		System.out.println(super.name + "고양이 코!");
	}  
	@Override void poo() {
		System.out.println(super.name+"고양이 시원!");
	} 
 }
class Dog extends Animal{
	@Override void eat() {
		System.out.println( super.name + "강아지 냠냠");
	} 
	@Override void sleep() { 
		System.out.println(super.name + "강아지 코!");
	}  
	@Override void poo() {
		System.out.println(super.name+"강아지 시원!");
	} // 필요없어도 생성해야함. 
}

public class Abstract001 {
	public static void main(String[] args) {
		//1. abstract class : 일반클래스 + 설계 
		//Animal ani = new Animal(); new 메모리 빌리고, 객체생성/ Animal() 초기화/ {} 구현부 없음 -> 오류남!
		//Cannot instantiate the type Animal
		Animal ani = null;
		ani = new Cat(); // 부모는 자식을 담을 수 있음, 업캐스팅, 타입캐스팅 필요없음.
		ani.name = "eaong"; ani.eat();
		
		ani = new Dog();
		ani.name="Dan"; ani.eat();
		
		//2. 사용목적
		Animal[] arr = {new Cat(), new Cat(), new Dog(), new Dog()};
		int cnt = 0;
		for (Animal a : arr) {
			a.name="ani"+ ++cnt; a.eat();
		}
	
	}
}