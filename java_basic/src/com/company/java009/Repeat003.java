package com.company.java009;

public class Repeat003 {

	public static void main(String[] args) {
		int [] arr = new int [3];
		int data = 100;
		for(int i =0;i<arr.length; i++) {
			arr[i]=data;
			data += 100;
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		data = 100;
		
		int i=0;
		while (i<arr.length) {
			arr[i] = data; data += 100;
			System.out.print(arr[i]+"\t"); i++;
		}
		System.out.println();
		data=100;
		i=0;
		
		do {
			arr[i] = data; data += 100;
			System.out.print(arr[i]+"\t"); i++;
		} while(i<arr.length);
		
	}

}
