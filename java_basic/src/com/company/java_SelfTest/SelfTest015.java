package com.company.java_SelfTest;

public class SelfTest015 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		int data=1;
		for(int i =0; i<arr.length;i++) {
			arr[i]=data++;
		}
		for(int i =0; i<arr.length;i++) {
			System.out.print(arr[i]+"   ");
		}
	}

}
