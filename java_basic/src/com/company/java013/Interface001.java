package com.company.java013;

//1. 클래스는 부품객체
//2. 상태와 행위
interface Animal1{
	String COMPANY = " (주) 동물농장 "; 	//static final
	void eat();		//abstract 
}
class Saram implements Animal1{
	@Override
	public void eat() {
		//System.out.println(COMPANY="해물탕 회사"); //The final field Animal1.COMPANY cannot be assigned
		System.out.println("식사");
	}
}
class Pig implements Animal1{
	@Override
	public void eat() {
		System.out.println("꿀꿀.......................");
	}
}

public class Interface001 {
	public static void main(String[] args) {
		//Animal ani = new Animal(); //Cannot instantiate the type Animal
		System.out.println( Animal1.COMPANY);
		// 하나의 자료형으로 여러 개의 타입을 관리하려고 사용 
		Animal1 [] anis = {new Saram(), new Pig(), new Pig()};
		for (Animal1 ani : anis) {
			ani.eat(); //@Override - 자식 eat 
		}
	}

}
