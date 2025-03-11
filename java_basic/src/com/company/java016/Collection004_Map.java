package com.company.java016;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//List : ##5.   기차      인덱스여부 [ o ] ,  중복허용여부 [ o ] ,  [ add, get(index), size, remove, contain ] 
//Set  : ##6.   주머니   인덱스여부  [ x ] ,  중복허용여부  [ x ]  ,   [ add, 향상된 for문/Iterator, remove, contain ] 
//Map  : ##7.   사전      [ key, value ] - 쌍(Entry),        [ put, get(key), size, remove, contain ] 
public class Collection004_Map {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("One", "하나");
		map.put("Two", "두울");
		//map.put("One", "세엣"); // 키값이 같으면 덮어씀
		map.put("Three", "세엣");
		
		System.out.println(map);
		System.out.println(map.get("One"));
		System.out.println(map.size());
		
		System.out.println(map.remove("Three")); //key Object
		System.out.println(map);
		System.out.println(map.containsKey("Two"));
		System.out.println(map.keySet()); // key들만 모아줌
		System.out.println(map.values()); // 값들 모으기 
		System.out.println(map.entrySet()); 
		
		//출력 향상된 for
		for(Entry <String, String> e : map.entrySet() ) {
			System.out.println(e.getKey()+"/"+e.getValue());
		}
		
		// Iterator 권장사항
		// 1. key 모으기 
		// 2. 처리대상 확인
		// 3. 값 꺼내오기
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp + "/" + map.get(temp)); //map.get(temp) :  temp는 키, 키값으로 value가져옴. 
		}
		
		// Iterator 권장사항 2
		// 1. Entry 모으기 
		// 2. 처리대상 확인
		// 3. 값 꺼내오기
		Iterator <Entry <String, String>> eter = map.entrySet().iterator();
		while(eter.hasNext()) { //처리대상확인
			Entry<String,String> temp2 = eter.next();//3. 값꺼내오기
			System.out.println(temp2.getKey()+"/"+temp2.getValue());
		}
		
	} // E main

} // E class
