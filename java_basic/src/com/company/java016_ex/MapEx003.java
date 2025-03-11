package com.company.java016_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MapEx003 {

	public static void main(String[] args) {
		String[] data = { "A","D","B","D","B","D","B","C","E","C","B" };
		Integer count = 0;
		HashMap<String, Integer> map = new HashMap<>();

		//  map.put(data[0],  만약에 데이터 0이 있다면 없다면1 있다면 +1   1  :  );

		//{A=1, B=4, C=2, D=3, E=1}
		for(int i = 0; i<data.length; i++) {
			for(int j=0; j<data.length; j++) {
				if(data[i] == data[j]) {
					count++;
				} 
			}
			map.put( data[i],count );
		}

		System.out.println(map);
		
		Iterator<Entry<String, Integer>> sowon = map.entrySet().iterator();
		while(sowon.hasNext()) {
			Entry<String, Integer> s = sowon.next();
			System.out.println(s.getKey()+":"+"★".repeat(s.getValue())+s.getValue());
			}
		
	} // E main

} // E class
//1. 주어진조건
//String[] data = { "A","D","B","D","B","D","B","C","E","C","B" };
//HashMap<String, Integer> map = new HashMap<>();
//
//2. 다음과 같이 출력하시오.
//{A=1, B=4, C=2, D=3, E=1}
//A:#1
//B:####4
//C:##2
//D:###3
//E:#1
//보험왕 > [B]