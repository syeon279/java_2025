package com.company.java014;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception003 {
	
	public static int nextInt() throws InputMismatchException {
		int a = -1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 입력: "); 
		a = scanner.nextInt(); // 숫자 입력받기를 기다림. //2. 'a'
		return a;
	}
	
	public static void main(String[] args) /*throws Exception*/ {
		while(true) {
			int a = -1;
		try {
			a=nextInt();
			if (a==1) {break;}
		} catch(Exception e) {
			System.out.println("오류!");
		}
		}
	}

}
// 1. mian 안에서 


//2. method
//Exception in thread "main" java.util.InputMismatchException
//at java.base/java.util.Scanner.throwFor(Scanner.java:964)
//at java.base/java.util.Scanner.next(Scanner.java:1619)
//at java.base/java.util.Scanner.nextInt(Scanner.java:2284)
//at java.base/java.util.Scanner.nextInt(Scanner.java:2238)
//at com.company.java014.Exception003.nextInt(Exception003.java:11) ## 발생한 지점 
//at com.company.java014.Exception003.main(Exception003.java:17) ## 호출한 애