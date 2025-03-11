package com.company.java016;

interface InterA2{
	void hi1();
	}    
interface InterB2{
	void hi2(String name);
	}  
interface InterC2{
	String hi3();
	}   
interface InterD2{  
	String hi4(int num, String name);
	} 

public class Lambda002 {

	public static void main(String[] args) {
		System.out.println("[STEP 1.] 매개 변수 x, 리턴값 x"); // void hi()
		// 1. 익명 객체
		InterA2 a1 = new InterA2() {
			 public void hi1() {
				System.out.println("안녕");
			}
		}; 
		a1.hi1();
		//1-1. 람다식
		InterA2 a12 = ()-> {System.out.println("안녕 -람다"); };
		a12.hi1();
		InterA2 a13 = ()-> System.out.println("안녕 -람다");
		a13.hi1();
		
		System.out.println("\n[STEP 2.] 매개 변수 o, 리턴값 x");
		// 2-1. 익명객체
		InterB2 b1 = new InterB2() {
			public void hi2(String name) {
				System.out.println("안녕, "+name);
			}
		};
		b1.hi2("Dan");
		
		//2-2. 람다식
		InterB2 b12 = (String name)-> {
			System.out.println("안녕, "+name+" -람다");
		};
		b12.hi2("Dan");
		
		InterB2 b13 = (name)-> { // String도 생략가능
			System.out.println("안녕, "+name+" -람다");
		};
		b13.hi2("Sally");
		
		InterB2 b14 = name->  // ()도 생략 가능
			System.out.println("안녕, "+name+" -람다");
		b14.hi2("alpha");
		
		System.out.println("\n[STEP 3.] 매개 변수 x, 리턴값 o");
		InterC2 c1 = new InterC2() {
			@Override
			public String hi3() {
				return "Good Day!";
			}
		};
		System.out.println(c1.hi3());
		
		//3-2 람다식
		InterC2 c2 = () -> {return "Have a -람다"; };
		System.out.println(c2.hi3());
		
		InterC2 c3 = () -> "Good Day! -람다"; 
		System.out.println(c3.hi3());
		
		System.out.println("\n[STEP 4.] 매개 변수 o, 리턴값 o");
		InterD2 d1 = new InterD2() {
			@Override
			public String hi4(int num, String name) {
				return num+"살, 이름은 "+name+"★".repeat(num);
			}
		};
		System.out.println(d1.hi4(4, "단이"));
		
		InterD2 d12 = (int num, String name)-> {
			return num+"살, 이름은 "+name + "★".repeat(num)+" -람다";
		};
		System.out.println(d12.hi4(4, "단이"));
		
		InterD2 d13 = (int num, String name)-> num+"살, 이름은 "+name + "★".repeat(num)+" -람다";
		System.out.println(d13.hi4(4, "단이"));
	} // E main

} // E class
 