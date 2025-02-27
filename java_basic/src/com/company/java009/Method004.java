package com.company.java009;

import java.util.Arrays;

public class Method004 {
	public static void show(int a) {
		System.out.println(a*10);
	}
	public static void show(int a, int b, int c) {
		System.out.println(a*100 +", " + b*100+", " + c*100);
	}
	public static void main(String[] args) {
		int [] a = {1,2,3};
		
		show(a[0]); // 10
		show(a[0],a[1],a[2]); // 100,200,300 
		System.out.println("main1. 배열값: " + Arrays.toString(a));
		System.out.println("main2. 배열의 주솟값: " + System.identityHashCode(a));
		
		show(a); //call by reference
		System.out.println("main4: 배열값: " + Arrays.toString(a));
		
	}
	public static void show(int[]a) {
		System.out.println("show3. 배열의 주솟값: " + System.identityHashCode(a)) ;
		a[0]+= 10; a[1]+=10; a[2]+=10;
	}

}
