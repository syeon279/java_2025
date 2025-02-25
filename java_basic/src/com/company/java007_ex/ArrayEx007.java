package com.company.java007_ex;

import java.util.Arrays;

public class ArrayEx007 {

	public static void main(String[] args) {
		char[] arr = new char[5];
		char data = 'A';
		for (int i = 0; i<arr.length;i++) {
			arr[i] = data++; // 데이터를 대입하고 증가
		}
		System.out.println(Arrays.toString(arr));
	}

}
