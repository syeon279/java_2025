package com.company.java012_ex;

class Color {
	String name;
	public String getName() { return name; }  
	public void setName(String name) { this.name = name; }

}//E Color

public class Green extends Color {
	int num;
	
	public int getNum() { return num; } 
	public void setNum(int num) { this.num = num; }
	
	public Green(){
		super();
	}
	public Green(String name, int num){
		super();
		this.name=name; this.num=num;
	}
	
	public void show() {
		System.out.println(":::: GREEN");
		System.out.println("= NAME : " + name);
		System.out.println("= NUM : " + num);
	}
}// E Green


