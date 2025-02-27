package com.company.java009;

public class Repeat005 {

	public static void main(String[] args) {
		char[][] arr = new char[2][3];
		char data = 'a';
		for(int i=0; i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=data++; 
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
