package com.conpany.java005_ex;

public class ForEx005 {

	public static void main(String[] args) {
		int count = 0;
		int cnt = 0;
		for (char ch='a'; ch <= 'z'; ch++) {
			switch(ch) {
			case 'a' : count += 1; break;
			case 'e' : count += 1; break;
			case 'i' : count += 1; break;
			case 'o' : count += 1; break;
			case 'u' : count += 1;
			}
		} 
		
		for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
			if( ch1 =='a'|| ch1 =='e' || ch1 =='i' || ch1 =='o' || ch1 =='u'){cnt++;}
		}
		
		System.out.println("총 모음의 수는 " + count +" 입니다.");
		System.out.println("총 모음의 수는 " + cnt +" 입니다.");
	}

}
