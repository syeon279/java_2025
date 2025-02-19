package com.company.java003;

import java.util.Scanner;

public class Operator001 {

	public static void main(String[] args) {
		// 먼저 값을 구하고 비교조건 후 대입한다. 
		// 값
		int a = 10, b = 3;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b); //몫
		System.out.println(a % b); // 나머지
		
		
		//Q1. 나머지 연산자 - 짝수? 홀수? 
		System.out.println(0%2 + " " + 1%2 + " " + 2%2);
		Scanner scanner = new Scanner(System.in);
//		System.out.print("숫자 입력> "); int i = scanner.nextInt();
//		String result = i%2 ==0 ? "짝수" : "홀수";
//		System.out.printf("입력하신 숫자는 '%s' 입니다.\n",result);
		
		// 2. 비교 ( ==,!=, <, >, <=, >=)
		System.out.println(10>3); //true
		System.out.println(10<3); //false
		// a=10 a가 짝수니?
		System.out.println( a%2==0 ); // 짝수 표현 true
		System.out.println( a%2==1 ); // 홀수 표현 false
		// b가 3의 배수니?
		System.out.println( b%3==0 ); 
		//3. 조건( &  &&(모든 조건 만족시)  |  ||(조건 하나만 만족시)  )
//		System.out.println(true & true); //true
//		System.out.println(true && true); //true 모든 조건 만족시 
		System.out.println(false & true);  //& = 처음도 false 뒤에 조건 까지 읽음. 
		System.out.println(false && true); // true 코드는 읽지 않음. 
		System.out.println( true & false);  
		System.out.println( true && false); 
		System.out.println("=================");
		System.out.println(true | true);
		System.out.println(true || true);
		System.out.println(false | true);  // 
		System.out.println(false || true); // 
		
		//4. (조건)? 참:거짓
		System.out.println( (a>b)? " a>b": "a<b ");
		System.out.println( (3%2==0)? "짝수": "홀수");
		
		//q1) 2의 배수이면서 5의 배수라면 true / false
		System.out.println((a%2==0)&&(a%5==0));
		//q2) 2의 배수이거나 3의 배수라면 true / false
		System.out.println((a%2==0)||(a%3==0));
		//q3) 숫자를 입력받아  0보다크면 양수, 0보다 작으면 음수, 아니라면 0 
		System.out.print("숫자 입력> "); int q3 = scanner.nextInt();
		System.out.println((q3>0)? "양수":(q3<0)? "음수" : 0);
		System.out.printf("입력하신 숫자는 '%s'입니다.\n", (q3>0)? "양수":(q3<0)? "음수" : 0);
		
		// 5. 대입
		a = 10; 
		System.out.println( a+=b ); // 1. a+b  2. a = 1번의 결과
		System.out.println( a-=b ); 
		System.out.println( a*=b );
		System.out.println( a/=b );
		System.out.println( a%=b );
		System.out.println( "-----------" );
		
		//6. 단항 ++ --
		int a1=1, b1=1, c1=1, d1=1;
		System.out.println( ++a1 ); // a1을 먼저 증가한 후 대입 출력 2
		System.out.println( a1 ); //2
		
		System.out.println( b1++ ); //b1 출력한 후 증가 후 대입 1
		System.out.println( b1 ); // 2
		
		System.out.println( --c1 ); // 증감 후 대입, 출력 0
		System.out.println( c1 ); //0
		
		System.out.println( d1-- ); // 출력 후 증감 후 대입 1
		System.out.println( d1 ); //0
		
		
	}

}
