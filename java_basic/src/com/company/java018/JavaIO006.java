package com.company.java018;

public class JavaIO006 {

	public static void main(String[] args) {
		//#1. String 문자열 누적
		String str = "ABC";
		System.out.println("1. str 주소 : " +str+" "+ System.identityHashCode(str));
		
		str += "D";
		System.out.println("2. str 주소 : " +str+" "+ System.identityHashCode(str));
		
		StringBuffer sb = new StringBuffer();
		sb.append("ABC");
		System.out.println("3. sb 주소 : "+sb.toString()+" "+System.identityHashCode(sb));
		sb.append("D");
		System.out.println("3. sb 주소 : "+sb.toString()+" "+System.identityHashCode(sb));
	}

}
