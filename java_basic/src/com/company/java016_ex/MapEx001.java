package com.company.java016_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("피구왕", "통키");
		map.put("제빵왕", "김탁구");
		map.put("요리왕", "비룡");
		
		System.out.println("======================");
		System.out.println("KING\tNAME");
		System.out.println("======================");
		for(Entry<String, String> m : map.entrySet() ) {
			System.out.println(m.getKey()+"\t"+m.getValue());
			System.out.println("------------------");
		}
		
		System.out.println("KING의 정보를 제공중입니다");
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름 입력> ");String tempName = scanner.next();
		Iterator <Entry <String, String>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, String> temp = iter.next();
			if(tempName.equals(temp.getKey())) { //if(map.containsKey(tempName))
				System.out.println(temp.getKey()+": "+temp.getValue());
			}
		}

	} //E main

} // E class

//2 다음과 같이 문제풀기
//==============================
//KING   NAME
//==============================
//피구왕   통키
//---------------------
//제빵왕   김탁구
//---------------------
//요리왕   비룡
//---------------------
//KING의 정보를 제공중입니다
//이름을 입력하세요> 제빵왕
//
//ㅁ제빵왕 : 김탁구