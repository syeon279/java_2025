package com.company.java005_ex;

public class ForEx004 {

	public static void main(String[] args) {
		int countOf3 = 0;
		int i;
		String numOf3 = "3의 배수인 숫자는: ";
		for(i=1; i<=10; i++) {
			if (i%3==0) {
				countOf3 += 1; //countOf3++도 가능
				if(i==3) {
					numOf3 += i;					
				} else {
					numOf3 += ", " + (i);		
				}
			}
		}
		//삼항 연산자 사용
		System.out.print("3의 배수인 수는: ");
		for(i=1; i<=10; i++) {
			if (i%3==0) {
				System.out.print((i==3)? i : ", " + i);
			}
		}
		System.out.println();
		// 출력
		System.out.println(numOf3);
		System.out.println("3의 배수인 숫자의 수는 " + countOf3 + " 입니다.");
	}

} 
