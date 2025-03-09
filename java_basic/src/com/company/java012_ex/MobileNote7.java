package com.company.java012_ex;

public class MobileNote7 {
	private String iris;

	public String getIris() { return iris; }
	public void setIris(String iris) { this.iris = iris; }
	
	void newShow() { //현재 package 상태 
		System.out.println(":::: NOTE7 새로운 기능");
		System.out.println("= iris 홍채 인식 기능!");
		System.out.println("=myiris : " + iris );
	}
	
}

