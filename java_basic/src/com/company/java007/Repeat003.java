package com.company.java007;

public class Repeat003 {

	public static void main(String[] args) {
		int [] arr = {10, 20, 30};
		int i;
		for (i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("------");
		
		i=0;
		while(i<arr.length) {
			System.out.print(arr[i]+"\t"); i++;
		}
		System.out.println("------");
		
		i=0;
		do {
			System.out.print(arr[i]+"\t"); i++;
		} while(i<arr.length);
	}

}
