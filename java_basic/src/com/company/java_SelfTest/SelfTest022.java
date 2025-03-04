package com.company.java_SelfTest;

import java.util.Scanner;

public class SelfTest022 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String choice, result = "다시 입력하세요.";
		System.out.println("오버로딩 or 오버라이딩 > "); choice = scanner.next();
		if(choice.equals("오버로딩")){
			result = "같은 이름의 메서드를 여러개 정의하는 것"; 
		} else if(choice.equals("오버라이딩")) {
			result = "부모클래스의 메서드를 자식클래스에서 재정의하는 것"; 
		}
		System.out.println(result);
	}
}
