package com.company.java017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;

class Milk{
	private int no;  private String name;  private int price;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Milk() {
		super();
	}
	
	public Milk(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}
	public Milk(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Milk [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, no, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milk other = (Milk) obj;
		return Objects.equals(name, other.name) && no == other.no && price == other.price;
	}
	
	
}

public class Repeat002 {

	public static void main(String[] args) {
		ArrayList<Milk> milks = new ArrayList<>();
		milks.add(new Milk(1, "white", 1000));
		milks.add(new Milk(2, "choco", 1200));
		milks.add(new Milk(3, "banana", 1300));
		
		System.out.println("======================\r\n"
				+ "NO\tNAME\tPRICE\r\n"
				+ "======================");
		for(Milk m : milks) {
			System.out.println(m.getNo()+"\t"+m.getName()+"\t"+m.getPrice());
		}
		
		System.out.println("------------------");
		HashSet<Milk> milksSet = new HashSet<>();
		milksSet.add(new Milk(1, "white", 1000));
		milksSet.add(new Milk(2, "choco", 1200));
		milksSet.add(new Milk(3, "banana", 1300));
		
		Iterator<Milk> iter = milksSet.iterator();
		System.out.println("======================\r\n"
				+ "NO\tNAME\tPRICE\r\n"
				+ "======================");
		while(iter.hasNext()) {
			Milk temp = iter.next();
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getPrice());
		}
		
		System.out.println("------------------");
		System.out.println("======================\r\n"
				+ "NO\tNAME\tPRICE\r\n"
				+ "======================");
		HashMap<Integer, Milk> milksMap = new HashMap<>();
		milksMap.put(1, new Milk("white", 1000));
		milksMap.put(2, new Milk("choco", 1200));
		milksMap.put(3, new Milk("banana", 1300));
		
		Iterator<Entry <Integer, Milk>> iterMap = milksMap.entrySet().iterator();
		while(iterMap.hasNext()) {
			Entry <Integer, Milk> m = iterMap.next();
			System.out.println(m.getKey()+"\t"+m.getValue().getName()+"\t"+m.getValue().getPrice());
		}
		
		
	} // E main
}// E class
//1. dto
//class Milk{
//	private int no;  private String name;  private int price;
//}          
//2. dto 를 이용하여 ArrayList + Iterator  이용해서 만들기     >>> ArrayList<Milk>
//3. dto 를 이용하여 HashSet   + Iterator  이용해서 만들기     >>> HashSet<Milk>  
// add size remove contains 향상된 for
//4. dto 를 이용하여 HashMap   + Iterator  이용해서 만들기     >>> HashMap<Integer, Milk>    
//
////ㅁ 출력된결과   (3번이 나와야함)
//======================
//NO	NAME	PRICE
//======================
//1	white	1000
//2	choco	1200
//3	banana	1300