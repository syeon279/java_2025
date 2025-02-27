package com.company.java009;

public class Method006_String_equals {

	public static void main(String[] args) {
		String str1 = "apple";
		String str2 = "apple";
		String str3 = new String("apple"); 
		
		System.out.println("Step1. 값 출력: " + str1 +"  " + str2 + " " + str3);
		System.out.println("Step2. 값 같은지 확인: "  +"  " +(str1 == str2)+"  " + (str1 == str3)); //true false
		
		System.out.println("Step3. 주소값 확인: " +
				System.identityHashCode(str1) + " "+ //866191240
				System.identityHashCode(str2) + " "+ //866191240 같은 메모리를 사용함.
				System.identityHashCode(str3)  //1879492184
				);
		
		System.out.println("Step4. 문자열의 값 비교: " +
				str1.equals(str2)+"  " + str1.equals(str3)); // true true
	}

}
