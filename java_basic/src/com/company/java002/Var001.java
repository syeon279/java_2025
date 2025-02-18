package com.company.java002;

public class Var001 {
	public static void main(String [] args) {
		//1.  자료형 변수명 
		int a = 0;  // a [0]
		System.out.println("1: " + a);
		a = 100000;
		System.out.println("2: " + a); //변하는 숫자
		
		a = 100000 - 11000; // a [89000]
		System.out.println("3: " + a);
		
		a = a - 3000;       //  a [86000]
		System.out.println("4: " + a);
		
		//2. 변수의 범위 {여기서부터   }여기까지
		{int b =20; System.out.println(b);}
		//b=1000; // 영역을 인식할 수 없음. b cannot be resolved to a variable
		
		// 3. 변수명 작명 $_소문자7
		int $1=1;     int _2=2; //int 3abc=3;
		// int static; (x)
		System.out.println($1 + "\t" + _2);
		
	}
}
