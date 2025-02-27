package com.company.java008_ex;

public class MethodEx002 {
	public static void test1(int a) {
		System.out.println(a);
	}
	public static void test2(double a) {
		System.out.println(String.format("%.1f", a));
	}
	public static void hap(int a,int b) {
		int sum=0;
		for(int i = a; i<=b; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
	public static void disp(int a, char ch) {
		for(int i=1; i<=a; i++) {
		System.out.print(ch);
		};
	}
	
	/////////////////////////////////
	public static void main(String[] args) {
		test1(10);    //10 출력
	    test2(1.2);   // 1.2 출력
	    hap(3,5);     // 3+4+5한값  12 출력
	    disp(7, '*');  // *******출력
	}

}
//연습문제2)  method
//패키지명 : com.company.java008_ex
//클래스명 :  MethodEx001
//다음과 같이 test1(), test2(), hap(), disp()메서드를 정의하시오.
//
//public static void main(String[] args) {
//    // public static  리턴값 메서드명(파라미터)
//    test1(10);    //10 출력
//     test2(1.2);   // 1.2 출력
//     hap(3,5);     // 3+4+5한값  12 출력
//     disp(7, '*');  // *******출력
//}