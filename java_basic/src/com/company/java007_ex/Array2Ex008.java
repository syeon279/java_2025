package com.company.java007_ex;

public class Array2Ex008 {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		int data = 1;
		for(int i=0;i<arr.length;i++) {
			for(int j =0; j<arr[i].length;j++) {
				arr[i][j] = data++;
				System.out.print(arr[i][j]+"\t");
			}
			data=1;
			System.out.println();
		}
	}

}
