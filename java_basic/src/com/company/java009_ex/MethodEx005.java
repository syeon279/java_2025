package com.company.java009_ex;

public class MethodEx005 {
	public static int add(int x, int y) {
		return x+y;
	}
	////////////////////////////////////////
	public static int add(int x, short y) {
		return x+y;
	}
//	public static long add(int x, int y) { // 처음 선언한 메서드와 파라미터 자료형이 같음
//		return x+y;
//	}
	public static long add(long x, long y) {
		return x+y;
	}
	//////////////////////////////////////////
	public static void main(String[] args) {
		// 메서드 오버로딩: 이름이 같고, 파라미터가 다름
	}

}
