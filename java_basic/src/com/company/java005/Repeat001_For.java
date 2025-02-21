package com.company.java005;

public class Repeat001_For {

	public static void main(String[] args) {
		//step1
		System.out.println("Step1) ");
		System.out.print(1 + "\t");   //{}
		System.out.print(2 + "\t");  
		System.out.print(3 + "\t");   
		
		
		//step2
		System.out.println("\n\nStep2) ");
		//{};
		for (int i = 1; i<=3; i++)
		{ System.out.print(i + "\t");}   
		
		//step3
		System.out.println("\n\nStep3) ");
		for (int i = 11; i<=20; i++)
		{ System.out.print(i + "\t");}   
		System.out.println();
		
		for (int i = 3; i<=8; i++)
		{ System.out.print(i + "\t");}   
		System.out.println();
		
		for (int i = 1; i<=10; i++)
		{ System.out.print(i + "\t");}   
		System.out.println();
		
		for (int i = 1; i<=5; i+=2)
		{ System.out.print(i + "\t");}   
		System.out.println();
		
	} //e main

} // e class
