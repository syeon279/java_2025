package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("학번을 입력하세요 > "); String stdNum = scanner.next();
		System.out.print("국어 점수를 입력하세요 >"); int kor = scanner.nextInt();
		System.out.print("영어 점수를 입력하세요 >"); int eng = scanner.nextInt();
		System.out.print("수학 점수를 입력하세요 >"); int math = scanner.nextInt();
		
		int total = kor + eng + math;
		double avg = total/3.0;
		String result = "불합격";
		char scholarship = 'X';
		char grade = '가';
		
		if((total>=60) && (kor>=40) &&(eng>= 40) && ( math >= 40)) {
			result = "합격";
		} 
		
		if (avg >= 95) {
			scholarship = 'O';
		}
		
		if (avg>=90) {
			grade = '수';
		} else if (total >= 80) {
			grade = '우';
		} else if (total >= 70) {
			grade = '미';
		} else if (total >= 60) {
			grade = '양';
		}
		
		
		System.out.println("=========================================================================================");
		System.out.println("학번\t 국어\t 영어\t 수학\t 총점\t 평균\t 합격여부\t 레벨\t 장학생");
		System.out.println("=========================================================================================");
//		System.out.println(stdNum + "\t " + kor + "\t"+  eng + "\t" + math+ "\t" + total+ "\t" + String.format(%.2f, avg) + "\t" + result + "\t" + grade + "\t"+ scholarship);
		//
		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.2f\t %s\t %s\t %s\t",stdNum, kor, eng, math, total, avg, result,  grade, scholarship);
	}

}
