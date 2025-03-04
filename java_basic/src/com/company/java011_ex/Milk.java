package com.company.java011_ex;
// public(아무데서나) > protected(extends) > package(같은 폴더) > private(클래스 내)
															  //getters/setters **

public class Milk {
	public Milk(int mno, String mname, int mprice) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mprice = mprice;
	}
  	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMprice() {
		return mprice;
	}
	@Override
	public String toString() {
		return "Milk [mno=" + mno + ", mname=" + mname + ", mprice=" + mprice + "]";
	}
	
	private int  mno;   
	private String mname;  
	private  int mprice;
	
	public Milk() {
	  mno=0; mname = null; mprice=0;
	}
	public void setMprice(int i) {
	  mprice = i;
	} 
  
}
