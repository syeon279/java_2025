package com.company.java012_ex;

public class MobileNote8 extends MobileNote7 {
	private String face;
	
	public String getFace() { return face; }
	public void setFace(String face) { this.face = face; }

	MobileNote8(){
		super();
	}
	@Override protected void newShow() {
		super.newShow();
		System.out.println(":::: NOTE8 새로운 기능");
		System.out.println("= face 안면 인식 기능!");
		System.out.println("=face : " + face );
	}
}

