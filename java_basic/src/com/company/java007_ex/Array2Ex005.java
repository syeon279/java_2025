package com.company.java007_ex;

import java.util.Arrays;

public class Array2Ex005 {

	public static void main(String[] args) {
		int[][]arr = new int[4][3];
		int data = 1;
		int total = 0; double avg= 0.0;
		for (int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				arr[i][j] = data;
				System.out.print(arr[i][j] + "\t");
				total += arr[i][j];
			}
			System.out.println();
			data++;
		}
		avg = (double)total/(arr.length*arr[0].length);
//		System.out.println(Arrays.deepToString(arr));
		System.out.println("총점: "+total);
		System.out.printf("평균: %.1f", avg);

	}// E main
}