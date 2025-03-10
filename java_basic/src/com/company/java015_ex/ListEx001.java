package com.company.java015_ex;

import java.util.ArrayList;

public class ListEx001 {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		
		System.out.println(colors);
		
		for(int i = 0; i<colors.size();i++) {
			System.out.println(colors.get(i));
		} ///상향된 for 문 사용 불가
	}

}
