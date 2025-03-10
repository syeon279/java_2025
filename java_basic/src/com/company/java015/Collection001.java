package com.company.java015;
//1. 콜렉션 프레임워크 - 동적배열
// 2. 배열의 단점 개선 - 한 가지 자료형의 사이즈 고정

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Collection001 {

	public static void main(String[] args) {
		//Step 1 . Array
		String[] arr = new String[3]; // 공간 3개 고정
		arr[0]="헐크";
		System.out.println(Arrays.toString(arr));
		
		// Step 2. 동적 배열-List (add-추가, get - 가져오기, size - 개수, remove - 삭제, contains - 포함) 
		List list = new ArrayList(); // 여러 자료형 - 공간은 내가 원하는 만큼. 
		list.add("one");
		list.add("3.14");
		list.add(3);
		System.out.println(list);
		
		//Step3. <>
		//  부모              = 자식/업캐스팅
		//List<String> list2 = new ArrayList<>();
//		List<String> list2 = new Vector<>();
		//List<String> list2 = new ArrayList<String>();
		
		//String이라는 자료형만 담을 수 있는 동적배열 
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("two");
//		list2.add(2);
		
		//Step 4. add, get, size, remove, contains
		list2.add("three");
		list2.add("four");
		
		System.out.println("갯수: "+list2.size());
		System.out.println("꺼내오기: "+list2.get(1));
		System.out.println("포함여부 : " +list2.contains("two"));
		System.out.println("삭제 : "+ list2.remove(1));
	}//E main

}// E class
