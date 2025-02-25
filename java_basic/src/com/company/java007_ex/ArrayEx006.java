package com.company.java007_ex;

import java.util.Arrays;

public class ArrayEx006 {

	public static void main(String[] args) {
		double [] arr = new double[5];
		double data = 1.1;
		for( int i = 0; i<arr.length;i++) {
			arr[i] = data; data += 0.1;	
			System.out.println(String.format("%.1f", arr[i]));
		}
		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(String.format("%.2f", arr)));
	}

}
