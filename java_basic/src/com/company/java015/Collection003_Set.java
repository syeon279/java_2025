package com.company.java015;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// 1. 콜렉션 프레임워크 - [배열]의 단점을 개선한 [객체]만 저장 가능 (동적 배열)
// 2. List, Set, Map 
// List - 기차, 인덱스 있음, 중복허용  add, get, size, remove, contains
// Set - 주머니, 인덱스 없음, 중복 불허 add, 향상된 for문, Iterator(get 대신), size, remove, contains 

public class Collection003_Set {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one"); // 객체 저장
		list.add("one"); 
		list.add("two"); 
		list.add(new String("three")); 
		System.out.println(list.size()+" / "+list);
		
		Set<String> set = new HashSet<>();
		set.add("one"); // 객체 저장
		set.add("one"); 
		set.add("two"); 
		set.add(new String("three")); 
		System.out.println(set.size()+" / "+set); //3
		
		// add, get x, size, remove, contains
		
//		Set<int> set2 = new HashSet<>(); 
		Set<Integer> set2 = new HashSet<>(); // int 숫자 자료형, 객체만 저장
		// int -> Integer, float -> Float, double -> Double ,,,, Wrapper Class
		
		set2.add(1);
		set2.add(new Integer(2));
		set2.add(3);
		
		System.out.println(set2);
		
		int a  = 1; //값   기초값
		Integer e = 1; // 객체 wrapper - boxed 
		System.out.println(a+" / "+ e); // 1/1
		System.out.println(/*a.byteValue()*/ + e.byteValue());
		//1. 부품객체 (클래스) = 기초값 boxed
		//2. 클래스가 만들어놓은 기능들 사용가능
		//3. Integer.parseInt, Double.parseDouble, String.valueOf
		
		//for + size - get
		System.out.println("----");
		for(Integer e1 : set2) {
			System.out.println(e1); // 꺼내오기
		}
		
		System.out.println("1. add 2. size" + set2.size());
		System.out.println("3. remove : " + set2.remove(2));
		System.out.println("4. contains : " + set2.contains(5));
		
		Iterator <Integer> iter = set2.iterator(); // 줄을 서시오! iter -> [1,3]
//		System.out.println(iter);
//		System.out.println(set2.iterator());
		
		while(iter.hasNext()) { //2. 처리대상 확인 iter[->1,3]
//			iter.next(); //3.꺼내오기
			System.out.println(iter.next());
		}
	}

}
