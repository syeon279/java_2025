package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx002 {

	public static void main(String[] args) {
		int kor, eng, math, total; double avg; // 평균이 90점대이면 레벨 9, 80점대이면 8, ...;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어점수:  "); kor = scanner.nextInt();
		System.out.print("영어점수:  "); eng = scanner.nextInt();
		System.out.print("수학점수:  "); math = scanner.nextInt();
		total = kor + eng + math;
		avg = total/3.0;
		byte level = (byte)(avg/10);
		
//		System.out.printf("총점: %d \t 평균: %.2f\t 레벨: %d\n", total, avg, level);
		
		System.out.println("============================================\n::GOOD IT SCORE::\n============================================");
		System.out.printf("국어 \t 영어 \t 수학 \t 총점 \t 평균 \t 레벨\n%d \t %d \t %d \t %d \t %.2f \t %d ", kor, eng, math, total, avg, level);
	}

}
