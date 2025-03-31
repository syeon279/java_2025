package com.company.ioctest2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("animalFarm")
public class AnimalFarm {
	@Value("Aeong") private String name;
	@Autowired @Qualifier("cat") private Animal ani;
	private List<String>  skills;
	
	
	
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
