package com.company.java015_ex;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx002 {

	public static void main(String[] args) {
		ArrayList<String> numbers = new ArrayList();
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		
		Scanner scanner = new Scanner(System.in); String result = "다시 입력하세요.";
		System.out.println("입력> "); int num = scanner.nextInt();
//		switch(num){
//		case 1 :  result = numbers.get(0); break;
//		case 2 :  result = numbers.get(1); break;
//		case 3 :  result = numbers.get(2);
//		}
//		
//		System.out.println(result);
//		
		for(int i = 0; i<3; i++) {
			if(num==i) {
				System.out.println(numbers.get(num-1)); break;
			}
		}
//		System.out.println(numbers.get(num-1));
	}

}
