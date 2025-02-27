package com.company.java009;

public class Repeat006 {
	public static void hi() {
		System.out.println("hi");
		return ;
	}
	public static int hi(int name) { //void 를 쓰면 리턴이 없어도 됨.
		System.out.println("hi "+name+" 님!");
		return name ;
	}
	public static String hi(String name) {
		return "hi "+name;
	}

	public static void main(String[] args) {
		hi();
		hi(1);
		System.out.println(hi("Sally"));
	}

}
