package com.company.java012_ex;

public class MobileNote9 extends MobileNote8 {
	private int battery;
	
	public int getBattery() { return battery; }
	public void setBattery(int battery) { this.battery = battery; }

	public MobileNote9(){
		super();
	}
	@Override public void newShow() {
		super.newShow();
		System.out.println(":::: NOTE9 새로운 기능");
		System.out.println("= battery 하루종일 사용가능!");
		System.out.println("= battery : " + battery);
	}
}