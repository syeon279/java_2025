package com.company.java014;

public class Exception002 {

	public static void main(String[] args) {
		//1. try{에러날 것 같아} catch{에러내용} finally{무조건 처리. 생략가능}
		try { 
			System.out.println(10/0); //ArithmeticException
		//} catch(ArithmeticException e) {
		} catch(Exception e) {
			System.out.println("관리자한테 문의하세요.");
		} finally {
			System.out.println("무조건 실행!");
		}
		// 업캐스팅 =  부모는 자식을 담을 수 있다. 
		
		
		//2. throws 메서드 : 
		
	}

}
/*							#1. 복사 - ArithmeticException
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.company.java014.Exception002.main(Exception002.java:7) #2. 줄수 exception
*/