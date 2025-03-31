package com.company.ioctest;

import java.util.List;

public class AnimalFarm {
	private String name;
	private Animal ani;
	private List<String>  skills;//# 추가
	
	
	
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal getAni() {
		return ani;
	}
	public void setAni(Animal ani) {
		this.ani = ani;
	}
	@Override
	public String toString() {
		return "AnimalFarm [name=" + name + ", ani=" + ani + "]";
	}
	public AnimalFarm(String name, Animal ani) {
		super();
		this.name = name;
		this.ani = ani;
	}
	public AnimalFarm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String aniSleep() { return name + ">" + ani.sleep(); }  //#
	public String aniEat()   { return name + ">" + ani.eat(); }
	public String aniPoo()   { return name + ">" + ani.poo(); }

	public void print() {  //#
		System.out.println(  aniSleep()); 
		System.out.println(  aniEat()); 
		System.out.println(  aniPoo()); 
	}
}
