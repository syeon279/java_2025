package com.company.java009;

public class Repeat004 {

	public static void main(String[] args) {
		char [] arr = new char[3]; //char는 저장시 숫자로 출력시 문자로.
		char data = 'a';
		for (int i=0; i<arr.length;i++) {
			arr[i] = data; data++;
			System.out.print(arr[i]=='c'?arr[i]:arr[i]+", ");
		}
	}

}
