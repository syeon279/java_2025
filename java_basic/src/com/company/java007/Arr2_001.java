package com.company.java007;

import java.util.Arrays;

public class Arr2_001 {

	public static void main(String[] args) {
		int [][] arr = { {1,2,3}, // 0floar  00 01 02
						 {4,5,6}  // 1f      10 11 12
						};
		System.out.println( arr );
		System.out.println( Arrays.toString(arr)); //[[I@c39f790, [I@71e7a66b]
		System.out.println( Arrays.deepToString(arr)); //[[1, 2, 3], [4, 5, 6]]
		// 눈에 보이는 대로
		System.out.print(arr[0][0]+"\t"+arr[0][1]+"\t"+arr[0][2]+"\n");
		System.out.print(arr[1][0]+"\t"+arr[1][1]+"\t"+arr[1][2]+"\n");
		// 칸정리
		System.out.println("=======칸 정리=======");
		for(int kan = 0; kan<3; kan++) {
			System.out.print(arr[0][kan]+"\t");
		}
		System.out.println();
		for(int kan = 0; kan<3; kan++) {
			System.out.print(arr[1][kan]+"\t");
		}
		System.out.println();
		// 층정리
		System.out.println("=======층 정리=======");
		for(int ch=0; ch<2; ch++) {
			for(int kan = 0; kan<3; kan++) {
				System.out.print(arr[ch][kan]+"\t");
			}
			System.out.println();
		}
	}
	
}
