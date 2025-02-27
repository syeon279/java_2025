package com.company.java008;

public class Method003 {
	public static String sign() {
		return "sally";
	}
	public static int num() {
		return (int) (Math.random()*45); //0~44
	};
	public static double pie() {
		return 3.141692;
	}
	public static String hello(String name) {
		return "안녕, "+name;
//		System.out.println("안녕, "+ name);
	}
	//////////////////////////////////////
	public static void main(String[] args) {
		//public static 리턴값 메서드명(파라미터) {}
		System.out.println("당신의 이름은?   " + sign());
		//					당신의 이름은?	  sally 
		
		int yournum = num();
		System.out.println("랜덤 숫자: " + yournum);
		
		System.out.println("파이값?  " + pie());
		
		System.out.println(hello("Sally"));
		System.out.println(hello("alpha"));
		System.out.println(hello("단"));
		
	}

}// E class
