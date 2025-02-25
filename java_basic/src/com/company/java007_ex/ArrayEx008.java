package com.company.java007_ex;

public class ArrayEx008 {

	public static void main(String[] args) {
		//변수
		String[] name = {"아이언맨", "헐크", "캡틴", "토르", "호크아이"};
		int [] kor = {100, 20, 90, 70, 35};
		int [] eng = {100, 50, 95, 80, 100};
		int [] math = {100, 30, 90, 60, 100};
		int [] aver = new int[5];
		String [] pass =new String [5];
		String [] scholar = new String[5];
		int [] grade = new int [5];
		int count;
		String [] result = new String[5];
		char star = '★';
 		
		//처리
		for (int i =0; i<name.length;i++) {
			aver[i] = (kor[i] + eng[i] + math[i])/3;
		}
		for (int i =0; i<name.length;i++) {
			if (aver[i]>=60) {
				pass[i] = "합격";
			} else {
				pass[i] = "---";
			}
			if (aver[i]>= 95) {
				scholar[i] = "장학생";
			} else {
				scholar[i]="---";
			}
		}
//		for (int i =0; i<name.length;i++) {
//			if(aver[i]>=aver[0]) {
//				grade[i] = count++;
//			} else if(aver[i]>=aver[1]) {
//				grade[i] = count++;
//			} else if(aver[i]>=aver[2]) {
//				grade[i] = count++;
//			} else if(aver[i]>=aver[3]) {
//				grade[i] = count++;
//			} else if(aver[i]>=aver[4]) {
//				grade[i] = count++;
//			}
//		}
		for (int i =0; i<name.length;i++) {
			count = 1;
			for (int j =0; j<name.length;j++) {
				if(aver[i] < aver[j]) {
				count++; 
				}
			}
			grade[i]=count;
		}
		// 별찍기
//		for (int i =0; i<name.length; i++) {
//			if (aver[i]/10 >= 10) {
//				result[i] = "★★★★★★★★★★";
//			} else if (aver[i]/10 >= 90) {
//				result[i] = "★★★★★★★★★";
//			} else if (aver[i]/10 >= 70) {
//				result[i] = "★★★★★★★";
//			} else if (aver[i]/10 >= 30) {
//				result[i] = "★★★";
//			}
//		}
		for (int i =0; i<name.length; i++) {
			result[i] = "";
				for (int j = 0; j<aver[i]/10; j++) {
					result[i] += star;
				}
		}
		
		// 출력
		System.out.println("=============================================================================");
		System.out.println("이름 \t 국어 \t 영어  \t 수학  \t 평균 \t합격여부 \t 장학생 \t 등수 \t 별");
		System.out.println("=============================================================================");
		for (int i =0; i<name.length;i++) {
			System.out.println(name[i] + "\t" + kor[i] +  "\t" + eng[i] +  "\t" + math[i] +  "\t" + aver[i] + "\t" + pass[i] +  
					"\t " + scholar[i] + "\t " + grade[i] + "\t" + result[i]);
		}
//		System.out.println(Arrays.toString(name));
		
	}// E main
		
}
// 등수 평균으로 등수매기기

