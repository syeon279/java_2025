package com.company.java_SelfTest02;
// abstract과 interface의 공통점과 차이점은?
// 공통점: 객체들간의 공통된 특성을 추출
// 차이점: interface의 추상도가 더 높고, abtract는 인스턴스 변수, 일반 메서드, 추상 메서드를 가질 수 있지만
// interface는 상수와 추상 메서드만 가질 수 있음.

interface Vehicle {
	public void run();
}

class MotorCycle implements Vehicle {
	@Override
	public void run() {
		helmet();
		System.out.println("오토바이가 달립니다.");
	}
	public void helmet() {
		System.out.println("헬멧을 착용합니다.");
	}
} // E class

class Car implements Vehicle {
	@Override
	public void run() {
		System.out.println("자동차가 달립니다.");
	}
	
}

class Driver {

	public void drive(Vehicle v) {
		v.run();
	}
	
}

public class SelfTest008_009 {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		MotorCycle MotorCycle = new MotorCycle();
		Car Car = new Car();
		
		driver.drive(Car);
		System.out.println(">> 자동차가 고장나서 교통수단을 바꿉니다!");
		
		driver.drive(MotorCycle);
	}

}
