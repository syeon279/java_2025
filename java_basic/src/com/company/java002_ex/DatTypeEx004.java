package com.company.java002_ex;

import java.util.Scanner;

public class DatTypeEx004 {

	public static void main(String[] args) {
		int koreanScore;
		int englishScore;
		int mathScore;
		// int kor, eng, math, total; double avg; 연결해서 선언
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수는? : "); koreanScore = scanner.nextInt();
		System.out.print("영어 점수는? : "); englishScore = scanner.nextInt();
		System.out.print("수학 점수는? : "); mathScore = scanner.nextInt();
		
		int    calcScore = koreanScore + englishScore + mathScore;
		double averageScore = calcScore/3.0; // 정수 나누기 정수라 double로 담아도 정수가 됨. 둘 중 하나를 실수로
		float averageScore1 = calcScore/3f;
		
		System.out.printf("총점은 %d 입니다.\n", calcScore);
//		System.out.printf("평균은 %f 입니다.\n", (koreanScore + englishScore + mathScore)/3);
		System.out.println("평균은 "+ (koreanScore + englishScore + mathScore)/3 + "입니다.");
		System.out.println("평균은 "+ averageScore + "입니다.");
		System.out.println("평균은 "+ averageScore1 + "입니다.");
		System.out.printf("평균은 %.2f 입니다.\n" , (float)averageScore1);
		System.out.printf("평균은 %.2f 입니다.\n" , (double)averageScore1);
		System.out.printf("평균은 %.2f 입니다.\n" , (float)(koreanScore + englishScore + mathScore)/3);
		System.out.printf("평균은 %.2f 입니다.\n" , (double)(koreanScore + englishScore + mathScore)/3);
		
	}

}
