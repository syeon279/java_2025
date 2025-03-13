package com.company.java018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

class Std {
	private String name;
	private int no, age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Std() {
		super();
	}
	public Std(String name, int no, int age) {
		super();
		this.name = name;
		this.no = no;
		this.age = age;
	}
	
}// E class

public class Repeat002 {
	public static void main(String[] args) {
		ArrayList<Std> score = new ArrayList<>();
		score.add( new Std ("Iron", 1, 45));
		score.add(new Std ("Hulk", 2, 38));
		score.add(new Std ("Captain", 3, 120));
		
		System.out.println("======================\r\n"
				+ "NO\tNAME\tAGE\r\n"
				+ "======================");
		
		Iterator<Std> iter = score.iterator();
		int total1 = 0;
		while(iter.hasNext()) {
			Std temp = iter.next();
			total1 += temp.getAge(); ///!
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getAge());
		}
		System.out.println("총 나이: " + total1);
		System.out.println("평균 나이: "+ String.format("%.2f", total1/3.0));
		// E ArrayList
		
		System.out.println("======================");
		HashSet<Std> scoreSet = new HashSet<>();
		scoreSet.add(new Std ("Iron", 1, 45));
		scoreSet.add(new Std ("Hulk", 2, 38));
		scoreSet.add(new Std ("Captain", 3, 120));
		
		System.out.println("======================\r\n"
				+ "NO\tNAME\tAGE\r\n"
				+ "======================");
		Iterator<Std> iterSet = scoreSet.iterator();
		while(iterSet.hasNext()) {
			Std temp = iterSet.next();
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getAge());
		}
		// E HashSet
		
		System.out.println("======================");
		HashMap <Integer, Std> scoreMap = new HashMap<>();
		scoreMap.put(1, new Std ("Iron", 1, 45));
		scoreMap.put(2, new Std ("Hulk", 2, 38));
		scoreMap.put(3, new Std ("Captain", 3, 120));
		
		System.out.println("======================\r\n"
				+ "NO\tNAME\tAGE\r\n"
				+ "======================");
		Iterator<Entry<Integer, Std>> iterMap = scoreMap.entrySet().iterator();
		while(iterMap.hasNext()) {
			Entry<Integer, Std> temp = iterMap.next();
			// UserInfo tmep = iter3. next().getValue();
			System.out.println(temp.getKey()+"\t"+temp.getValue().getName()+"\t"+temp.getValue().getAge());
		}
		int total = scoreMap.get(1).getAge() + scoreMap.get(2).getAge()+ scoreMap.get(3).getAge();
		System.out.println("나이총합: "+ total);
		System.out.println("나이평균: " + String.format("%.2f", total/(double)scoreMap.size())); //!
		// E HashMap 
		
		
	} // E main
} // E class
