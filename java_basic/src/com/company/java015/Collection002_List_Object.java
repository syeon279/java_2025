package com.company.java015;

import java.util.ArrayList;
import java.util.List;

class Milk{
	private int mno;
	private String name;
	private int mprice;
	
	public int getMno() { return mno; } 
	public void setMno(int mno) { this.mno = mno; }
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; }
	public int getMprice() { return mprice; } 
	public void setMprice(int mprice) { this.mprice = mprice; }
	
	@Override
	public String toString() {
		return "Milk [mno=" + mno + ", name=" + name + ", mprice=" + mprice + "]";
	}
	
	public Milk() {
		super();
	}
	public Milk(int mno, String name, int mprice) {
		super();
		this.mno = mno;
		this.name = name;
		this.mprice = mprice;
	}
	
	
}

public class Collection002_List_Object {
	public static void main(String[] args) {
		List<Milk> milks = new ArrayList<>();
		milks.add( new Milk(1,"white",1200) );
		milks.add( new Milk(2,"choco",1400) );
		milks.add( new Milk(3,"banana",1500) );
		
		
		for(int i=0;i<milks.size();i++) {
			Milk temp = milks.get(i);
			System.out.println(temp.getMno()+"/"+temp.getName()+"/"+temp.getMprice());
		}
		
		for(Milk temp : milks) {
			System.out.println(temp.getMno()+"/"+temp.getName()+"/"+temp.getMprice());
		}
	}

}
