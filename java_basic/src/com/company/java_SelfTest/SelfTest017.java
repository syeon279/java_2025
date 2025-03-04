package com.company.java_SelfTest;

public class SelfTest017 {

	public static void main(String[] args) {
		int [][] arr = new int[4][5];
		int data=1;
		for(int i =0; i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=data++;
			}
		}
		for(int i =0; i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
