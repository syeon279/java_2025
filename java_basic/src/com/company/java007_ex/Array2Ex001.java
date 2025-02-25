package com.company.java007_ex;

public class Array2Ex001 {

	public static void main(String[] args) {
		int[][] arr2 = {{100,200,300},{400,500,600}};
		
		for (int i=0; i<arr2.length;i++) {
			for (int j =0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
