package com.company.java005_ex;

public class ForEx001 {

	public static void main(String[] args) {
		//q1  for문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
		System.out.println("Q1. ");
		for (int i=1; i <=5 ; i++) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println();
		
		// q2  for문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1 
		System.out.println("Q2. ");
		for (int i=5; i>=1; i-- ) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println();
		
		// q3  for문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3  
		System.out.println("Q3. ");
		for (int i=1; i<=3; i++) {
			System.out.print("JAVA"+i+"\t");
		}
		System.out.println();
		System.out.println();
		
		// q4  for문을 이용해서 다음과 같이 출력하시오 :  HAPPY3   HAPPY2  HAPPY1  
		System.out.println("Q4. ");
		for (int i=3; i>=1; i--) {
			System.out.print("HAPPY"+i+"\t");
		}
		System.out.println();
		System.out.println();
		
		// q5  for문을 이용해서 다음과 같이 출력하시오 :  0,1,2  
		System.out.println("Q5. ");
		for (int i=0; i <=1 ; i++) {
			System.out.print(i+", ");
		}
		System.out.println("2");
		for (int i=0; i <=2; i++) {
			System.out.print((i==0? "" :", ")+i);
		} //삼항 연산자 사용
		System.out.println();
		System.out.println();
		
		// q6  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2, ,,,중간생략 ,,, 99  
		System.out.println("Q6. ");
		for (int i=0; i <=98 ; i++) {
			System.out.print(i+", ");
		}
		System.out.println("99");
		System.out.println();
		System.out.println();
		
		// q7  for문을 이용해서 다음과 같이 출력하시오 :   10, 9,,,,중간생략 ,,, , 1 
		System.out.println("Q7. ");
		int i;
		for (i=10; i>=2; i--) {
			System.out.print(i+", ");
		}
		System.out.println(i);
		System.out.println();
		System.out.println();
		
		// q8  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 
		System.out.println("Q8. ");
		for (i=0; i<=7; i+=2) {
			System.out.print(i+", ");
		}
		System.out.println(i);
		System.out.println();
		System.out.println();
		
		// q9  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 ,,,중간생략 ,,, 18 
		System.out.println("Q9. ");
		for (i=0; i<=17; i+=2) {
			System.out.print(i+", ");
		}
		System.out.println(i);
		
	}

}
