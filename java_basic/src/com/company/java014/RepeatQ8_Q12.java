package com.company.java014;
//Q8 오버로딩과 오버라이딩 = 오버로딩은 같은 이름의 메서드를 알규먼트 //파라미터//의 타입과 개수만 다르게하여 생성, 
//비슷한 기능
//오버라이딩은 상속시 부모의 메서드를 자식 클래스에 맞게 수정해서 사용.

//Q9 abstract란? = 추상화, 식체화 된 객체들 간의 공통된 특성을 추출한 것
//Q10 interface란? = 상속 추상도가 더 높음. 설계와 구현을 분리하기 위해서. 
//Q11 abstract는 인스턴스 변수, 일반 메서드, 추상메서드를 모두 가질 수 있지만 interface는 상수와 추상 메서드만.
// 공통점 : 자식클래스를 통해서 설계 부분을 구현함. 
abstract class Fruit {
	@Override
	public String toString() {
		return "Fruit";
	}
	public abstract void myfruit();
}

class Apple extends Fruit{
	@Override
	public void myfruit() {
		System.out.println("사과는 빨갛다.");
	}
}

class Banana extends Fruit{
	@Override
	public void myfruit() {
		System.out.println("바나나는 노랗다.");
	}
}

class Coconut extends Fruit{
	@Override
	public void myfruit() {
		System.out.println("코코넛은 코코하다.");
	}
}

public class RepeatQ8_Q12 {
	public static void main(String[] args) {
		Fruit [] fruits = {new Apple(), new Banana(), new Coconut()};
		for(Fruit fru : fruits) {
			fru.myfruit();
		}
	}

}
