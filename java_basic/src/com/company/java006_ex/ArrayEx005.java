package com.company.java006_ex;

import java.util.Arrays;

public class ArrayEx005 {

	public static void main(String[] args) {
		char[] ch = {'B', 'a','n','a','n','a'}; 
		int countSmall=0, countBig=0;
		
		for (int i = 0; i<ch.length;i++) {
			if(ch[i]>='a' && ch[i]<='z') {
				countSmall++;
				char s2 = ch[i];
				System.out.print((char)(s2-32));
			} else if(ch[i]>='A' && ch[i]<='Z') {
				countBig++;
				char b2 = ch[i];
				System.out.print((char)(b2+32));
			}

	}
		System.out.println("\n소문자의 수: "+countSmall);
		System.out.println("대문자의 수: "+countBig);
		System.out.println(Arrays.toString(ch));
	}
}
