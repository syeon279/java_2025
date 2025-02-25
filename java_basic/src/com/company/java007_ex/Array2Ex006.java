package com.company.java007_ex;

import java.util.Arrays;

public class Array2Ex006 {

	public static void main(String[] args) {
		int [][] datas = new int[3][4];
		int data = 10;
		int [][] result = new int [datas.length+1][datas[0].length+1]; 
		// datas[]에 값 넣기
		for (int i=0; i<datas.length;i++) {
			for(int j=0; j<datas[i].length;j++) {
				datas[i][j] = data;
				System.out.print(datas[i][j] + "\t");
			}
			data += 10; // 10 20 30 
			System.out.println();
		}
		System.out.println("-----");
		// 1. 데이터 복사
		// 2. 가로 방향 데이터 누적
		// 3. 세로 방향 데이터 누적
		// 4. 전제 데이터 누적
		for (int i=0; i<datas.length; i++) { // 층
			for(int j=0; j<datas[i].length;j++) { //칸
				result[i][j]=datas[i][j];
				result[i][datas[i].length] += result[i][j];
				result[datas.length][j] += result[i][j];
				result[datas.length][datas[i].length] += result[i][j];
//				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
		
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length;j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
		
	}//E main 

}
